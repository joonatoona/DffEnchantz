package com.digitalfishfun.dffenchantz;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by joonatoona on 4/21/16.
 */
public class enchantShop implements Listener {
    public static Inventory enchantShop = Bukkit.createInventory(null, 9, "Enchant Shop");


    static {

        enchantShop.setItem(0, customItems.nope);
        enchantShop.setItem(1, customItems.nope);
        enchantShop.setItem(2, customItems.nope);
        enchantShop.setItem(3, customItems.t1book);
        enchantShop.setItem(4, customItems.t3book);
        enchantShop.setItem(5, customItems.t5book);
        enchantShop.setItem(6, customItems.nope);
        enchantShop.setItem(7, customItems.nope);
        enchantShop.setItem(8, customItems.nope);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        Inventory inventory = event.getInventory();
        if (inventory.getName().equals(enchantShop.getName())) {
            if (clicked.getType() == Material.ENCHANTED_BOOK && clicked.getItemMeta().getDisplayName().equals(customItems.t1book.getItemMeta().getDisplayName())) {
                if (player.getTotalExperience() >= 500) {
                    player.giveExp(-500);
                    player.setTotalExperience(player.getTotalExperience());
                    player.getInventory().addItem(customItems.m1book);
                    player.playSound(player.getLocation(), Sound.ENTITY_HORSE_BREATHE, 100, 100);
                }
            }
            if (clicked.getType() == Material.ENCHANTED_BOOK && clicked.getItemMeta().getDisplayName().equals(customItems.t3book.getItemMeta().getDisplayName())) {
                if (player.getTotalExperience() >= 10000) {
                    player.giveExp(-10000);
                    player.setTotalExperience(player.getTotalExperience());
                    player.getInventory().addItem(customItems.m3book);
                    player.playSound(player.getLocation(), Sound.ENTITY_HORSE_BREATHE, 100, 100);
                }
            }
            if (clicked.getType() == Material.ENCHANTED_BOOK && clicked.getItemMeta().getDisplayName().equals(customItems.t5book.getItemMeta().getDisplayName())) {
                if (player.getTotalExperience() >= 50000) {
                    player.giveExp(-50000);
                    player.setTotalExperience(player.getTotalExperience());
                    player.getInventory().addItem(customItems.m5book);
                    player.playSound(player.getLocation(), Sound.ENTITY_HORSE_BREATHE, 100, 100);
                }
            }
            event.setCancelled(true);
        }
    }
}
