package me.marcus.whitelistnotifier;

import lombok.Getter;
import me.marcus.whitelistnotifier.config.ConfigHandler;
import me.marcus.whitelistnotifier.config.FileConfig;
import me.marcus.whitelistnotifier.listener.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class WhitelistNotifier extends JavaPlugin {

    @Getter
    private static WhitelistNotifier instance;

    private FileConfig mainConfig;

    private void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onEnable() {
        instance = this;

        this.mainConfig = new FileConfig(this, "config.yml");

        new ConfigHandler();

        this.registerListeners();
    }

    @Override
    public void onDisable() {

    }
}
