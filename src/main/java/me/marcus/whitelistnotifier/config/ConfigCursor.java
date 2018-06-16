package me.marcus.whitelistnotifier.config;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
public class ConfigCursor {

    private final FileConfig fileConfig;
    @Setter private String path;

    public boolean exists() {
        return this.fileConfig.getConfig().contains(this.path);
    }

    public Set<String> getKeys() {
        return this.fileConfig.getConfig().getConfigurationSection(this.path).getKeys(false);
    }

    public String getString(String path) {
        return this.fileConfig.getConfig().getString(this.path + "." + path);
    }

    public int getInt(String path) {
        return this.fileConfig.getConfig().getInt(this.path + "." + path);
    }

    public boolean isBool(String path) {
        return this.fileConfig.getConfig().getBoolean(this.path + "." + path);
    }

    public List<String> getStringList(String path) {
        return this.fileConfig.getConfig().getStringList(this.path + "." + path);
    }

    public UUID getUuid(String path) {
        return UUID.fromString(this.fileConfig.getConfig().getString(this.path + "." + path));
    }

    public World getWorld(String path) {
        return Bukkit.getWorld(this.fileConfig.getConfig().getString(this.path + ".", path));
    }

    public void set(String path, Object value) {
        this.fileConfig.getConfig().set(this.path + "." + path, value);
    }

    public void save() {
        this.fileConfig.save();
    }
}
