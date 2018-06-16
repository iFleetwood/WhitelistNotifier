package me.marcus.whitelistnotifier.util;

import org.bukkit.ChatColor;

public class ChatUtil {

    public static String toChatColor(String from) {
        return ChatColor.translateAlternateColorCodes('&', from);
    }
}
