package com.shadowblox.shadowantigrief.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.shadowblox.shadowantigrief.Format;
import com.shadowblox.shadowantigrief.ShadowAntiGrief;

public class EggPigListener implements Listener{
	public static ShadowAntiGrief plugin;
	
	public EggPigListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}
	
	@EventHandler(priority=EventPriority.NORMAL)
	public void onPlayerInteracr(PlayerInteractEvent event){
		Player player = event.getPlayer();
		if ((!player.hasPermission("ShadowAntiGrief.allow.egg.pig")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Egg-Pig") == true) && (player.getItemInHand().getTypeId() == 383) && (event.getItem().getDurability() == 90)){
			event.setCancelled(true);
			player.sendMessage(Format.eggSettings("Pig"));
			if ((plugin.getConfig().getBoolean("ModReq-Egg-Pig") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.egg.pig"))){
				player.sendMessage(Format.modreqBuildSettings("Pig"));
			}
		}
	}
}	