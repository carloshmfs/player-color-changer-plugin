package carloshmfs.playercolorchanger;

import org.bukkit.plugin.java.JavaPlugin;

public class PlayerColorChanger extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Hello World From MyPLUGIN");
    }

    @Override
    public void onDisable() {
        getLogger().info("goodbye cruel world From MyPLUGIN");
    }
}

