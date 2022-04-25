package shock;

import shock.command.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * JavaPlugin class containing main plugin code
 */
public class ShockPlugin extends JavaPlugin implements Listener {

    /**
     * Static boolean variable to determine whether the player has enabled shock damage
     */
    static Boolean toggleShock = false;

    /**
     * Static string containing the name of the first person to be shocked
     */
    static String playerToShock = "";

    /**
     * Static string containing the name of the second person to be shocked
     */
    static String playerToShock2 = "";

    /**
     * File path string of executable file 1
     */
    final String executableFile1 = "shockExecutable1.sh";

    /**
     * File path string of executable file 2
     */
    final String executableFile2 = "shockExecutable2.sh";

    /**
     * Path name of directory containing executable files
     */
    private String directory = "/home/pi/minecraft/";

    /**
     * Function to set first player to be shocked
     * @param playerToShock username of the person to be shocked
     */
    public void setPlayerToShock(String playerToShock) {
        ShockPlugin.playerToShock = playerToShock;
    }

    /**
     * Function to set first player to be shocked
     * @param playerToShock2 username of the person to be shocked
     */
    public void setPlayerToShock2(String playerToShock2) {
        ShockPlugin.playerToShock2 = playerToShock2;
    }

    /**
     * Setter for directory variable
     * @param directory Directory containing the executable files
     */
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    /**
     * Inverts the boolean value of toggleShock
     * @return the value of toggleShock after function is called and value is inverted
     */
    public boolean setToggleShock() {
        if (toggleShock) {
            toggleShock = false;
            return false;
        }
        else {
            toggleShock = true;
            return true;
        }

    }

    /**
     * Set commands for executor
     */
    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("setshock")).setExecutor(new SetShock(this));
        getLogger().info("Added the 'setshock' command.");

        Objects.requireNonNull(this.getCommand("setshock2")).setExecutor(new SetShock2(this));
        getLogger().info("Added the 'setshock2' command.");

        Objects.requireNonNull(this.getCommand("toggleshock")).setExecutor(new ToggleShock(this));
        getLogger().info("Added the 'toggleshock' command.");

        Objects.requireNonNull(this.getCommand("setdirectory")).setExecutor(new SetDirectory(this));
        getLogger().info("Added the 'setdirectory' command.");

        System.out.println("Plugin Running");
        getServer().getPluginManager().registerEvents(this, this);
    }

    /**
     * Empty onDisable function
     */
    @Override
    public void onDisable(){
    }

    /**
     * Executes shock executable file for first person to shock
     */
    public void shock1() {
        try {
            Runtime.getRuntime().exec(directory + executableFile1, null, new File(directory));
        } catch (IOException e) {
            System.out.println("Failed to run executable file 1");
            e.printStackTrace();
        }
    }

    /**
     * Executes shock executable file for second person to shock
     */
    public void shock2() {
        try {
            Runtime.getRuntime().exec(directory + executableFile2, null, new File(directory));
        } catch (IOException e) {
            System.out.println("Failed to run executable file 2");
            e.printStackTrace();
        }
    }

    /**
     * function to determine if damage was taken during an EntityDamageEvent
     * @param e EntityDamageEvent to determine if damage was taken
     */
    @EventHandler
    public void playerDamaged(EntityDamageEvent e) {
        if (!toggleShock) {
            return;
        }
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();

            if (e.getFinalDamage() == 0) {
                return;
            }
            if (p.getName().equals(playerToShock)) {
                shock1();
            }
            if (p.getName().equals(playerToShock2)) {
                shock2();
            }
        }
    }
}