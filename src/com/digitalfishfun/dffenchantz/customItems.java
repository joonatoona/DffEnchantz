package com.digitalfishfun.dffenchantz;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by joonatoona on 4/22/16.
 */
public class customItems {

    //Shop Books
    public static ItemStack t1book = new ItemStack(Material.BOOK);
    public static ItemStack t3book = new ItemStack(Material.BOOK);
    public static ItemStack t5book = new ItemStack(Material.BOOK);

    public static ItemStack nope = new ItemStack(Material.BARRIER);

    //Mystery Books
    public static ItemStack m1book = new ItemStack(Material.BOOK);
    public static ItemStack m3book = new ItemStack(Material.BOOK);
    public static ItemStack m5book = new ItemStack(Material.BOOK);

    //Enchant Strings
    public static String weaponEnchant = "§7[WEAPON ENCHANTMENT]";
    public static String helmEnchant = "§7[HELMET ENCHANTMENT]";
    public static String chestplateEnchant = "§7[CHESTPLATE ENCHANTMENT]";
    public static String legsEnchant = "§7[LEGGINGS ENCHANTMENT]";
    public static String bootsEnchant = "§7[BOOTS ENCHANTMENT]";
    public static String gearEnchant = "§7[ARMOR ENCHANTMENT]";
    public static String allEnchant = "§7[ENCHANTMENT]";
    public static String toolEnchant = "§7[TOOL ENCHANTMENT]";
    public static Map<String, Integer> lvlDict = new HashMap<String, Integer>();
    public static Map<String, String> enchantDict = new HashMap<String, String>();

    //Enchant Arrays
    public static String[] t1Enchants = {"§7DAMAGE_ALL", "§7DURABILITY", "§7FIRE_ASPECT", "§7SILK_TOUCH", "§7LOOT_BONUS_MOBS", "§7LOOT_BONUS_BLOCKS", "§7PROTECTION_ENVIRONMENTAL",
            "§7Glowing", "§7DIG_SPEED", "§7KNOCKBACK"};
    public static String[] t3Enchants = {"§eWither", "§eBouncy", "§eSanik"};
    public static String[] t5Enchants = {"§cInquisitive", "§cLifesteal", "§cLightweight"};

    //Arrays
    public static String[] dfEnchants = {"§7DAMAGE_ALL", "§7DURABILITY", "§7FIRE_ASPECT", "§7SILK_TOUCH", "§7LOOT_BONUS_MOBS", "§7LOOT_BONUS_BLOCKS", "§7PROTECTION_ENVIRONMENTAL", "§7KNOCKBACK"};
    public static String[] weapons = {"DIAMOND_SWORD", "GOLD_SWORD", "IRON_SWORD", "STONE_SWORD", "WOOD_SWORD",
            "DIAMOND_AXE", "GOLD_AXE", "IRON_AXE", "STONE_AXE", "WOOD_AXE"};
    public static String[] tools = {"DIAMOND_PICKAXE", "GOLD_PICKAXE", "IRON_PICKAXE", "STONE_PICKAXE", "LEATHER_PICKAXE",
            "DIAMOND_AXE", "GOLD_AXE", "IRON_AXE", "STONE_AXE", "WOOD_AXE"};
    public static String[] helms = {"DIAMOND_HELMET", "GOLD_HELMET", "IRON_HELMET", "CHAINMAIL_HELMET", "LEATHER_HELMET"};
    public static String[] chestplates = {"DIAMOND_CHESTPLATE", "GOLD_CHESTPLATE", "IRON_CHESTPLATE", "CHAINMAIL_CHESTPLATE", "LEATHER_CHESTPLATE"};
    public static String[] legs = {"DIAMOND_LEGGINGS", "GOLD_LEGGINGS", "IRON_LEGGINGS", "CHAINMAIL_LEGGINGS", "LEATHER_LEGGINGS"};
    public static String[] boots = {"DIAMOND_BOOTS", "GOLD_BOOTS", "IRON_BOOTS", "CHAINMAIL_BOOTS", "LEATHER_BOOTS"};
    public static String[] gear = {"DIAMOND_HELMET", "GOLD_HELMET", "IRON_HELMET", "CHAINMAIL_HELMET", "LEATHER_HELMET",
            "DIAMOND_CHESTPLATE", "GOLD_CHESTPLATE", "IRON_CHESTPLATE", "CHAINMAIL_CHESTPLATE", "LEATHER_CHESTPLATE",
            "DIAMOND_LEGGINGS", "GOLD_LEGGINGS", "IRON_LEGGINGS", "CHAINMAIL_LEGGINGS", "LEATHER_LEGGINGS",
            "DIAMOND_BOOTS", "GOLD_BOOTS", "IRON_BOOTS", "CHAINMAIL_BOOTS", "LEATHER_BOOTS"};

