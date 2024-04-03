package me.gt86.pokesyncmixins.api.event;

import net.minecraftforge.eventbus.api.Event;

import java.util.UUID;

public class PokeSyncEvent extends Event {
    private final UUID player;

    public PokeSyncEvent(UUID player) {
        this.player = player;
    }

    public UUID getPlayer() {
        return this.player;
    }

    public static class Pre extends PokeSyncEvent {
        public Pre(UUID player) {
            super(player);
        }
    }

    public static class Complete extends PokeSyncEvent {
        public Complete(UUID player) {
            super(player);
        }
    }

}
