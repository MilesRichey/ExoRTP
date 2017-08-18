package co.raring.exortp;

import co.raring.exortp.cmd.CommandExortp;
import co.raring.exortp.tool.RandomArea;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {
    private static Plugin core;


    @Override
    public void onEnable() {
        core = this;
        saveDefaultConfig();
        //Set min/max in RandomArea
        RandomArea.minX = getConfig().getDouble("min-x");
        RandomArea.minZ = getConfig().getDouble("min-z");
        RandomArea.maxX = getConfig().getDouble("max-x");
        RandomArea.maxZ = getConfig().getDouble("max-z");
        getCommand("exortp").setExecutor(new CommandExortp(getConfig().getString("prefix")));
    }

    @Override
    public void onDisable() {

    }
    public static Plugin getPlugin() {
        return core;
    }
}
