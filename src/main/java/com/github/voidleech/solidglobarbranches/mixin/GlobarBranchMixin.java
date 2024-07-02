package com.github.voidleech.solidglobarbranches.mixin;

import com.github.voidleech.solidglobarbranches.registry.SGBTags;
import net.mcreator.snifferent.block.GlobarBranchMiddleBlock;
import net.mcreator.snifferent.init.SnifferentModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(GlobarBranchMiddleBlock.class)
public class GlobarBranchMixin extends Block {
    @Shadow @Final public static DirectionProperty FACING;

    public GlobarBranchMixin(Properties pProperties) {
        super(pProperties);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void sgb$branchCollision(CallbackInfo ci){
        // Sufficient for collision
        this.hasCollision = true;

        // Adjust this.properties in case another mod needs this.properties to be accurate
        this.properties.hasCollision = true;
        // Change push reaction so branches get destroyed like leaves # why is this not part of Block
        this.properties.pushReaction = PushReaction.DESTROY;
        // Remake state definition s.t. property changes are reflected in-game
        StateDefinition.Builder<Block, BlockState> builder = new StateDefinition.Builder<>(this);
        this.createBlockStateDefinition(builder);
        this.stateDefinition = builder.create(Block::defaultBlockState, BlockState::new);
        this.registerDefaultState(this.stateDefinition.any());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx){
        return switch (state.getValue(FACING)) {
            case EAST, WEST -> box(0.0, 6.0, 6.0, 16.0, 10.0, 10.0);
            default -> // NORTH/SOUTH
                    box(6.0, 6.0, 0.0, 10.0, 10.0, 16.0);
        };
    }

    // This method might not be fully accurate if chunks aren't loaded, but I haven't seen been able to have that happen in-world in my testing
    // Tongue-in-cheek, at how long such a branch has to be, I might even call it a feature :p
    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos){
        if (level instanceof LevelAccessor world){
            Direction facing = state.getValue(FACING);
            BlockPos vec = switch (facing){
                case EAST, WEST -> BlockPos.containing(1, 0, 0);
                default -> BlockPos.containing(0, 0, 1);
            };
            Direction POS = switch (facing){
                case EAST, WEST -> Direction.EAST;
                default -> Direction.SOUTH;
            };
            Direction NEG = POS.getOpposite();

            BlockPos targetPos = BlockPos.containing(pos.getX(), pos.getY(), pos.getZ());
            while(true){
                targetPos = targetPos.offset(vec);
                if (world.isAreaLoaded(targetPos, 1)){
                    if (world.getBlockState(targetPos).isFaceSturdy(world, targetPos, NEG)){
                        return true;
                    }
                    BlockState bs = world.getBlockState(targetPos);
                    if (bs.getBlock() == SnifferentModBlocks.GLOBAR_BRANCH_MIDDLE.get() && (bs.getValue(FACING) == POS || bs.getValue(FACING) == NEG)){
                        continue;
                    }
                    // Non-branch block without a solid face to support us, check other side
                }
                break;
            }
            targetPos = BlockPos.containing(pos.getX(), pos.getY(), pos.getZ());
            vec = vec.multiply(-1);
            while(true){
                targetPos = targetPos.offset(vec);
                if (world.isAreaLoaded(targetPos, 1)){
                    if (world.getBlockState(targetPos).isFaceSturdy(world, targetPos, POS)){
                        return true;
                    }
                    BlockState bs = world.getBlockState(targetPos);
                    if (bs.getBlock() == SnifferentModBlocks.GLOBAR_BRANCH_MIDDLE.get() && (bs.getValue(FACING) == POS || bs.getValue(FACING) == NEG)){
                        continue;
                    }
                }
                return false;
            }
        }
        return super.canSurvive(state, level, pos);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos currentPos, BlockPos neighborPos) {
        return !state.canSurvive(world, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, neighborState, world, currentPos, neighborPos);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx){
        BlockState state = this.defaultBlockState();
        Level level = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        Direction[] directions = ctx.getNearestLookingDirections();
        for (Direction direction : directions){
            if (direction.getAxis().isHorizontal()) {
                state = state.setValue(FACING, direction.getOpposite());
                if (state.canSurvive(level, pos)){
                    return state;
                }
            }
        }
        // Cannot place it in this position, state we return is going to go unused, return default state
        return this.defaultBlockState();
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float distance){
        super.fallOn(level, state, pos, entity, distance);
        // Break if fall > 2.5 blocks
        float maxFall = 2.5f;
        Consumer<Float> breakBlock = (d) -> {
            if (distance > d) {
                level.destroyBlock(pos, false);
            }
        };

        // By default, non-living entities don't break branches, unless included
        if (entity.getType().is(SGBTags.NONLIVING_DOES_BREAK_BRANCHES)){
            breakBlock.accept(maxFall);
        }
        if (!(entity instanceof LivingEntity livingEntity)) {
            return;
        }
        // By default, living entities do break branches, unless excluded
        if (entity.getType().is(SGBTags.LIVING_DOESNT_BREAK_BRANCHES)){
            return;
        }
        if (livingEntity.hasEffect(MobEffects.SLOW_FALLING)){
            return;
        }

        // Adjust maximum fall height by feather falling level
        maxFall *= (1.0f + EnchantmentHelper.getEnchantmentLevel(Enchantments.FALL_PROTECTION, livingEntity));
        breakBlock.accept(maxFall);
    }
}
