package com.digitalfishfun.dffenchantz;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

/**
 * Created by joonatoona on 4/22/16.
 */
public class bookHandler implements Listener {
    public static Random random = new Random();

    @EventHandler
    public void interactHandler(PlayerInteractEvent event) {
        if (event.getPlayer().getInventory().getItemInMainHand().getType() == customItems.m1book.getType() &&
                event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(customItems.m1book.getItemMeta().getDisplayName())) {
            if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                ItemStack newBook = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta newMeta = newBook.getItemMeta();
                List<String> newLore = new ArrayList<String>();
                int rndIndex = random.nextInt(customItems.t1Enchants.length);
                String cEnchant = customItems.t1Enchants[rndIndex];
                int rndMax = random.nextInt(customItems.lvlDict.get(cEnchant))+1;
                newMeta.setDisplayName(customItems.colorDict.get(cEnchant)+cEnchant+" "+rndMax+" Book");
                newLore.add(customItems.colorDict.get(cEnchant)+cEnchant+" "+rndMax);
                int scRate = random.nextInt(100)+1;
                int dsRate = random.nextInt(100)+1;
                newLore.add(ChatColor.GREEN+""+scRate+"%"+" Success rate");
                newLore.add(ChatColor.RED+""+dsRate+"%"+" Destroy rate");
                newLore.add(customItems.enchantDict.get(cEnchant));
                newMeta.setLore(newLore);
                newBook.setItemMeta(newMeta);
                ItemStack newStack = event.getPlayer().getInventory().getItemInMainHand();
                newStack.setAmount(newStack.getAmount()-1);
                if (newStack.getAmount() < 1) {
                    newStack = new ItemStack(Material.AIR);
                }
                event.getPlayer().getInventory().setItemInMainHand(newStack);
                event.getPlayer().getInventory().addItem(newBook);
                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_SHULKER_SHOOT, 100, 100);
            }
        }
        if (event.getPlayer().getInventory().getItemInMainHand().getType() == customItems.m3book.getType() &&
                event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(customItems.m3book.getItemMeta().getDisplayName())) {
            if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                ItemStack newBook = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta newMeta = newBook.getItemMeta();
                List<String> newLore = new ArrayList<String>();
                int rndIndex = random.nextInt(customItems.t3Enchants.length);
                String cEnchant = customItems.t3Enchants[rndIndex];
                int rndMax = random.nextInt(customItems.lvlDict.get(cEnchant))+1;
                newMeta.setDisplayName(customItems.colorDict.get(cEnchant)+cEnchant+" "+rndMax+" Book");
                newLore.add(customItems.colorDict.get(cEnchant)+cEnchant+" "+rndMax);
                int scRate = random.nextInt(100)+1;
                int dsRate = random.nextInt(100)+1;
                newLore.add(ChatColor.GREEN+""+scRate+"%"+" Success rate");
                newLore.add(ChatColor.RED+""+dsRate+"%"+" Destroy rate");
                newLore.add(customItems.enchantDict.get(cEnchant));
                newMeta.setLore(newLore);
                newBook.setItemMeta(newMeta);
                ItemStack newStack = event.getPlayer().getInventory().getItemInMainHand();
                newStack.setAmount(newStack.getAmount()-1);
                if (newStack.getAmount() < 1) {
                    newStack = new ItemStack(Material.AIR);
                }
                event.getPlayer().getInventory().setItemInMainHand(newStack);
                event.getPlayer().getInventory().addItem(newBook);
                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_SHULKER_SHOOT, 100, 100);
            }
        }
        if (event.getPlayer().getInventory().getItemInMainHand().getType() == customItems.m5book.getType() &&
                event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(customItems.m5book.getItemMeta().getDisplayName())) {
            if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                ItemStack newBook = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta newMeta = newBook.getItemMeta();
                List<String> newLore = new ArrayList<String>();
                int rndIndex = random.nextInt(customItems.t5Enchants.length);
                String cEnchant = customItems.t5Enchants[rndIndex];
                int rndMax = random.nextInt(customItems.lvlDict.get(cEnchant))+1;
                newMeta.setDisplayName(customItems.colorDict.get(cEnchant)+cEnchant+" "+rndMax+" Book");
                newLore.add(customItems.colorDict.get(cEnchant)+cEnchant+" "+rndMax);
                int scRate = random.nextInt(100)+1;
                int dsRate = random.nextInt(100)+1;
                newLore.add(ChatColor.GREEN+""+scRate+"%"+" Success rate");
                newLore.add(ChatColor.RED+""+dsRate+"%"+" Destroy rate");
                newLore.add(customItems.enchantDict.get(cEnchant));
                newMeta.setLore(newLore);
                newBook.setItemMeta(newMeta);
                ItemStack newStack = event.getPlayer().getInventory().getItemInMainHand();
                newStack.setAmount(newStack.getAmount()-1);
                if (newStack.getAmount() < 1) {
                    newStack = new ItemStack(Material.AIR);
                }
                event.getPlayer().getInventory().setItemInMainHand(newStack);
                event.getPlayer().getInventory().addItem(newBook);
                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_SHULKER_SHOOT, 100, 100);
            }
        }
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getType() == Material.ENCHANTMENT_TABLE) {
            event.getPlayer().openInventory(enchantShop.enchantShop);
            event.setCancelled(true);
        }
    }
}
