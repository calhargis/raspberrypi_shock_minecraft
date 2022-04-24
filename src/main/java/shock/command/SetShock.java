package shock.command;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import shock.ShockPlugin;

public class SetShock implements CommandExecutor {

    ShockPlugin plugin;

    public SetShock(ShockPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length == 1) {
            plugin.setPlayerToShock(args[0]);
            Bukkit.broadcastMessage(ChatColor.AQUA + args[0] + " set as player to shock");
            return true;
        }
        else {
            sender.sendMessage("type:\"setshock [player name]\"");
        }
        return false;
    }
}
