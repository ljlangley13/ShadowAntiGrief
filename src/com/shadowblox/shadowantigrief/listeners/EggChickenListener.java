package com.shadowblox.shadowantigrief.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.shadowblox.shadowantigrief.Format;
import com.shadowblox.shadowantigrief.ShadowAntiGrief;

public class EggChickenListener implements Listener{
	public static ShadowAntiGrief plugin;
	
	public EggChickenListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}
	
	@EventHandler(priority=EventPriority.NORMAL)
	public void onPlayerInteracr(PlayerInteractEvent event){
		Player player = event.getPlayer();
		if ((!player.hasPermission("ShadowAntiGrief.allow.egg.chicken")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Egg-Chicken") == true) && (player.getItemInHand().getTypeId() == 383) && (event.getItem().getDurability() == 93)){
			event.setCancelled(true);
			player.sendMessage(Format.eggSettings("Chicken"));
			if ((plugin.getConfig().getBoolean("ModReq-Egg-Chicken") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.egg.chicken"))){
				player.sendMessage(Format.modreqBuildSettings("Chicken"));
			}
		}
		else{
			if ((!player.hasPermission("ShadowAntiGrief.allow.egg.chicken")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Egg-Chicken") == true) && (player.getItemInHand().getTypeId() == 344)){
				event.setCancelled(true);
				player.sendMessage(Format.eggSettings("Chicken"));
				if ((plugin.getConfig().getBoolean("ModReq-Egg-Chicken") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.egg.chicken"))){
					player.sendMessage(Format.modreqBuildSettings("Chicken"));
				}
			}
		}
	}
}	