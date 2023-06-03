package com.github.ringoame196.itemname;

import com.github.ringoame196.itemname.Commands.itemname;
import org.bukkit.plugin.java.JavaPlugin;

public final class Itemname extends JavaPlugin {

    private static JavaPlugin plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        super.onEnable();

        getCommand("itemname").setExecutor(new itemname());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        super.onDisable();

    }
    public static JavaPlugin getPlugin(){return plugin;}
}
