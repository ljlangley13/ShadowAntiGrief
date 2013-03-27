package com.shadowblox.shadowantigrief.listeners;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import com.shadowblox.shadowantigrief.Format;
import com.shadowblox.shadowantigrief.ShadowAntiGrief;

public class BuildListener implements Listener{
	public static ShadowAntiGrief plugin;
	
	public BuildListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}
	@EventHandler(ignoreCancelled=true)
	public void onBlockPlace(BlockPlaceEvent event){
	    Player player = event.getPlayer();
	    if ((!player.hasPermission("ShadowAntiGrief.allow.build")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Build") == true)){
			event.setCancelled(true);
			player.sendMessage(Format.bannedSettings("any blocks here."));
			if ((plugin.getConfig().getBoolean("ModReq-Build") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.build"))){
				player.sendMessage(Format.modreqBuildSettings("build"));
			}
	    }	
	}
	@EventHandler(ignoreCancelled=true)
	public void onBlockBreak(BlockBreakEvent event){
	    Player player = event.getPlayer();
	    if ((!player.hasPermission("ShadowAntiGrief.allow.build")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Build") == true)){
			event.setCancelled(true);
			player.sendMessage(Format.bannedSettings("or break any blocks here."));
			if ((plugin.getConfig().getBoolean("ModReq-Build") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.build"))){
				player.sendMessage(Format.modreqBuildSettings("build"));
			}
	    }	
	}
}
