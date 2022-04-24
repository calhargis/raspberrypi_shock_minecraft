package shock.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import shock.ShockPlugin;

/**
 * Command class for toggling shock
 */
public class ToggleShock implements CommandExecutor {
    /**
     * Instance of ShockPlugin class to add this command to
     */
    ShockPlugin plugin;

    /**
     * Public constructor for ToggleShock class
     * @param plugin Instance of ShockPlugin class to add this command to
     */
    public ToggleShock(ShockPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Function to be called when ToggleShock command is executed
     * @param sender Source of the command
     * @param command Command which was executed
     * @param s Alias of the command which was used
     * @param args Passed command arguments
     * @return True if shock was enabled; False if shock was disabled
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (plugin.setToggleShock()) {
            Bukkit.broadcastMessage(ChatColor.YELLOW + "SHOCK ON >:)");
            return true;
        }
        Bukkit.broadcastMessage(ChatColor.YELLOW + "SHOCK OFF");
        return false;
    }
}
