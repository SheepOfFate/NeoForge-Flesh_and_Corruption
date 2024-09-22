package net.sheepoffate.flesh_and_corruption.datagen;

import net.sheepoffate.flesh_and_corruption.FleshAndCorruption;
import net.sheepoffate.flesh_and_corruption.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FleshAndCorruption.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.END_METAL_ORE.get());



        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add((ModBlocks.END_METAL_ORE.get()));


    }
}