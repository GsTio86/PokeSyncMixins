package me.gt86.pokesyncmixins.mixins;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = MixinEntityPlayerExtension.class, remap = false)
public class MixinEntityPlayerExtension {

    @Overwrite
    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
    }
}
