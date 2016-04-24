package com.digitalfishfun.dffenchantz;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

/**
 * Created by joonatoona on 2/29/16.
 */
public class ClickListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        Inventory inventory = event.getInventory();
        if (true) {
            //Bukkit.getServer().broadcastMessage("U clikd a " + event.getCursor().getType().toString() + " onto a " + event.getCurrentItem().getType().toString());
            Boolean shouldEnchant = false;
            Boolean combine = false;
            if (event.getCursor() != null && event.getCursor().getType() == Material.ENCHANTED_BOOK && event.getCursor().hasItemMeta() && event.getCursor().getItemMeta().hasLore()) {
                if (event.getCursor().getItemMeta().getLore().contains(customItems.weaponEnchant) && Arrays.asList(customItems.weapons).contains(event.getCurrentItem().getType().toString())) {
                    shouldEnchant = true;
                }
                if (event.getCursor().getItemMeta().getLore().contains(customItems.helmEnchant) && Arrays.asList(customItems.helms).contains(event.getCurrentItem().getType().toString())) {
                    shouldEnchant = true;
                }
                if (event.getCursor().getItemMeta().getLore().contains(customItems.bootsEnchant) && Arrays.asList(customItems.boots).contains(event.getCurrentItem().getType().toString())) {
                    shouldEnchant = true;
                }
                if (event.getCursor().getItemMeta().getLore().contains(customItems.allEnchant) && customItems.allMat.contains(event.getCurrentItem().getType().toString())) {
                    shouldEnchant = true;
                }
                if (event.getCursor().getItemMeta().getLore().contains(customItems.toolEnchant) && Arrays.asList(customItems.tools).contains(event.getCurrentItem().getType().toString())) {
                    shouldEnchant = true;
                }
                if (event.getCursor().getItemMeta().getLore().contains(customItems.gearEnchant) && Arrays.asList(customItems.gear).contains(event.getCurrentItem().getType().toString())) {
                    shouldEnchant = true;
                }
                if (event.getCurrentItem().getType() == Material.BOOK) {
                    combine = true;
                }
            }

            if (shouldEnchant) {
                ItemStack currentItem = event.getCurrentItem();
                ItemMeta currentMeta = currentItem.getItemMeta();
                HelperFuncs helperFuncs = new HelperFuncs();
                if (Arrays.asList(customItems.dfEnchants).contains(event.getCursor().getItemMeta().getLore().get(0).split(" ")[0])) {
                    if (event.getCursor().getEnchantmentLevel(Enchantment.getByName(event.getCursor().getItemMeta().getLore().get(0).split(" ")[0].substring(2))) ==
                            Integer.parseInt(event.getCursor().getItemMeta().getLore().get(0).split(" ")[1])) {
                        currentItem.addUnsafeEnchantment(Enchantment.getByName(event.getCursor().getItemMeta().getLore().get(0).split(" ")[0].substring(2)),
                                Integer.parseInt(event.getCursor().getItemMeta().getLore().get(0).split(" ")[1])+1);
                    }
                    else {
                        currentItem.addUnsafeEnchantment(Enchantment.getByName(event.getCursor().getItemMeta().getLore().get(0).split(" ")[0].substring(2)),
                                Integer.parseInt(event.getCursor().getItemMeta().getLore().get(0).split(" ")[1]));
                    }
                }
                else {
                    List<String> currentLore = new ArrayList<String>();
                    currentLore.add(event.getCursor().getItemMeta().getLore().get(0));
                    try {
                        currentLore.addAll(currentMeta.getLore());
                    } catch (Exception e) { }
                    currentMeta.setLore(currentLore);
                    currentItem.setItemMeta(currentMeta);
                }
                event.setCurrentItem(currentItem);
                event.setCancelled(true);
                event.getWhoClicked().setItemOnCursor(new ItemStack(Material.AIR));
                ((Player) event.getWhoClicked()).playSound(event.getWhoClicked().getLocation(), Sound.ENTITY_SHULKER_SHOOT, 100, 100);
            }
            if (combine) {
                ItemStack currentItem = event.getCurrentItem();
                ItemMeta currentMeta = currentItem.getItemMeta();
                List<String> currentLore = new ArrayList<String>();
                if (event.getCursor().getItemMeta().getLore().get(0).substring(2).equals(currentMeta.getLore().get(0).substring(2)) &&
                        Integer.parseInt(event.getCursor().getItemMeta().getLore().get(0).split(" ")[1]) < customItems.lvlDict.get(currentMeta.getLore().get(0).split(" ")[0].substring(2))) {
                    currentLore.add(currentMeta.getLore().get(0).split(" ")[0] + " " +
                            (Integer.parseInt(currentMeta.getLore().get(0).split(" ")[1]) + 1));
                    currentLore.add(currentMeta.getLore().get(1));
                    currentMeta.setDisplayName(currentLore.get(0)+" Book");
                    currentMeta.setLore(currentLore);
                    currentItem.setItemMeta(currentMeta);
                    event.setCurrentItem(currentItem);
                    event.setCancelled(true);
                    event.getWhoClicked().setItemOnCursor(new ItemStack(Material.AIR));
                    ((Player) event.getWhoClicked()).playSound(event.getWhoClicked().getLocation(), Sound.ENTITY_SHULKER_SHOOT, 100, 100);
                }
            }
        }
    }
}
