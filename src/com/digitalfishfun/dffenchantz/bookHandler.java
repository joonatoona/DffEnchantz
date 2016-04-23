package com.digitalfishfun.dffenchantz;

import net.minecraft.server.v1_9_R1.Blocks;
import org.bukkit.Bukkit;
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

    public static Map<String, String> enchantDict = new HashMap<String, String>();
    public static Map<String, Integer> lvlDict = new HashMap<String, Integer>();
    public static Random random = new Random();

    public static String weaponEnchant = "§7[WEAPON ENCHANTMENT]";
    public static String helmEnchant = "§7[HELMET ENCHANTMENT]";
    public static String chestplateEnchant = "§7[CHESTPLATE ENCHANTMENT]";
    public static String legsEnchant = "§7[LEGGINGS ENCHANTMENT]";
    public static String bootsEnchant = "§7[BOOTS ENCHANTMENT]";
    public static String gearEnchant = "§7[ARMOR ENCHANTMENT]";
    public static String allEnchant = "§7[ENCHANTMENT]";
    public static String toolEnchant = "§7[TOOL ENCHANTMENT]";

    static {

        enchantDict.put("§7DAMAGE_ALL", weaponEnchant);
        enchantDict.put("§7FIRE_ASPECT", weaponEnchant);
        enchantDict.put("§7DURABILITY", allEnchant);
        enchantDict.put("§7Glowing", helmEnchant);
        enchantDict.put("§7SILK_TOUCH", toolEnchant);
        enchantDict.put("§7LOOT_BONUS_MOBS", weaponEnchant);
        enchantDict.put("§7LOOT_BONUS_BLOCKS", toolEnchant);
        enchantDict.put("§7DIG_SPEED", toolEnchant);
        enchantDict.put("§7PROTECTION_ENVIRONMENTAL", gearEnchant);
        enchantDict.put("§7KNOCKBACK", allEnchant);
        enchantDict.put("§eWither", weaponEnchant);
        enchantDict.put("§cInquisitive", weaponEnchant);
        enchantDict.put("§cLifesteal", weaponEnchant);

        lvlDict.put("§7DAMAGE_ALL", 5);
        lvlDict.put("§7FIRE_ASPECT", 3);
        lvlDict.put("§7DURABILITY", 4);
        lvlDict.put("§7Glowing", 1);
        lvlDict.put("§7SILK_TOUCH", 1);
        lvlDict.put("§7LOOT_BONUS_MOBS", 4);
        lvlDict.put("§7LOOT_BONUS_BLOCKS", 3);
        lvlDict.put("§7PROTECTION_ENVIRONMENTAL", 4);
        lvlDict.put("§7DIG_SPEED", 5);
        lvlDict.put("§7KNOCKBACK", 3);
        lvlDict.put("§eWither", 3);
        lvlDict.put("§cInquisitive", 5);
        lvlDict.put("§cLifesteal", 5);
    }

    String[] plebEnchants = {"§7DAMAGE_ALL", "§7DURABILITY", "§7FIRE_ASPECT", "§7SILK_TOUCH", "§7LOOT_BONUS_MOBS", "§7LOOT_BONUS_BLOCKS", "§7PROTECTION_ENVIRONMENTAL",
            "§7Glowing", "§7DIG_SPEED", "§7KNOCKBACK"};
    String[] t2Enchants = {"§eWither"};
    String[] godEnchants = {"§cInquisitive", "§cLifesteal"};

    @EventHandler
    public void interactHandler(PlayerInteractEvent event) {
        if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.ENCHANTED_BOOK &&
                event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(customItems.m1book.getItemMeta().getDisplayName())) {
            if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                ItemStack newBook = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta newMeta = newBook.getItemMeta();
                List<String> newLore = new ArrayList<String>();
                int rndIndex = random.nextInt(plebEnchants.length);
                String cEnchant = plebEnchants[rndIndex];
                int rndMax = random.nextInt(lvlDict.get(cEnchant))+1;
                newMeta.setDisplayName(cEnchant+" "+rndMax+" Book");
                newLore.add(cEnchant+" "+rndMax);
                newLore.add(enchantDict.get(cEnchant));
                newMeta.setLore(newLore);
                newBook.setItemMeta(newMeta);
                event.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                event.getPlayer().getInventory().addItem(newBook);
                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_SHULKER_SHOOT, 100, 100);
            }
        }
        if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.ENCHANTED_BOOK &&
                event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(customItems.m3book.getItemMeta().getDisplayName())) {
            if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                ItemStack newBook = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta newMeta = newBook.getItemMeta();
                List<String> newLore = new ArrayList<String>();
                int rndIndex = random.nextInt(t2Enchants.length);
                String cEnchant = t2Enchants[rndIndex];
                int rndMax = random.nextInt(lvlDict.get(cEnchant))+1;
                newMeta.setDisplayName(cEnchant+" "+rndMax+" Book");
                newLore.add(cEnchant+" "+rndMax);
                newLore.add(enchantDict.get(cEnchant));
                newMeta.setLore(newLore);
                newBook.setItemMeta(newMeta);
                event.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                event.getPlayer().getInventory().addItem(newBook);
                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_SHULKER_SHOOT, 100, 100);
            }
        }
        if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.ENCHANTED_BOOK &&
                event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(customItems.m5book.getItemMeta().getDisplayName())) {
            if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                ItemStack newBook = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta newMeta = newBook.getItemMeta();
                List<String> newLore = new ArrayList<String>();
                int rndIndex = random.nextInt(godEnchants.length);
                String cEnchant = godEnchants[rndIndex];
                int rndMax = random.nextInt(lvlDict.get(cEnchant))+1;
                newMeta.setDisplayName(cEnchant+" "+rndMax+" Book");
                newLore.add(cEnchant+" "+rndMax);
                newLore.add(enchantDict.get(cEnchant));
                newMeta.setLore(newLore);
                newBook.setItemMeta(newMeta);
                event.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
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
