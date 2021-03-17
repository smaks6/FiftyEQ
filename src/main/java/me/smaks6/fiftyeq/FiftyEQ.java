package me.smaks6.fiftyeq;

import me.smaks6.fiftyeq.events.DeathEvent;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class FiftyEQ extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println(ChatColor.GREEN + "=============================");
        System.out.println(ChatColor.GREEN + "       Enabling FiftyEQ");
        System.out.println(ChatColor.GREEN + "           by smaks6");
        System.out.println(ChatColor.GREEN + "=============================");

        getServer().getPluginManager().registerEvents(new DeathEvent(), this);
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.GREEN + "=============================");
        System.out.println(ChatColor.GREEN + "       Disabling FiftyEQ");
        System.out.println(ChatColor.GREEN + "           by smaks6");
        System.out.println(ChatColor.GREEN + "=============================");
    }
}
