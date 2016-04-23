package com.digitalfishfun.dffenchantz;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Created by joonatoona on 2/29/16.
 */
public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new enchantShop(), this);
        getServer().getPluginManager().registerEvents(new enchantInquis(), this);
        getServer().getPluginManager().registerEvents(new bookHandler(), this);
        getServer().getPluginManager().registerEvents(new ClickListener(), this);
        getServer().getPluginManager().registerEvents(new armorSwap(), this);
        getServer().getPluginManager().registerEvents(new enchantLifesteal(), this);
        getServer().getPluginManager().registerEvents(new enchantWither(), this);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new enchantGlowing(), (long) 2, (long) 2);
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("enchant")) {
            Player player = (Player) sender;
            player.openInventory(enchantShop.enchantShop);
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("givebook")) {
            if (sender.isOp()) {
                ItemStack newBook = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta newMeta = newBook.getItemMeta();
                List<String> newLore = new ArrayList<String>();
                newMeta.setDisplayName("§7"+args[0]+" "+args[1]+" Book");
                newLore.add("§7"+args[0]+" "+args[1]);
                newLore.add("§7[ENCHANTMENT]");
                newMeta.setLore(newLore);
                newBook.setItemMeta(newMeta);
                Player player = (Player) sender;
                player.getInventory().addItem(newBook);
            }
        }
        return false;
    }
}
