package co.raring.exortp;

import co.raring.exortp.cmd.ExoRTP;
import co.raring.exortp.tool.RandomArea;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    @Override
    public void onEnable() {
        RandomArea.minX = getConfig().getDouble("min-x");
        RandomArea.minZ = getConfig().getDouble("min-z");
        RandomArea.maxX = getConfig().getDouble("max-x");
        RandomArea.maxZ = getConfig().getDouble("max-z");
        getCommand("exortp").setExecutor(new ExoRTP());
    }

    @Override
    public void onDisable() {

    }
}
