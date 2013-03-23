package com.shadowblox.shadowantigrief.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import com.shadowblox.shadowantigrief.ShadowAntiGrief;

public class CreeperExplosionListener implements Listener {
	public static ShadowAntiGrief plugin;

	public CreeperExplosionListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}

	@EventHandler(ignoreCancelled = true)
	public void chatPlayer(EntityExplodeEvent event) {
		String type = event.getEntityType().getName();
		if (type == "Creeper") {
			if ((plugin.getConfig().getBoolean("Creeper-Explosion") == true)) {
				event.setCancelled(true);
			}
		}
	}
}
