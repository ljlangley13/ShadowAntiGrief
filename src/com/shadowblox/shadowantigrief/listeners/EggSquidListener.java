package com.shadowblox.shadowantigrief.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.shadowblox.shadowantigrief.Format;
import com.shadowblox.shadowantigrief.ShadowAntiGrief;

public class EggSquidListener implements Listener{
	public static ShadowAntiGrief plugin;
	
	public EggSquidListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}
	
	@EventHandler(priority=EventPriority.NORMAL)
	public void onPlayerInteracr(PlayerInteractEvent event){
		Player player = event.getPlayer();
		if ((!player.hasPermission("ShadowAntiGrief.allow.egg.squid")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Egg-Squid") == true) && (player.getItemInHand().getTypeId() == 383) && (event.getItem().getDurability() == 94)){
			event.setCancelled(true);
			player.sendMessage(Format.eggSettings("Squid"));
			if ((plugin.getConfig().getBoolean("ModReq-Egg-Squid") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.egg.squid"))){
				player.sendMessage(Format.modreqBuildSettings("Squid"));
			}
		}
	}
}	