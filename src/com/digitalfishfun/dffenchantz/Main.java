package com.digitalfishfun.dffenchantz;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

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
        return false;
    }
}
