package com.digitalfishfun.dffenchantz;

import org.bukkit.ChatColor;
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
    public static String weaponEnchant = ChatColor.GRAY+"[WEAPON ENCHANTMENT]";
    public static String helmEnchant = ChatColor.GRAY+"[HELMET ENCHANTMENT]";
    public static String chestplateEnchant = ChatColor.GRAY+"[CHESTPLATE ENCHANTMENT]";
    public static String legsEnchant = ChatColor.GRAY+"[LEGGINGS ENCHANTMENT]";
    public static String bootsEnchant = ChatColor.GRAY+"§7[BOOTS ENCHANTMENT]";
    public static String gearEnchant = ChatColor.GRAY+"§7[ARMOR ENCHANTMENT]";
    public static String allEnchant = ChatColor.GRAY+"§7[ENCHANTMENT]";
    public static String toolEnchant = ChatColor.GRAY+"§7[TOOL ENCHANTMENT]";
    public static Map<String, Integer> lvlDict = new HashMap<String, Integer>();
    public static Map<String, String> enchantDict = new HashMap<String, String>();
    public static Map<String, ChatColor> colorDict = new HashMap<String, ChatColor>();

    //Enchant Arrays
    public static String[] t1Enchants = {"DAMAGE_ALL", "DURABILITY", "FIRE_ASPECT", "SILK_TOUCH", "LOOT_BONUS_MOBS", "LOOT_BONUS_BLOCKS", "PROTECTION_ENVIRONMENTAL",
            "Glowing", "DIG_SPEED", "KNOCKBACK"};
    public static String[] t3Enchants = {"Wither", "Bouncy", "Sanik", "Frozen"};
    public static String[] t5Enchants = {"Inquisitive", "Lifesteal", "Lightweight", "Anti-Knockback"};

    //Arrays
    public static String[] dfEnchants = {"DAMAGE_ALL", "DURABILITY", "FIRE_ASPECT", "SILK_TOUCH", "LOOT_BONUS_MOBS", "LOOT_BONUS_BLOCKS", "PROTECTION_ENVIRONMENTAL", "KNOCKBACK"};
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
        m1meta.setDisplayName(ChatColor.GRAY+"Teir 1 Enchant Book (RIGHT CLICK)");
        List<String> m1lore = new ArrayList<String>();
        m1lore.add(ChatColor.GRAY+"(Right-Click to reveal!)");
        m1meta.setLore(m1lore);
        m1book.setItemMeta(m1meta);

        ItemMeta m3meta = m3book.getItemMeta();
        m3meta.setDisplayName(ChatColor.AQUA+"Teir 3 Enchant Book (RIGHT CLICK)");
        List<String> m3lore = new ArrayList<String>();
        m3lore.add("§7(Right-Click to reveal!)");
        m3meta.setLore(m3lore);
        m3book.setItemMeta(m3meta);

        ItemMeta m5meta = m5book.getItemMeta();
        m5meta.setDisplayName(ChatColor.DARK_RED+"Teir 5 Enchant Book (RIGHT CLICK)");
        List<String> m5lore = new ArrayList<String>();
        m5lore.add(ChatColor.GRAY+"(Right-Click to reveal!)");
        m5meta.setLore(m5lore);
        m5book.setItemMeta(m5meta);

        //Shop Books
        ItemMeta t1meta = t1book.getItemMeta();
        t1meta.setDisplayName(ChatColor.GRAY+"Teir 1 Enchant Book (LEFT CLICK)");
        List<String> t1lore = new ArrayList<String>();
        t1lore.add(ChatColor.GOLD+"Price: 500xp");
        t1lore.add(ChatColor.GRAY+"(Click to purchase)");
        t1meta.setLore(t1lore);
        t1book.setItemMeta(t1meta);

        ItemMeta t3meta = t3book.getItemMeta();
        t3meta.setDisplayName(ChatColor.AQUA+"Teir 3 Enchant Book (LEFT CLICK)");
        List<String> t3lore = new ArrayList<String>();
        t3lore.add(ChatColor.GOLD+"Price: 10000xp");
        t3lore.add(ChatColor.GRAY+"(Click to purchase)");
        t3meta.setLore(t3lore);
        t3book.setItemMeta(t3meta);

        ItemMeta t5meta = t5book.getItemMeta();
        t5meta.setDisplayName(ChatColor.DARK_RED+"Teir 5 Enchant Book (LEFT CLICK)");
        List<String> t5lore = new ArrayList<String>();
        t5lore.add(ChatColor.GOLD+"Price: 50000xp");
        t5lore.add(ChatColor.GRAY+"(Click to purchase)");
        t5meta.setLore(t5lore);
        t5book.setItemMeta(t5meta);

        //Enchant Dict
        enchantDict.put("DAMAGE_ALL", weaponEnchant);
        enchantDict.put("FIRE_ASPECT", weaponEnchant);
        enchantDict.put("DURABILITY", allEnchant);
        enchantDict.put("Glowing", helmEnchant);
        enchantDict.put("SILK_TOUCH", toolEnchant);
        enchantDict.put("LOOT_BONUS_MOBS", weaponEnchant);
        enchantDict.put("LOOT_BONUS_BLOCKS", toolEnchant);
        enchantDict.put("DIG_SPEED", toolEnchant);
        enchantDict.put("PROTECTION_ENVIRONMENTAL", gearEnchant);
        enchantDict.put("KNOCKBACK", allEnchant);
        enchantDict.put("Bouncy", bootsEnchant);
        enchantDict.put("Sanik", bootsEnchant);
        enchantDict.put("Wither", weaponEnchant);
        enchantDict.put("Frozen", weaponEnchant);
        enchantDict.put("Inquisitive", weaponEnchant);
        enchantDict.put("Lifesteal", weaponEnchant);
        enchantDict.put("Lightweight", weaponEnchant);
        enchantDict.put("Anti-Knockback", gearEnchant);

        //Lvl Dict
        lvlDict.put("DAMAGE_ALL", 5);
        lvlDict.put("FIRE_ASPECT", 3);
        lvlDict.put("DURABILITY", 4);
        lvlDict.put("Glowing", 1);
        lvlDict.put("SILK_TOUCH", 1);
        lvlDict.put("LOOT_BONUS_MOBS", 4);
        lvlDict.put("LOOT_BONUS_BLOCKS", 3);
        lvlDict.put("PROTECTION_ENVIRONMENTAL", 4);
        lvlDict.put("DIG_SPEED", 5);
        lvlDict.put("KNOCKBACK", 3);
        lvlDict.put("Wither", 3);
        lvlDict.put("Bouncy", 2);
        lvlDict.put("Sanik", 3);
        lvlDict.put("Frozen", 4);
        lvlDict.put("Inquisitive", 5);
        lvlDict.put("Lifesteal", 5);
        lvlDict.put("Lightweight", 3);
        lvlDict.put("Anti-Knockback", 3);

        //Color Dict
        colorDict.put("DAMAGE_ALL", ChatColor.GRAY);
        colorDict.put("FIRE_ASPECT", ChatColor.GRAY);
        colorDict.put("DURABILITY", ChatColor.GRAY);
        colorDict.put("Glowing", ChatColor.GRAY);
        colorDict.put("SILK_TOUCH", ChatColor.GRAY);
        colorDict.put("LOOT_BONUS_MOBS", ChatColor.GRAY);
        colorDict.put("LOOT_BONUS_BLOCKS", ChatColor.GRAY);
        colorDict.put("PROTECTION_ENVIRONMENTAL", ChatColor.GRAY);
        colorDict.put("DIG_SPEED", ChatColor.GRAY);
        colorDict.put("KNOCKBACK", ChatColor.GRAY);
        colorDict.put("Wither", ChatColor.AQUA);
        colorDict.put("Frozen", ChatColor.AQUA);
        colorDict.put("Bouncy", ChatColor.AQUA);
        colorDict.put("Sanik", ChatColor.AQUA);
        colorDict.put("Inquisitive", ChatColor.DARK_RED);
        colorDict.put("Lifesteal", ChatColor.DARK_RED);
        colorDict.put("Lightweight", ChatColor.DARK_RED);
        colorDict.put("Anti-Knockback", ChatColor.DARK_RED);
    }
}