    public static ArrayList<String> allMat = new ArrayList<String>();

    static {
        //Mystery Books
        ItemMeta m1meta = m1book.getItemMeta();
        m1meta.setDisplayName("§7Teir 1 Enchant Book (RIGHT CLICK)");
        List<String> m1lore = new ArrayList<String>();
        m1lore.add("§7(Right-Click to reveal!)");
        m1meta.setLore(m1lore);
        m1book.setItemMeta(m1meta);

        ItemMeta m3meta = m3book.getItemMeta();
        m3meta.setDisplayName("§eTeir 3 Enchant Book (RIGHT CLICK)");
        List<String> m3lore = new ArrayList<String>();
        m3lore.add("§7(Right-Click to reveal!)");
        m3meta.setLore(m3lore);
        m3book.setItemMeta(m3meta);

        ItemMeta m5meta = m5book.getItemMeta();
        m5meta.setDisplayName("§cTeir 5 Enchant Book (RIGHT CLICK)");
        List<String> m5lore = new ArrayList<String>();
        m5lore.add("§7(Right-Click to reveal!)");
        m5meta.setLore(m5lore);
        m5book.setItemMeta(m5meta);

        //Shop Books
        ItemMeta t1meta = t1book.getItemMeta();
        t1meta.setDisplayName("§7Teir 1 Enchant Book (LEFT CLICK)");
        List<String> t1lore = new ArrayList<String>();
        t1lore.add("§6Price: 500xp");
        t1lore.add("§7(Click to purchase)");
        t1meta.setLore(t1lore);
        t1book.setItemMeta(t1meta);

        ItemMeta t3meta = t3book.getItemMeta();
        t3meta.setDisplayName("§eTeir 3 Enchant Book (RIGHT CLICK)");
        List<String> t3lore = new ArrayList<String>();
        t3lore.add("§6Price: 10000xp");
        t3lore.add("§7(Click to purchase)");
        t3meta.setLore(t3lore);
        t3book.setItemMeta(t3meta);

        ItemMeta t5meta = t5book.getItemMeta();
        t5meta.setDisplayName("§cTeir 5 Enchant Book (LEFT CLICK)");
        List<String> t5lore = new ArrayList<String>();
        t5lore.add("§6Price: 50000xp");
        t5lore.add("§7(Click to purchase)");
        t5meta.setLore(t5lore);
        t5book.setItemMeta(t5meta);

        //Enchant Dict
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
        enchantDict.put("§eBouncy", bootsEnchant);
        enchantDict.put("§eSanik", bootsEnchant);
        enchantDict.put("§eWither", weaponEnchant);
        enchantDict.put("§cInquisitive", weaponEnchant);
        enchantDict.put("§cLifesteal", weaponEnchant);
        enchantDict.put("§cLightweight", weaponEnchant);

        //Lvl Dict
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
        lvlDict.put("§eBouncy", 2);
        lvlDict.put("§eSanik", 3);
        lvlDict.put("§cInquisitive", 5);
        lvlDict.put("§cLifesteal", 5);
        lvlDict.put("§cLightweight", 3n);
    }
}
