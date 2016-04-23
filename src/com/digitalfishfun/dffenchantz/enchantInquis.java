package com.digitalfishfun.dffenchantz;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.ArrayList;

/**
 * Created by joonatoona on 4/22/16.
 */
public class enchantInquis implements Listener {
    @EventHandler
    public void mobKill(EntityDeathEvent event) {
        HelperFuncs helperFuncs = new HelperFuncs();
        Player player = event.getEntity().getKiller();
        if (helperFuncs.enchantLvl(helperFuncs.getEnchants(player.getItemInHand()), "§cInquisitive") > 0) {
            int enchantLvl = helperFuncs.enchantLvl(helperFuncs.getEnchants(player.getItemInHand()), "§cInquisitive");
            event.setDroppedExp(event.getDroppedExp()*((int)((double) enchantLvl/1.5)));
        }
    }
}
