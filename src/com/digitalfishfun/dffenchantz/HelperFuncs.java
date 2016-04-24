package com.digitalfishfun.dffenchantz;

import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

/**
 * Created by joonatoona on 4/22/16.
 */
public class HelperFuncs {

    public ArrayList<String[]> getEnchants(ItemStack item) {
        ArrayList<String[]> cEnchants = new ArrayList<String[]>();
        String[] cParse;
        if (item != null && item.hasItemMeta() && item.getItemMeta().hasLore()) {
            for (int i = 0; i < item.getItemMeta().getLore().size(); i++) {
                cParse = item.getItemMeta().getLore().get(i).split(" ");
                cParse[0] = cParse[0].substring(2);
                if (cParse.length == 2 && NumberUtils.isNumber(cParse[1])) {
                    cEnchants.add(cParse);
                }
            }
        }
        return cEnchants;
    }
    public int enchantLvl(ArrayList<String[]> enchants, String enchantName) {
        for (int i=0; i < enchants.size(); i++) {
            if (enchants.get(i)[0].equals(enchantName)) {
                return Integer.parseInt(enchants.get(i)[1]);
            }
        }
        return 0;
    }
}