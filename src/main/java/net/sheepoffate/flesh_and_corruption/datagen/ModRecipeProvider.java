package net.sheepoffate.flesh_and_corruption.datagen;

import net.minecraft.world.item.Items;
import net.sheepoffate.flesh_and_corruption.FleshAndCorruption;
import net.sheepoffate.flesh_and_corruption.block.ModBlocks;
import net.sheepoffate.flesh_and_corruption.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> END_METAL_SMELTABLES = List.of(ModItems.RAW_END_METAL,
                ModBlocks.END_METAL_ORE);

        List<ItemLike> FLESH_SMELTABLES = List.of(ModItems.RAW_FLESH_NUGGET,
                ModBlocks.FLESH_ORE);

        List<ItemLike> END_METAL_BLOCK_SMELTABLES = List.of(ModBlocks.END_METAL_BLOCK,
                ModBlocks.RAW_END_METAL_BLOCK);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ENDER_FRAGMENT.get(), 4)
                        .requires(Items.ENDER_PEARL)
                        .unlockedBy("has_ender_pearl", has(Items.ENDER_PEARL)).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.END_METAL_INGOT.get(), 9)
                        .requires(ModBlocks.END_METAL_BLOCK)
                        .unlockedBy("has_end_metal_block", has(ModBlocks.END_METAL_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FLESH_INGOT.get(), 9)
                        .requires(ModBlocks.FLESH_BLOCK)
                        .unlockedBy("has_flesh_block", has(ModBlocks.FLESH_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_END_METAL.get(), 9)
                        .requires(ModBlocks.RAW_END_METAL_BLOCK)
                        .unlockedBy("has_raw_end_metal_block", has(ModBlocks.RAW_END_METAL_BLOCK.get())).save(pRecipeOutput);



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ENDER_PEARL)
                        .pattern(" A ")
                        .pattern("A A")
                        .pattern(" A ")
                                .define('A', ModItems.ENDER_FRAGMENT.get())
                                        .unlockedBy("has_ender_fragment", has(ModItems.ENDER_FRAGMENT.get())).save(pRecipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.FLESH_BLOCK.get())
                        .pattern("AAA")
                        .pattern("AAA")
                        .pattern("AAA")
                                .define('A', ModItems.FLESH_INGOT.get())
                                        .unlockedBy("has_flesh_ingot", has(ModItems.FLESH_INGOT.get())).save(pRecipeOutput);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.END_METAL_BLOCK.get())
                        .pattern("AAA")
                        .pattern("AAA")
                        .pattern("AAA")
                                .define('A', ModItems.END_METAL_INGOT.get())
                                        .unlockedBy("has_end_metal_ingot", has(ModItems.END_METAL_INGOT.get())).save(pRecipeOutput);

                 ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_END_METAL_BLOCK.get())
                        .pattern("AAA")
                        .pattern("AAA")
                        .pattern("AAA")
                                .define('A', ModItems.RAW_END_METAL.get())
                                        .unlockedBy("has_raw_end_metal", has(ModItems.RAW_END_METAL.get())).save(pRecipeOutput);



        oreSmelting(pRecipeOutput, END_METAL_SMELTABLES, RecipeCategory.MISC, ModItems.END_METAL_INGOT.get(), 0.25f, 200, "end_metal");
        oreBlasting(pRecipeOutput, END_METAL_SMELTABLES, RecipeCategory.MISC, ModItems.END_METAL_INGOT.get(), 0.25f, 100, "end_metal");
        oreSmelting(pRecipeOutput, FLESH_SMELTABLES, RecipeCategory.MISC, ModItems.FLESH_INGOT.get(), 0.1f, 200, "flesh_metal");
        oreBlasting(pRecipeOutput, FLESH_SMELTABLES, RecipeCategory.MISC, ModItems.FLESH_INGOT.get(), 0.1f, 100, "flesh_metal");
    }

    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, FleshAndCorruption.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}