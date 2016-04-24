package com.digitalfishfun.dffenchantz;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

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
            if (helperFuncs.plzNoNull(p.getInventory().getBoots()) && helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getBoots()), "Sanik") > 0) {
                int enchantLvl = helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getBoots()), "Sanik");
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, enchantLvl-1), true);
            }
            //Glowing
            if (helperFuncs.plzNoNull(p.getInventory().getHelmet()) && helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getHelmet()), "Glowing") > 0) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 500, 0), true);
            }
            //Bouncy
            if (helperFuncs.plzNoNull(p.getInventory().getBoots()) && helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getBoots()), "Bouncy") > 0) {
                int enchantLvl = helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getBoots()), "Bouncy");
                p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20, enchantLvl-1), true);
            }
            //Lightweight
            if (p.getInventory().getItemInMainHand().getType() != Material.AIR && p.getInventory().getItemInMainHand().getItemMeta().hasLore() &&
                    helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getItemInMainHand()), "Lightweight") > 0) {
                int enchantLvl = helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getBoots()), "Lightweight");
                p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20, enchantLvl-1), true);
            }
            //Tank
            int akLvl = 0;
            if (helperFuncs.plzNoNull(p.getInventory().getHelmet()) && helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getHelmet()), "Tank") > 0) {
                akLvl += helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getHelmet()), "Tank");
            }
            if (helperFuncs.plzNoNull(p.getInventory().getChestplate()) && helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getChestplate()), "Tank") > 0) {
                akLvl += helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getChestplate()), "Tank");
            }
            if (helperFuncs.plzNoNull(p.getInventory().getLeggings()) && helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getLeggings()), "Tank") > 0) {
                akLvl += helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getLeggings()), "Tank");
            }
            if (helperFuncs.plzNoNull(p.getInventory().getBoots()) && helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getBoots()), "Tank") > 0) {
                akLvl += helperFuncs.enchantLvl(helperFuncs.getEnchants(p.getInventory().getBoots()), "Tank");
            }
            if (akLvl > 0) {
                p.setMaxHealth(20.0+(double)akLvl);
            }
            else {
                p.setMaxHealth(20.0);
            }
        }
    }

    @EventHandler
    public void dmgEvnt(EntityDamageByEntityEvent event) {
        HelperFuncs helperFuncs = new HelperFuncs();
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
            Random random = new Random();
            Player dmgPlayer = (Player) event.getDamager();
            Player hitPlayer = (Player) event.getEntity();
            //Wither
            if (helperFuncs.plzNoNull(dmgPlayer.getInventory().getItemInMainHand()) && helperFuncs.enchantLvl(helperFuncs.getEnchants(dmgPlayer.getInventory().getItemInMainHand()), "Wither") > 0) {
                int enchantLvl = helperFuncs.enchantLvl(helperFuncs.getEnchants(dmgPlayer.getInventory().getItemInMainHand()), "Wither");
                if (random.nextInt(25/enchantLvl) == 0) {
                    hitPlayer.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, enchantLvl*20, 2));
                    hitPlayer.playSound(hitPlayer.getLocation(), Sound.ENTITY_WITHER_SPAWN, 100, 100);
                    dmgPlayer.playSound(dmgPlayer.getLocation(), Sound.ENTITY_WITHER_SPAWN, 100, 100);
                }
            }
            //Frozen
            if (helperFuncs.plzNoNull(dmgPlayer.getInventory().getItemInMainHand()) && helperFuncs.enchantLvl(helperFuncs.getEnchants(dmgPlayer.getInventory().getItemInMainHand()), "Frozen") > 0) {
                int enchantLvl = helperFuncs.enchantLvl(helperFuncs.getEnchants(dmgPlayer.getInventory().getItemInMainHand()), "Frozen");
                if (random.nextInt(25/enchantLvl) == 0) {
                    hitPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, enchantLvl*20, enchantLvl*3));
                    hitPlayer.playSound(hitPlayer.getLocation(), Sound.BLOCK_GLASS_BREAK, 100, 100);
                    dmgPlayer.playSound(dmgPlayer.getLocation(), Sound.BLOCK_GLASS_BREAK, 100, 100);
                }
            }
            //Lifesteal
            if (helperFuncs.plzNoNull(dmgPlayer.getInventory().getItemInMainHand()) && helperFuncs.enchantLvl(helperFuncs.getEnchants(dmgPlayer.getInventory().getItemInMainHand()), "Lifesteal") > 0) {
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
        //Anti Knockback?
        if (event.getEntity() instanceof Player) {
            Player hitPlayer = (Player) event.getEntity();
            int akLvl = 0;
            if (helperFuncs.plzNoNull(hitPlayer.getInventory().getHelmet()) && helperFuncs.enchantLvl(helperFuncs.getEnchants(hitPlayer.getInventory().getHelmet()), "Anti-Knockback") > 0) {
                akLvl += helperFuncs.enchantLvl(helperFuncs.getEnchants(hitPlayer.getInventory().getHelmet()), "Anti-Knockback");
            }
            if (helperFuncs.plzNoNull(hitPlayer.getInventory().getChestplate()) && helperFuncs.enchantLvl(helperFuncs.getEnchants(hitPlayer.getInventory().getChestplate()), "Anti-Knockback") > 0) {
                akLvl += helperFuncs.enchantLvl(helperFuncs.getEnchants(hitPlayer.getInventory().getChestplate()), "Anti-Knockback");
            }
            if (helperFuncs.plzNoNull(hitPlayer.getInventory().getLeggings()) && helperFuncs.enchantLvl(helperFuncs.getEnchants(hitPlayer.getInventory().getLeggings()), "Anti-Knockback") > 0) {
                akLvl += helperFuncs.enchantLvl(helperFuncs.getEnchants(hitPlayer.getInventory().getLeggings()), "Anti-Knockback");
            }
            if (helperFuncs.plzNoNull(hitPlayer.getInventory().getBoots()) && helperFuncs.enchantLvl(helperFuncs.getEnchants(hitPlayer.getInventory().getBoots()), "Anti-Knockback") > 0) {
                akLvl += helperFuncs.enchantLvl(helperFuncs.getEnchants(hitPlayer.getInventory().getBoots()), "Anti-Knockback");
            }
            if (akLvl > 0) {
                hitPlayer.setVelocity(new Vector());
            }
        }
    }

    @EventHandler
    public void mobKill(EntityDeathEvent event) {
        HelperFuncs helperFuncs = new HelperFuncs();
        if (event.getEntity().getKiller() != null) {
            Player player = event.getEntity().getKiller();
            //Inquisitive
            if (helperFuncs.plzNoNull(player.getInventory().getItemInMainHand()) && helperFuncs.enchantLvl(helperFuncs.getEnchants(player.getInventory().getItemInMainHand()), "§cInquisitive") > 0) {
                int enchantLvl = helperFuncs.enchantLvl(helperFuncs.getEnchants(player.getInventory().getItemInMainHand()), "§cInquisitive");
                event.setDroppedExp(event.getDroppedExp() * ((int) ((double) enchantLvl / 1.5)));
            }
        }
    }
}
