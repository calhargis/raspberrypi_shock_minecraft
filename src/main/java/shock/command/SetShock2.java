package shock.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import shock.ShockPlugin;

public class SetShock2 implements CommandExecutor {
    ShockPlugin plugin;

    public SetShock2(ShockPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length == 1) {
            plugin.setPlayerToShock2(args[0]);
            Bukkit.broadcastMessage(ChatColor.GREEN + args[0] + " set as second player to shock");
            return true;
        }
        else {
            sender.sendMessage("type:\"setshock [player name]\"");
        }
        return false;
    }
}
