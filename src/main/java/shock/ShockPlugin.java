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

public class ShockPlugin extends JavaPlugin implements Listener {

    static Boolean toggleShock = false;
    static String playerToShock = "";
    static String playerToShock2 = "";


    public void setPlayerToShock(String playerToShock) {
        ShockPlugin.playerToShock = playerToShock;
    }

    public void setPlayerToShock2(String playerToShock2) {
        ShockPlugin.playerToShock2 = playerToShock2;
    }

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

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("setshock")).setExecutor(new SetShock(this));
        getLogger().info("Added the 'setshock' command.");
        Objects.requireNonNull(this.getCommand("setshock2")).setExecutor(new SetShock2(this));
        getLogger().info("Added the 'setshock2' command.");
        Objects.requireNonNull(this.getCommand("toggleshock")).setExecutor(new ToggleShock(this));
        getLogger().info("Added the 'toggleshock' command.");
        System.out.println("Plugin Running");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable(){
    }

    public void shock1() {
        try {
            Runtime.getRuntime().exec("/home/pi/minecraft/shockDallin.sh", null, new File("/home/pi/minecraft"));
        } catch (IOException e) {
            System.out.println("failed");
            e.printStackTrace();
        }
    }

    public void shock2() {
        try {
            Runtime.getRuntime().exec("/home/pi/minecraft/shockCal.sh", null, new File("/home/pi/minecraft"));
        } catch (IOException e) {
            System.out.println("failed");
            e.printStackTrace();
        }
    }



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