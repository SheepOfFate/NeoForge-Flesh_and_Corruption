package net.sheepoffate.flesh_and_corruption.datagen;

import net.sheepoffate.flesh_and_corruption.FleshAndCorruption;
import net.sheepoffate.flesh_and_corruption.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.awt.*;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FleshAndCorruption.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
       // blockWithItem(ModBlocks.BLACK_OPAL_BLOCK);

        blockWithItem(ModBlocks.END_METAL_ORE);
        blockWithItem(ModBlocks.RAW_END_METAL_BLOCK);
        blockWithItem(ModBlocks.END_METAL_BLOCK);
        blockWithItem(ModBlocks.FLESH_ORE);
        blockWithItem(ModBlocks.FLESH_BLOCK);
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("flesh_and_corruption:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("flesh_and_corruption:block/" + deferredBlock.getId().getPath() + appendix));
    }
}