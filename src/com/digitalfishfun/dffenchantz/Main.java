package com.digitalfishfun.dffenchantz;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
        getServer().getPluginManager().registerEvents(new enchantListener(), this);
        getServer().getPluginManager().registerEvents(new bookHandler(), this);
        getServer().getPluginManager().registerEvents(new ClickListener(), this);
        getServer().getPluginManager().registerEvents(new armorSwap(), this);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new enchantListener(), (long) 2, (long) 2);
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
                newMeta.setDisplayName(customItems.colorDict.get(args[0])+""+args[0]+" "+args[1]+" Book");
                newLore.add(customItems.colorDict.get(args[0])+""+args[0]+" "+args[1]);
                newLore.add(ChatColor.GREEN+"100% Success Rate");
                newLore.add(ChatColor.RED+"0% Destroy Rate");
                newLore.add(customItems.allEnchant);
                newLore.add(customItems.descDict.get(args[0]));
                newMeta.setLore(newLore);
                newBook.setItemMeta(newMeta);
                Player player = (Player) sender;
                player.getInventory().addItem(newBook);
            }
        }
        return false;
    }
}
