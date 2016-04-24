package com.digitalfishfun.dffenchantz;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

/**
 * Created by joonatoona on 4/23/16.
 */
public class enchantListener implements Runnable, Listener {
    @Override
    public void run() {
        HelperFuncs helperFuncs = new HelperFuncs();
        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
            //Sanik
            if (p.getInventory().getBoots() != null && p.getInventory().getBoots().getItemMeta().hasLore() &&
                    helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getBoots()), "Sanik") > 0) {
                int enchantLvl = helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getBoots()), "Sanik");
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, enchantLvl-1), true);
            }
            //Glowing
            if (p.getInventory().getHelmet() != null && p.getInventory().getHelmet().getItemMeta().hasLore() &&
                    helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getHelmet()), "Glowing") > 0) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 500, 0), true);
            }
            //Bouncy
            if (p.getInventory().getBoots() != null && p.getInventory().getBoots().getItemMeta().hasLore() &&
                    helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getBoots()), "Bouncy") > 0) {
                int enchantLvl = helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getBoots()), "Bouncy");
                p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20, enchantLvl-1), true);
            }
            //Lightweight
            if (p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInMainHand().getItemMeta().hasLore() &&
                    helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getItemInMainHand()), "Lightweight") > 0) {
                int enchantLvl = helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getBoots()), "Lightweight");
                p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20, enchantLvl-1), true);
            }
        }
    }

    @EventHandler
    public void dmgEvnt(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            HelperFuncs helperFuncs = new HelperFuncs();
            Random random = new Random();
            Player dmgPlayer = (Player) event.getDamager();
            Player hitPlayer = (Player) event.getEntity();
            //Wither
            if (dmgPlayer.getInventory().getItemInMainHand() != null && helperFuncs.enchantLvl(helperFuncs.getEnchants(dmgPlayer.getInventory().getItemInMainHand()), "Wither") > 0) {
                int enchantLvl = helperFuncs.enchantLvl(helperFuncs.getEnchants(dmgPlayer.getInventory().getItemInMainHand()), "Wither");
                if (random.nextInt(25/enchantLvl) == 0) {
                    hitPlayer.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, enchantLvl*20, 2));
                    hitPlayer.playSound(hitPlayer.getLocation(), Sound.ENTITY_WITHER_SPAWN, 100, 100);
                    dmgPlayer.playSound(dmgPlayer.getLocation(), Sound.ENTITY_WITHER_SPAWN, 100, 100);
                }
            }
            //Lifesteal
            if (dmgPlayer.getInventory().getItemInMainHand() != null && helperFuncs.enchantLvl(helperFuncs.getEnchants(dmgPlayer.getInventory().getItemInMainHand()), "Lifesteal") > 0) {
                int enchantLvl = helperFuncs.enchantLvl(helperFuncs.getEnchants(dmgPlayer.getInventory().getItemInMainHand()), "Lifesteal");
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

    @EventHandler
    public void mobKill(EntityDeathEvent event) {
        HelperFuncs helperFuncs = new HelperFuncs();
        if (event.getEntity().getKiller() != null) {
            Player player = event.getEntity().getKiller();
            //Inquisitive
            if (player.getInventory().getItemInMainHand() != null && helperFuncs.enchantLvl(helperFuncs.getEnchants(player.getInventory().getItemInMainHand()), "§cInquisitive") > 0) {
                int enchantLvl = helperFuncs.enchantLvl(helperFuncs.getEnchants(player.getInventory().getItemInMainHand()), "§cInquisitive");
                event.setDroppedExp(event.getDroppedExp() * ((int) ((double) enchantLvl / 1.5)));
            }
        }
    }
}
