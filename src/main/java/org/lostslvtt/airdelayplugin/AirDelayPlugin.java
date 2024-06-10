package org.lostslvtt.airdelayplugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;

public class AirDelayPlugin extends JavaPlugin {

    private static AirDelayPlugin instance;
    private FileConfiguration config;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        config = getConfig();

        getServer().getPluginManager().registerEvents(new AirDelayListener(), this);
        getCommand("airdelay").setExecutor(new CommandAirDelayReload());
        getCommand("airdelay").setTabCompleter(new AirDelayTabCompleter());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static AirDelayPlugin getInstance() {
        return instance;
    }

    public void reloadPluginConfig() {
        reloadConfig();
        config = getConfig();
    }

    public FileConfiguration getPluginConfig() {
        return config;
    }
}
