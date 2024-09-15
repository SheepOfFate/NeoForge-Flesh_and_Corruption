package net.sheepoffate.flesh_and_corruption.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheepoffate.flesh_and_corruption.FleshAndCorruption;
import net.sheepoffate.flesh_and_corruption.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FleshAndCorruption.MOD_ID);

    //Create new blocks
    public static final DeferredBlock<Block> END_METAL_ORE = registerBlock("end_metal_ore",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));


    private static <T extends Block>DeferredBlock<T> registerBlock(String name, Supplier<T>block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T>block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register (IEventBus eventBus){
        BLOCKS.register(eventBus);
    }


}
