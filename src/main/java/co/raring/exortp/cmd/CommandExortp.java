package co.raring.exortp.cmd;

import co.raring.exortp.tool.RandomArea;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandExortp implements CommandExecutor {
    private String MESSAGE_PREFIX = ChatColor.translateAlternateColorCodes('&', "&b[&cExo&6RTP&b]&9 ");
    public CommandExortp(String prefix) {
        MESSAGE_PREFIX = ChatColor.translateAlternateColorCodes('&', prefix + " ");
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player plr = (Player) sender;
            if (args.length == 0) {
                RandomArea ra = new RandomArea(plr.getWorld());
                plr.teleport(ra.getLocation());
                plr.sendMessage(MESSAGE_PREFIX + "You have been randomly teleported!");
            } else {
                plr.sendMessage(MESSAGE_PREFIX + ChatColor.RED + "Syntax error! Perhaps you meant " + ChatColor.GRAY + "/rtp" + ChatColor.RED + "?");
                return true;
            }
        } else if(sender instanceof ConsoleCommandSender){
            sender.sendMessage(MESSAGE_PREFIX + "/exortp doesn't work with console, yet!");
        } else {
            sender.sendMessage(ChatColor.DARK_RED + "Only players and console can use this command!");
        }
        return true;
    }
}
