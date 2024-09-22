package net.sheepoffate.flesh_and_corruption.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheepoffate.flesh_and_corruption.FleshAndCorruption;

public class ModItems {

    public static final DeferredRegister.Items ITEMS= DeferredRegister.createItems(FleshAndCorruption.MOD_ID);

    //Register new items here
    public static final DeferredItem<Item> END_METAL_INGOT = ITEMS.registerSimpleItem("end_metal_ingot");
    public static final DeferredItem<Item> RAW_END_METAL = ITEMS.registerSimpleItem("raw_end_metal");
    public static final DeferredItem<Item> ENDER_FRAGMENT = ITEMS.registerSimpleItem("ender_fragment");

    //

    public static void register (IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
