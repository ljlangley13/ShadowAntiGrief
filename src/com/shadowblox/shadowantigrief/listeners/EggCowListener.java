package com.shadowblox.shadowantigrief.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.shadowblox.shadowantigrief.Format;
import com.shadowblox.shadowantigrief.ShadowAntiGrief;

public class EggCowListener implements Listener{
	public static ShadowAntiGrief plugin;
	
	public EggCowListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}
	
	@EventHandler(priority=EventPriority.NORMAL)
	public void onPlayerInteracr(PlayerInteractEvent event){
		Player player = event.getPlayer();
		if ((!player.hasPermission("ShadowAntiGrief.allow.egg.cow")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Egg-Cow") == true) && (player.getItemInHand().getTypeId() == 383) && (event.getItem().getDurability() == 92)){
			event.setCancelled(true);
			player.sendMessage(Format.eggSettings("Cow"));
			if ((plugin.getConfig().getBoolean("ModReq-Egg-Cow") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.egg.cow"))){
				player.sendMessage(Format.modreqBuildSettings("Cow"));
			}
		}
	}
}	