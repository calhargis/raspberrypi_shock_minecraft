package shock.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import shock.ShockPlugin;

public class ToggleShock implements CommandExecutor {
    ShockPlugin plugin;

    public ToggleShock(ShockPlugin plugin) {
        this.plugin = plugin;
    }

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
