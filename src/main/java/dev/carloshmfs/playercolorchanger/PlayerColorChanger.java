package dev.carloshmfs.playercolorchanger;

import org.bukkit.plugin.java.JavaPlugin;

public class PlayerColorChanger extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Hello World from PlayerColorChanger plugin");

        this.getCommand("setcolor").setExecutor(new SetPlayerColorCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("Goodbye cruel world From PlayerColorChanger plugin");
    }
}

