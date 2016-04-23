package com.digitalfishfun.dffenchantz;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Random;

/**
 * Created by joonatoona on 4/23/16.
 */
public class enchantLifesteal implements Listener {
    @EventHandler
    public void dmgEvnt(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            HelperFuncs helperFuncs = new HelperFuncs();
            Random random = new Random();
            Player dmgPlayer = (Player) event.getDamager();
            if (dmgPlayer.getInventory().getItemInMainHand() != null && helperFuncs.enchantLvl(helperFuncs.getEnchants(dmgPlayer.getInventory().getItemInMainHand()), "§cLifesteal") > 0) {
                int enchantLvl = helperFuncs.enchantLvl(helperFuncs.getEnchants(dmgPlayer.getInventory().getItemInMainHand()), "§cLifesteal");
                if (random.nextInt(15/enchantLvl) == 0) {
                    double totalHealt = dmgPlayer.getHealth();
                    totalHealt += (event.getDamage()/(6-enchantLvl));
                    if (totalHealt > dmgPlayer.getMaxHealth()) {
                        totalHealt = dmgPlayer.getMaxHealth();
                    }
                    dmgPlayer.setHealth(totalHealt);
                    dmgPlayer.playSound(dmgPlayer.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                }
            }
        }
    }
}
