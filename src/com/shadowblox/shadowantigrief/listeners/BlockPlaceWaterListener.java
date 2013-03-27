package com.shadowblox.shadowantigrief.listeners;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

import com.shadowblox.shadowantigrief.Format;
import com.shadowblox.shadowantigrief.ShadowAntiGrief;

public class BlockPlaceWaterListener implements Listener{
	public static ShadowAntiGrief plugin;
	
	public BlockPlaceWaterListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}
	@EventHandler(ignoreCancelled=true)
	public void onBlockPlace(BlockPlaceEvent event){
	    Player player = event.getPlayer();
	    if ((event.getBlockPlaced().getTypeId() == 8) && (event.getBlockPlaced().getTypeId() == 9) && (!player.hasPermission("ShadowAntiGrief.allow.water")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Water") == true)){
			event.setCancelled(true);
			player.sendMessage(Format.bannedSettings("Water."));
			if ((plugin.getConfig().getBoolean("ModReq-Water") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.water"))){
				player.sendMessage(Format.modreqSettings("Water"));
			}
	    }
	}
	@EventHandler(ignoreCancelled=true)
	public void onPlayerBucketEmpty(PlayerBucketEmptyEvent event) {
	    Player player = event.getPlayer();
	    if ((!player.hasPermission("ShadowAntiGrief.allow.water")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Water") == true) && (player.getItemInHand().getTypeId() == 326)){
			event.setCancelled(true);
			player.sendMessage(Format.bannedSettings("Water."));
			if ((plugin.getConfig().getBoolean("ModReq-Water") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.water"))){
				player.sendMessage(Format.modreqSettings("Water"));
			}
	    }
	}
}
