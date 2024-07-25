package dev.cmccall.oxygenDeficiency;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Events implements Listener {
    boolean playerNegative = false;
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        boolean playerY = e.getPlayer().getLocation().getY() < 0 || e.getPlayer().getLocation().getY() > 200;
        Player player = (Player) e.getPlayer();
        if (playerY && !player.hasPotionEffect(PotionEffectType.STRENGTH) && !playerNegative) {
            player.sendMessage("Oof, there's not a lot of oxygen here... I need more strength...");
            player.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, -1, 1));
            playerNegative = true;
        } else if(!playerY || player.hasPotionEffect(PotionEffectType.STRENGTH)) {
            player.removePotionEffect(PotionEffectType.NAUSEA);
            playerNegative = false;
        }
    }
}