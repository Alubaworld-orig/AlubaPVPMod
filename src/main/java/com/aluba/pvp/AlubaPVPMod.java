package com.aluba.pvp;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("alubapvpmod")
public class AlubaPVPMod {
    public static final String MOD_ID = "alubapvpmod";
    private static final Logger LOGGER = LogManager.getLogger();

    public AlubaPVPMod() {
        // Регистрация мода в системе Forge
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("AlubaPVPMod загружается...");
    }

    private void setup(final FMLClientSetupEvent event) {
        LOGGER.info("Клиентская часть AlubaPVPMod готова!");
    }
  }
