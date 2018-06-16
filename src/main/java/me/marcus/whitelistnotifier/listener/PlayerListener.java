package me.marcus.whitelistnotifier.listener;

import me.marcus.whitelistnotifier.config.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {
        OfflinePlayer player = Bukkit.getOfflinePlayer(event.getUniqueId());

        if (player == null) {
            return;
        }

        if (player.isOp()) {
            return;
        }

        if (!Bukkit.hasWhitelist()) {
            return;
        }

        if (Bukkit.getWhitelistedPlayers().contains(player)) {
            return;
        }

        if (!Bukkit.getOnlinePlayers().isEmpty()) {
            for (Player staff : Bukkit.getOnlinePlayers()) {

                if (!staff.hasPermission(ConfigHandler.PERMISSION)) {
                    return;
                }

                staff.sendMessage(ConfigHandler.MESSAGE.replace("%player%", event.getName()));
            }
        }
    }
}
