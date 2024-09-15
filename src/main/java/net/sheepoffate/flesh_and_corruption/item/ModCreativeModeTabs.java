package net.sheepoffate.flesh_and_corruption.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheepoffate.flesh_and_corruption.FleshAndCorruption;
import net.sheepoffate.flesh_and_corruption.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FleshAndCorruption.MOD_ID);

    public static final Supplier<CreativeModeTab> FLESH_AND_CORRUPTION_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("flesh_and_corruption_creative_mode_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.flesh_and_corruption.flesh_and_corruption_creative_mode_items_tab"))
                    .icon(() -> new ItemStack(ModItems.END_METAL_INGOT.get()))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModItems.END_METAL_INGOT);
                    }))
                    .build());

    public static final Supplier<CreativeModeTab> FLESH_AND_CORRUPTION_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("flesh_and_corruption_creative_mode_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.flesh_and_corruption.flesh_and_corruption_creative_mode_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.END_METAL_ORE.get()))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.END_METAL_ORE);
                    }))
                    .build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }




}
