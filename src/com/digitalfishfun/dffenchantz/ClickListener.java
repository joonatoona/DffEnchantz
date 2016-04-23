package com.digitalfishfun.dffenchantz;

import net.minecraft.server.v1_9_R1.Blocks;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

/**
 * Created by joonatoona on 2/29/16.
 */
public class ClickListener implements Listener {

    public static String weaponEnchant = "§7[WEAPON ENCHANTMENT]";
    public static String helmEnchant = "§7[HELMET ENCHANTMENT]";
    public static String chestplateEnchant = "§7[CHESTPLATE ENCHANTMENT]";
    public static String legsEnchant = "§7[LEGGINGS ENCHANTMENT]";
    public static String bootsEnchant = "§7[BOOTS ENCHANTMENT]";
    public static String gearEnchant = "§7[ARMOR ENCHANTMENT]";
    public static String allEnchant = "§7[ENCHANTMENT]";
    public static String toolEnchant = "§7[TOOL ENCHANTMENT]";
    public static Map<String, Integer> lvlDict = new HashMap<String, Integer>();

    String[] dfEnchants = {"§7DAMAGE_ALL", "§7DURABILITY", "§7FIRE_ASPECT", "§7SILK_TOUCH", "§7LOOT_BONUS_MOBS", "§7LOOT_BONUS_BLOCKS", "§7PROTECTION_ENVIRONMENTAL"};
    String[] weapons = {"DIAMOND_SWORD", "GOLD_SWORD", "IRON_SWORD", "STONE_SWORD", "WOOD_SWORD",
            "DIAMOND_AXE", "GOLD_AXE", "IRON_AXE", "STONE_AXE", "WOOD_AXE"};
    String[] tools = {"DIAMOND_PICKAXE", "GOLD_PICKAXE", "IRON_PICKAXE", "STONE_PICKAXE", "LEATHER_PICKAXE",
            "DIAMOND_AXE", "GOLD_AXE", "IRON_AXE", "STONE_AXE", "WOOD_AXE"};
    String[] helms = {"DIAMOND_HELMET", "GOLD_HELMET", "IRON_HELMET", "CHAINMAIL_HELMET", "LEATHER_HELMET"};
    String[] chestplates = {"DIAMOND_CHESTPLATE", "GOLD_CHESTPLATE", "IRON_CHESTPLATE", "CHAINMAIL_CHESTPLATE", "LEATHER_CHESTPLATE"};
    String[] legs = {"DIAMOND_LEGGINGS", "GOLD_LEGGINGS", "IRON_LEGGINGS", "CHAINMAIL_LEGGINGS", "LEATHER_LEGGINGS"};
    String[] boots = {"DIAMOND_BOOTS", "GOLD_BOOTS", "IRON_BOOTS", "CHAINMAIL_BOOTS", "LEATHER_BOOTS"};
    String[] gear = {"DIAMOND_HELMET", "GOLD_HELMET", "IRON_HELMET", "CHAINMAIL_HELMET", "LEATHER_HELMET",
            "DIAMOND_CHESTPLATE", "GOLD_CHESTPLATE", "IRON_CHESTPLATE", "CHAINMAIL_CHESTPLATE", "LEATHER_CHESTPLATE",
            "DIAMOND_LEGGINGS", "GOLD_LEGGINGS", "IRON_LEGGINGS", "CHAINMAIL_LEGGINGS", "LEATHER_LEGGINGS",
            "DIAMOND_BOOTS", "GOLD_BOOTS", "IRON_BOOTS", "CHAINMAIL_BOOTS", "LEATHER_BOOTS"};

    static {
        lvlDict.put("§7DAMAGE_ALL", 5);
        lvlDict.put("§7FIRE_ASPECT", 5);
        lvlDict.put("§7DURABILITY", 5);
        lvlDict.put("§7Glowing", 1);
        lvlDict.put("§7SILK_TOUCH", 1);
        lvlDict.put("§7PROTECTION_ENVIRONMENTAL", 5);
        lvlDict.put("§cInquisitive", 5);
    }



    Enchantment enchantment = Enchantment.PROTECTION_ENVIRONMENTAL;

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        Inventory inventory = event.getInventory();
        if (true) {
            //Bukkit.getServer().broadcastMessage("U clikd a " + event.getCursor().getType().toString() + " onto a " + event.getCurrentItem().getType().toString());
            Boolean shouldEnchant = false;
            Boolean combine = false;
            if (event.getCursor().getType() == Material.ENCHANTED_BOOK) {
                if (event.getCursor().getItemMeta().getLore().contains(weaponEnchant) && Arrays.asList(weapons).contains(event.getCurrentItem().getType().toString())) {
                    shouldEnchant = true;
                }
                if (event.getCursor().getItemMeta().getLore().contains(helmEnchant) && Arrays.asList(helms).contains(event.getCurrentItem().getType().toString())) {
                    shouldEnchant = true;
                }
                if (event.getCursor().getItemMeta().getLore().contains(allEnchant)) {
                    shouldEnchant = true;
                }
                if (event.getCursor().getItemMeta().getLore().contains(toolEnchant) && Arrays.asList(tools).contains(event.getCurrentItem().getType().toString()))
                if (event.getCurrentItem().getType() == Material.ENCHANTED_BOOK) {
                    combine = true;
                }
            }

            if (shouldEnchant) {
                ItemStack currentItem = event.getCurrentItem();
                ItemMeta currentMeta = currentItem.getItemMeta();
                HelperFuncs helperFuncs = new HelperFuncs();
                if (Arrays.asList(dfEnchants).contains(event.getCursor().getItemMeta().getLore().get(0).split(" ")[0])) {
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
                if (event.getCursor().getItemMeta().getLore().get(0).equals(currentMeta.getLore().get(0)) &&
                        Integer.parseInt(event.getCursor().getItemMeta().getLore().get(0).split(" ")[1]) < lvlDict.get(currentMeta.getLore().get(0).split(" ")[0])) {
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
