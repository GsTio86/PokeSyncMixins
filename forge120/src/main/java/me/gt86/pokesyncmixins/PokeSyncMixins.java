package me.gt86.pokesyncmixins;

import me.gt86.pokesyncmixins.events.Events;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("pokesyncmixins")
public class PokeSyncMixins {
    private static final Logger LOGGER = LogManager.getLogger();

    public PokeSyncMixins() {
        init();
        LOGGER.log(Level.INFO, "Loaded!");
    }

    public void init() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);
    }

    @SubscribeEvent
    public void setup(FMLCommonSetupEvent event) {
        new Events();
    }

}
