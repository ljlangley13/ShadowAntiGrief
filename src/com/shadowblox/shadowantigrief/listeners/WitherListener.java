package com.shadowblox.shadowantigrief.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import com.shadowblox.shadowantigrief.ShadowAntiGrief;

public class WitherListener implements Listener{
	public static ShadowAntiGrief plugin;
	
	public WitherListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}
	
	@EventHandler(priority=EventPriority.NORMAL)
	public void onWitherSpawn(CreatureSpawnEvent event){
		if ((plugin.getConfig().getBoolean("Block-Wither-Spawn") == true) && (event.getEntityType().equals(EntityType.WITHER))){
			event.setCancelled(true);
		}
	}
}	