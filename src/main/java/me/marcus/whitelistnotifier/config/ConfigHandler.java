package me.marcus.whitelistnotifier.config;

import me.marcus.whitelistnotifier.WhitelistNotifier;
import me.marcus.whitelistnotifier.util.ChatUtil;

public class ConfigHandler {

    public static String MESSAGE;
    public static String PERMISSION;

    public ConfigHandler() {
        ConfigCursor mainConfigCursor = new ConfigCursor(WhitelistNotifier.getInstance().getMainConfig(), "");

        MESSAGE = ChatUtil.toChatColor(mainConfigCursor.getString("MESSAGE"));
        PERMISSION = ChatUtil.toChatColor(mainConfigCursor.getString("PERMISSION"));
    }
}
