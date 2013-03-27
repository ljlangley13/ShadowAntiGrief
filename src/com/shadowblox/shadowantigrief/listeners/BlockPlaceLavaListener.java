package com.shadowblox.shadowantigrief.listeners;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

import com.shadowblox.shadowantigrief.Format;
import com.shadowblox.shadowantigrief.ShadowAntiGrief;

public class BlockPlaceLavaListener implements Listener{
	public static ShadowAntiGrief plugin;
	
	public BlockPlaceLavaListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}
	@EventHandler(ignoreCancelled=true)
	public void onBlockPlace(BlockPlaceEvent event){
	    Player player = event.getPlayer();
	    if ((event.getBlockPlaced().getTypeId() == 10) && (event.getBlockPlaced().getTypeId() == 11) && (!player.hasPermission("ShadowAntiGrief.allow.lava")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Lava") == true)){
			event.setCancelled(true);
			player.sendMessage(Format.bannedSettings("Lava."));
			if ((plugin.getConfig().getBoolean("ModReq-Lava") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.lava"))){
				player.sendMessage(Format.modreqSettings("Lava"));
			}
	    }
	}
	@EventHandler(ignoreCancelled=true)
	public void onPlayerBucketEmpty(PlayerBucketEmptyEvent event) {
	    Player player = event.getPlayer();
	    if ((!player.hasPermission("ShadowAntiGrief.allow.lava")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Lava") == true) && (player.getItemInHand().getTypeId() == 327)){
			event.setCancelled(true);
			player.sendMessage(Format.bannedSettings("Lava."));
			if ((plugin.getConfig().getBoolean("ModReq-Lava") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.lava"))){
				player.sendMessage(Format.modreqSettings("Lava"));
			}
	    }
	}
}
