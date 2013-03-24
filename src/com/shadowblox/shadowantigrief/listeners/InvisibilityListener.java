package com.shadowblox.shadowantigrief.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;
import com.shadowblox.shadowantigrief.Format;
import com.shadowblox.shadowantigrief.ShadowAntiGrief;

public class InvisibilityListener implements Listener {
	public static ShadowAntiGrief plugin;

	public InvisibilityListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}

	@EventHandler(ignoreCancelled = true)
	public void onMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if ((!player.hasPermission("ShadowAntiGrief.allow.invisibility")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Vanish") == true) && (player.hasPotionEffect(PotionEffectType.INVISIBILITY))){
			player.removePotionEffect(PotionEffectType.INVISIBILITY);
			player.sendMessage(Format.invisibilitySettings(""));
		}
	}
}
