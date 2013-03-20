package com.shadowblox.shadowantigrief.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.shadowblox.shadowantigrief.Format;
import com.shadowblox.shadowantigrief.ShadowAntiGrief;

public class EggVillagerListener implements Listener{
	public static ShadowAntiGrief plugin;
	
	public EggVillagerListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}
	
	@EventHandler(priority=EventPriority.NORMAL)
	public void onPlayerInteracr(PlayerInteractEvent event){
		Player player = event.getPlayer();
		if ((!player.hasPermission("ShadowAntiGrief.allow.egg.villager")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Egg-Villager") == true) && (player.getItemInHand().getTypeId() == 383) && (event.getItem().getDurability() == 78)){
			event.setCancelled(true);
			player.sendMessage(Format.eggSettings("Villager"));
			if ((plugin.getConfig().getBoolean("ModReq-Egg-Villager") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.egg.villager"))){
				player.sendMessage(Format.modreqBuildSettings("Villager"));
			}
		}
	}
}	