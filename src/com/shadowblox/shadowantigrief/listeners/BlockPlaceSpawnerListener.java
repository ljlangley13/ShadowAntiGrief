package com.shadowblox.shadowantigrief.listeners;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.shadowblox.shadowantigrief.Format;
import com.shadowblox.shadowantigrief.ShadowAntiGrief;

public class BlockPlaceSpawnerListener implements Listener{
	public static ShadowAntiGrief plugin;
	
	public BlockPlaceSpawnerListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}
	@EventHandler(ignoreCancelled=true)
	public void onBlockPlace(BlockPlaceEvent event){
	    Player player = event.getPlayer();
	    if ((event.getBlockPlaced().getTypeId() == 52)&& (!player.hasPermission("ShadowAntiGrief.allow.spawner")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Spawner") == true)){
			event.setCancelled(true);
			player.sendMessage(Format.bannedSettings("Spawner."));
			if ((plugin.getConfig().getBoolean("ModReq-Spawner") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.spawner"))){
				player.sendMessage(Format.modreqSettings("Spawner"));
			}
	    }	
	}
}
