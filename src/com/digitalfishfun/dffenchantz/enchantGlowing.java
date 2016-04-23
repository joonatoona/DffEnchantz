package com.digitalfishfun.dffenchantz;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collection;

/**
 * Created by joonatoona on 4/22/16.
 */
public class enchantGlowing implements Runnable {
    @Override
    public void run() {
        HelperFuncs helperFuncs = new HelperFuncs();
        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
            if (p.getInventory().getHelmet() != null && p.getInventory().getHelmet().getItemMeta().hasLore() &&
                    p.getInventory().getHelmet().getItemMeta().getLore().contains("§7Glowing 1")) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 500, 0), true);
            }
        }
    }
}
