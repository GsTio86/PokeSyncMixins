package me.gt86.pokesyncmixins.mixins;

import com.pixelmonmod.pixelmon.listener.PixelmonPlayerTracker;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = PixelmonPlayerTracker.class, remap = false)
public class MixinPixelmonPlayerTracker {

    @Overwrite
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {

    }
}
