package shock.command;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import shock.ShockPlugin;

/**
 * Command class for setting first person to shock
 */
public class SetShock implements CommandExecutor {

    /**
     * Instance of ShockPlugin class to add this command to
     */
    ShockPlugin plugin;

    /**
     * Public constructor for SetShock class
     * @param plugin Instance of ShockPlugin class to add this command to
     */
    public SetShock(ShockPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Function to be called when SetShock command is executed
     * @param sender Source of the command
     * @param command Command which was executed
     * @param s Alias of the command which was used
     * @param args Passed command arguments
     * @return True if shock was enabled; False if shock was disabled
     */
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
