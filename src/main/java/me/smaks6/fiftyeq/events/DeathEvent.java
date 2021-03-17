package me.smaks6.fiftyeq.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Random;

public class DeathEvent implements Listener {

    @EventHandler
    public void deathEvent(PlayerDeathEvent event){
        Player player = event.getEntity();

        event.setKeepInventory(true);

        ArrayList<ItemStack> dropItems = getList(player);

        dropItems = random(dropItems);

        removeItem(dropItems, player);

        dropItem(dropItems, player);

    }


    private ArrayList<ItemStack> random(ArrayList<ItemStack> dropItems){

        int lenght = (dropItems.size() -1) / 2;

        for (int i = lenght; i > 0; i--) {
            Random random = new Random();
            int radnomNumber = random.nextInt(lenght);

            dropItems.remove(radnomNumber);
        }


        return dropItems;
    }

    private void removeItem(ArrayList<ItemStack> dropitem, Player player){

        for (ItemStack itemStack : dropitem) {

            if((itemStack == null))
                continue;

            player.getInventory().removeItem(itemStack);
        }


    }

    private void dropItem(ArrayList<ItemStack> dropitem, Player player){
        for (ItemStack itemStack : dropitem) {

            if((itemStack == null))
                continue;

            player.getWorld().dropItemNaturally(player.getLocation(), itemStack);
        }

    }

    private ArrayList<ItemStack> getList(Player p){

        ArrayList<ItemStack> list = new ArrayList<>();

        for (ItemStack content : p.getInventory().getContents())
            list.add(content);

        return list;
    }
}
