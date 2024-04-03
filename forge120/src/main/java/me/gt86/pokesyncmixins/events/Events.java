package me.gt86.pokesyncmixins.events;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.events.PokeBallImpactEvent;
import com.pixelmonmod.pixelmon.api.events.PokemonSendOutEvent;
import me.gt86.pokesyncmixins.api.SyncLock;
import me.gt86.pokesyncmixins.api.event.PokeSyncEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.UUID;

public class Events {
    public Events() {
        MinecraftForge.EVENT_BUS.register(this);
        Pixelmon.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void preSync(PokeSyncEvent.Pre event) {
        SyncLock.lock(event.getPlayer());
    }

    @SubscribeEvent
    public void completeSync(PokeSyncEvent.Complete event) {
        SyncLock.unlock(event.getPlayer());
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void sendOutPokemon(PokemonSendOutEvent event) {
        UUID uuid = event.getPlayer().getUUID();
        if (SyncLock.isSyncLocked(uuid)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void ballImpact(PokeBallImpactEvent event) {
        if (event.getEntityHit().isPresent()) {
            if (event.getEntityHit().get() instanceof ServerPlayer player) {
                if (SyncLock.isSyncLocked(player.getUUID())) {
                    event.setCanceled(true);
                }
            }
        }
    }

}
