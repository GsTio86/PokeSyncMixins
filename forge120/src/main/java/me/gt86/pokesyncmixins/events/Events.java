package me.gt86.pokesyncmixins.events;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.events.PokeBallImpactEvent;
import com.pixelmonmod.pixelmon.api.events.PokemonSendOutEvent;
import me.gt86.pokesyncmixins.api.SyncLock;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.UUID;

public class Events {
    public Events() {
        Pixelmon.EVENT_BUS.register(this);
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
