package dev.cmccall.oxygenDeficiency;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class OxygenDeficiency extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new Events(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
