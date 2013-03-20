package com.shadowblox.shadowantigrief.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.shadowblox.shadowantigrief.Format;
import com.shadowblox.shadowantigrief.ShadowAntiGrief;

public class EggMagmaCubeListener implements Listener{
	public static ShadowAntiGrief plugin;
	
	public EggMagmaCubeListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}
	
	@EventHandler(priority=EventPriority.NORMAL)
	public void onPlayerInteracr(PlayerInteractEvent event){
		Player player = event.getPlayer();
		if ((!player.hasPermission("ShadowAntiGrief.allow.egg.magmacube")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Egg-MagmaCube") == true) && (player.getItemInHand().getTypeId() == 383) && (event.getItem().getDurability() == 62)){
			event.setCancelled(true);
			player.sendMessage(Format.eggSettings("MagmaCube"));
			if ((plugin.getConfig().getBoolean("ModReq-Egg-MagmaCube") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.egg.magmacube"))){
				player.sendMessage(Format.modreqBuildSettings("MagmaCube"));
			}
		}
	}
}	