package me.smaks6.fiftyeq.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class PlayerDeathListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerDeath(PlayerDeathEvent event) {
        final Player player = event.getEntity();

        // Clearing all drops from player, because we will drop it manually
        List<ItemStack> drops = event.getDrops();
        drops.clear();

        List<ItemStack> inventoryContent = this.getInventoryContent(player);

        int length = (inventoryContent.size() - 1) / 2;

        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < length; i++) {
            int randomValue = random.nextInt(length);
            inventoryContent.remove(randomValue);
        }

        drops.addAll(inventoryContent);
    }

    private List<ItemStack> getInventoryContent(Player player) {
        return Arrays.stream(player.getInventory().getContents())
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
