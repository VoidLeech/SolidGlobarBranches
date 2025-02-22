package com.github.voidleech.solidglobarbranches.mixin.farming;

import com.github.voidleech.solidglobarbranches.reimagined.FlowerPlanting;
import net.mcreator.snifferent.block.BloomPlant0Block;
import net.mcreator.snifferent.block.BloomPlant1Block;
import net.mcreator.snifferent.block.BloomPlant2Block;
import net.mcreator.snifferent.block.BloomPlant4Block;
import net.mcreator.snifferent.block.Lumibulb0Block;
import net.mcreator.snifferent.block.Lumibulb1Block;
import net.mcreator.snifferent.block.Lumibulb2Block;
import net.mcreator.snifferent.block.Lumibulb3Block;
import net.mcreator.snifferent.block.Spindlefern0Block;
import net.mcreator.snifferent.block.Spindlefern1Block;
import net.mcreator.snifferent.block.Spindlefern2Block;
import net.mcreator.snifferent.block.Spindlefern3Block;
import net.mcreator.snifferent.block.Spineflower0Block;
import net.mcreator.snifferent.block.Spineflower1Block;
import net.mcreator.snifferent.block.Spineflower2Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = {BloomPlant0Block.class, BloomPlant1Block.class, BloomPlant2Block.class, BloomPlant4Block.class,
        Lumibulb0Block.class, Lumibulb1Block.class, Lumibulb2Block.class, Lumibulb3Block.class,
        Spindlefern0Block.class, Spindlefern1Block.class, Spindlefern2Block.class, Spindlefern3Block.class,
        Spineflower0Block.class, Spineflower1Block.class, Spineflower2Block.class})
public abstract class MayPlantOnMixin extends BushBlock {

    public MayPlantOnMixin(Properties properties) {
        super(properties);
    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter world, BlockPos pos){
        return FlowerPlanting.isFarmland(state);
    }
}
