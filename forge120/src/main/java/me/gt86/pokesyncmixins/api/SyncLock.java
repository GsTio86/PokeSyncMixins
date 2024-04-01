package me.gt86.pokesyncmixins.api;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class SyncLock {

    private static Set<UUID> syncLockPlayer = new HashSet<>();

    public static boolean isSyncLocked(UUID player) {
        return syncLockPlayer.contains(player);
    }

    public static void setSyncLock(UUID player, boolean lock) {
        if (lock) {
            lock(player);
        } else {
            unlock(player);
        }
    }

    public static void lock(UUID player) {
        syncLockPlayer.add(player);
    }

    public static void unlock(UUID player) {
        syncLockPlayer.remove(player);
    }
}
