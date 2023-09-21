package me.smaks6.fiftyeq.events;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class DeathEvent implements Listener {
    private final Random random = new Random();

    @EventHandler
    public void deathEvent(PlayerDeathEvent event) {
        Player player = event.getEntity();
        PlayerInventory inventory = player.getInventory();
        ItemStack[] contents = inventory.getContents();

        int halfSize = contents.length / 2;

        ItemStack[] droppedItems = new ItemStack[halfSize];

        for (int i = 0; i < halfSize; i++) {
            int randomIndex = random.nextInt(contents.length);
            droppedItems[i] = contents[randomIndex];
            contents[randomIndex] = null;
        }
        inventory.setContents(contents);

        Location location = player.getLocation();
        World world = location.getWorld();
        for (ItemStack item : droppedItems) {
            if (item != null && world != null) {
                world.dropItemNaturally(location, item);
            }
        }

        event.setKeepInventory(true);
        event.getDrops().removeAll(event.getDrops());
    }

}
