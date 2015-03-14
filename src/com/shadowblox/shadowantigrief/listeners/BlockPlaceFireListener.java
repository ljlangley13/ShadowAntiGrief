package com.shadowblox.shadowantigrief.listeners;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import com.shadowblox.shadowantigrief.Format;
import com.shadowblox.shadowantigrief.ShadowAntiGrief;

public class BlockPlaceFireListener implements Listener{
	public static ShadowAntiGrief plugin;
	
	public BlockPlaceFireListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}
	@EventHandler(ignoreCancelled=true)
	public void onBlockIgnite(BlockIgniteEvent event){
	    Player player = event.getPlayer();
	    if ((event.getPlayer() instanceof Player) && (!player.hasPermission("ShadowAntiGrief.allow.fire")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Fire") == true)){
			event.setCancelled(true);
			player.sendMessage(Format.bannedSettings("Fire."));
			if ((plugin.getConfig().getBoolean("ModReq-Fire") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.fire"))){
				player.sendMessage(Format.modreqSettings("Fire"));
			}
	    }	
	}
	@EventHandler(ignoreCancelled=true)
	public void onBlockPlace(BlockPlaceEvent event){
	    Player player = event.getPlayer();
	    Block block = event.getBlockPlaced();
	    if ((block.getType() == Material.FIRE)&& (!player.hasPermission("ShadowAntiGrief.allow.fire")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Fire") == true)){
			event.setCancelled(true);
			player.sendMessage(Format.bannedSettings("Fire."));
			if ((plugin.getConfig().getBoolean("ModReq-Fire") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.fire"))){
				player.sendMessage(Format.modreqSettings("Fire"));
			}
	    }	
	}

}
