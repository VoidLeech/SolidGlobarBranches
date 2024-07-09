package com.github.voidleech.solidglobarbranches.mixin.amber;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.snifferent.block.AmberGlassBlock;
import net.mcreator.snifferent.init.SnifferentModBlocks;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AmberGlassBlock.class)
public class AmberGlassMixin extends Block {
    public AmberGlassMixin(Properties pProperties) {
        super(pProperties);
    }

    @ModifyExpressionValue(method = "skipRendering(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/Direction;)Z",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getBlock()Lnet/minecraft/world/level/block/Block;"))
    private Block sgb$allAmberGlassEqual(Block original){
        if (original == SnifferentModBlocks.AMBER_GLASS_GLOWING.get()){
            return SnifferentModBlocks.AMBER_GLASS.get();
        }
        return original;
    }
}
