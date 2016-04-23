package com.digitalfishfun.dffenchantz;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

/**
 * Created by joonatoona on 4/23/16.
 */
public class enchantWither implements Listener {
    @EventHandler
    public void dmgEvnt(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
            HelperFuncs helperFuncs = new HelperFuncs();
            Random random = new Random();
            Player dmgPlayer = (Player) event.getDamager();
            Player hitPlayer = (Player) event.getEntity();
            if (dmgPlayer.getInventory().getItemInMainHand() != null && helperFuncs.enchantLvl(helperFuncs.getEnchants(dmgPlayer.getInventory().getItemInMainHand()), "§eWither") > 0) {
                int enchantLvl = helperFuncs.enchantLvl(helperFuncs.getEnchants(dmgPlayer.getInventory().getItemInMainHand()), "§eWither");
                if (random.nextInt(25/enchantLvl) == 0) {
                    hitPlayer.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, enchantLvl*20, 2));
                    hitPlayer.playSound(hitPlayer.getLocation(), Sound.ENTITY_WITHER_SPAWN, 100, 100);
                    dmgPlayer.playSound(dmgPlayer.getLocation(), Sound.ENTITY_WITHER_SPAWN, 100, 100);
                }
            }
        }
    }
}
