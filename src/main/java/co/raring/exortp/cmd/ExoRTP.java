package co.raring.exortp.cmd;

import co.raring.exortp.tool.RandomArea;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ExoRTP implements CommandExecutor {
    private static final String MESSAGE_PREFIX = ChatColor.translateAlternateColorCodes('&', "");
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player plr = (Player) sender;
            if (args.length == 0) {
                RandomArea loc = new RandomArea(plr.getWorld());
                plr.teleport(loc.getLocation());
                plr.sendMessage("You have been teleported!");
            }
            if (args.length > 0) {

            }
        } else if(sender instanceof ConsoleCommandSender){

        } else {
            sender.sendMessage(ChatColor.DARK_RED + "Only players and console can use this command!");
        }
        return true;
    }
}
