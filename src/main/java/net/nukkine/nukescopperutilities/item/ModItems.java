package net.nukkine.nukescopperutilities.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.nukkine.nukescopperutilities.NukesCopperUtilities;
import net.nukkine.nukescopperutilities.NukesCopperUtilitiesClient;

public class ModItems {

    public static final Item COPPER_APPLE;
    public static final Item COPPER_POTATO;

    static {
        COPPER_APPLE = registerItem("copper_apple", ItemGroups.FOOD_AND_DRINK, new Item(
                new Item.Settings().rarity(Rarity.UNCOMMON).food(
                        new FoodComponent.Builder().
                        hunger(4).saturationModifier(1F).
                        statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 0), 1.0F).
                        statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 0), 1.0F).
                        alwaysEdible().
                        build()
                )
        ));

        COPPER_POTATO = registerItem("copper_potato", ItemGroups.FOOD_AND_DRINK, new Item(
                new Item.Settings().rarity(Rarity.COMMON).food(
                        new FoodComponent.Builder().
                        hunger(6).saturationModifier(0.8F).
                        build()
                )
        ));
    }

    private static Item registerItem(String name, RegistryKey<ItemGroup> group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(NukesCopperUtilities.MOD_ID, name), item);
    }

    public static void registerModItems() {
        NukesCopperUtilities.LOGGER.debug("Registering mod items for " + NukesCopperUtilities.MOD_ID);
    }
}
