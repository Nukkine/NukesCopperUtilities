package net.nukkine.nukescopperutilities;

import net.fabricmc.api.ModInitializer;

import net.nukkine.nukescopperutilities.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NukesCopperUtilities implements ModInitializer {
    public static final String MOD_ID = "nukescopperutilities";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
    }
}