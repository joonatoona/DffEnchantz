package com.digitalfishfun.dffenchantz;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joonatoona on 4/22/16.
 */
public class customItems {

    public static ItemStack t1book = new ItemStack(Material.ENCHANTED_BOOK);
    public static ItemStack t3book = new ItemStack(Material.ENCHANTED_BOOK);
    public static ItemStack t5book = new ItemStack(Material.ENCHANTED_BOOK);

    public static ItemStack nope = new ItemStack(Material.BARRIER);

    public static ItemStack m1book = new ItemStack(Material.ENCHANTED_BOOK);
    public static ItemStack m3book = new ItemStack(Material.ENCHANTED_BOOK);
    public static ItemStack m5book = new ItemStack(Material.ENCHANTED_BOOK);

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
    }
}
