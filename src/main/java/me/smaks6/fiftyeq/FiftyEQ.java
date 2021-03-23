package me.smaks6.fiftyeq;

import me.smaks6.fiftyeq.listener.PlayerDeathListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class FiftyEQ extends JavaPlugin {

    @Override
    public void onEnable() {
        Logger logger = this.getLogger();
        logger.info("=============================");
        logger.info("       Enabling FiftyEQ");
        logger.info("           by smaks6");
        logger.info("=============================");

        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerDeathListener(), this);
    }

    @Override
    public void onDisable() {
        Logger logger = this.getLogger();
        logger.info("=============================");
        logger.info("       Disabling FiftyEQ");
        logger.info("           by smaks6");
        logger.info("=============================");
    }
}
