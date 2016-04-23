package com.digitalfishfun.dffenchantz;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

/**
 * Created by joonatoona on 4/23/16.
 */
public class armorSwap implements Listener {
    String[] helms = {"DIAMOND_HELMET", "GOLD_HELMET", "IRON_HELMET", "CHAINMAIL_HELMET", "LEATHER_HELMET"};
    String[] chestplates = {"DIAMOND_CHESTPLATE", "GOLD_CHESTPLATE", "IRON_CHESTPLATE", "CHAINMAIL_CHESTPLATE", "LEATHER_CHESTPLATE"};
    String[] legs = {"DIAMOND_LEGGINGS", "GOLD_LEGGINGS", "IRON_LEGGINGS", "CHAINMAIL_LEGGINGS", "LEATHER_LEGGINGS"};
    String[] boots = {"DIAMOND_BOOTS", "GOLD_BOOTS", "IRON_BOOTS", "CHAINMAIL_BOOTS", "LEATHER_BOOTS"};
    String[] gear = {"DIAMOND_HELMET", "GOLD_HELMET", "IRON_HELMET", "CHAINMAIL_HELMET", "LEATHER_HELMET",
            "DIAMOND_CHESTPLATE", "GOLD_CHESTPLATE", "IRON_CHESTPLATE", "CHAINMAIL_CHESTPLATE", "LEATHER_CHESTPLATE",
            "DIAMOND_LEGGINGS", "GOLD_LEGGINGS", "IRON_LEGGINGS", "CHAINMAIL_LEGGINGS", "LEATHER_LEGGINGS",
            "DIAMOND_BOOTS", "GOLD_BOOTS", "IRON_BOOTS", "CHAINMAIL_BOOTS", "LEATHER_BOOTS"};

    @EventHandler
    public void interactHandler(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (Arrays.asList(helms).contains(event.getPlayer().getInventory().getItemInMainHand().getType().toString())) {
                ItemStack cGear = event.getPlayer().getInventory().getHelmet();
                ItemStack nGear = event.getPlayer().getInventory().getItemInMainHand();
                event.getPlayer().getInventory().setItemInMainHand(cGear);
                event.getPlayer().getInventory().setHelmet(nGear);
                event.setCancelled(true);
            }
            if (Arrays.asList(chestplates).contains(event.getPlayer().getInventory().getItemInMainHand().getType().toString())) {
                ItemStack cGear = event.getPlayer().getInventory().getChestplate();
                ItemStack nGear = event.getPlayer().getInventory().getItemInMainHand();
                event.getPlayer().getInventory().setItemInMainHand(cGear);
                event.getPlayer().getInventory().setChestplate(nGear);
                event.setCancelled(true);
            }
            if (Arrays.asList(legs).contains(event.getPlayer().getInventory().getItemInMainHand().getType().toString())) {
                ItemStack cGear = event.getPlayer().getInventory().getLeggings();
                ItemStack nGear = event.getPlayer().getInventory().getItemInMainHand();
                event.getPlayer().getInventory().setItemInMainHand(cGear);
                event.getPlayer().getInventory().setLeggings(nGear);
                event.setCancelled(true);
            }
            if (Arrays.asList(boots).contains(event.getPlayer().getInventory().getItemInMainHand().getType().toString())) {
                ItemStack cGear = event.getPlayer().getInventory().getBoots();
                ItemStack nGear = event.getPlayer().getInventory().getItemInMainHand();
                event.getPlayer().getInventory().setItemInMainHand(cGear);
                event.getPlayer().getInventory().setBoots(nGear);
                event.setCancelled(true);
            }
            if (Arrays.asList(helms).contains(event.getPlayer().getInventory().getItemInOffHand().getType().toString())) {
                ItemStack cGear = event.getPlayer().getInventory().getHelmet();
                ItemStack nGear = event.getPlayer().getInventory().getItemInOffHand();
                event.getPlayer().getInventory().setItemInOffHand(cGear);
                event.getPlayer().getInventory().setHelmet(nGear);
                event.setCancelled(true);
            }
            if (Arrays.asList(chestplates).contains(event.getPlayer().getInventory().getItemInOffHand().getType().toString())) {
                ItemStack cGear = event.getPlayer().getInventory().getChestplate();
                ItemStack nGear = event.getPlayer().getInventory().getItemInOffHand();
                event.getPlayer().getInventory().setItemInOffHand(cGear);
                event.getPlayer().getInventory().setChestplate(nGear);
                event.setCancelled(true);
            }
            if (Arrays.asList(legs).contains(event.getPlayer().getInventory().getItemInOffHand().getType().toString())) {
                ItemStack cGear = event.getPlayer().getInventory().getLeggings();
                ItemStack nGear = event.getPlayer().getInventory().getItemInOffHand();
                event.getPlayer().getInventory().setItemInOffHand(cGear);
                event.getPlayer().getInventory().setLeggings(nGear);
                event.setCancelled(true);
            }
            if (Arrays.asList(boots).contains(event.getPlayer().getInventory().getItemInOffHand().getType().toString())) {
                ItemStack cGear = event.getPlayer().getInventory().getBoots();
                ItemStack nGear = event.getPlayer().getInventory().getItemInOffHand();
                event.getPlayer().getInventory().setItemInOffHand(cGear);
                event.getPlayer().getInventory().setBoots(nGear);
                event.setCancelled(true);
            }
        }
    }
}
