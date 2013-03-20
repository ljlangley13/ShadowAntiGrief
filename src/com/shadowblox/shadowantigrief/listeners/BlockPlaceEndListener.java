package com.shadowblox.shadowantigrief.listeners;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.shadowblox.shadowantigrief.Format;
import com.shadowblox.shadowantigrief.ShadowAntiGrief;

public class BlockPlaceEndListener implements Listener{
	public static ShadowAntiGrief plugin;
	
	public BlockPlaceEndListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}
	@EventHandler(ignoreCancelled=true)
	public void onBlockPlace(BlockPlaceEvent event){
	    Player player = event.getPlayer();
	    if ((event.getBlockPlaced().getTypeId() == 119) && (!player.hasPermission("ShadowAntiGrief.allow.end")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-End") == true)){
			event.setCancelled(true);
			player.sendMessage(Format.bannedSettings("End."));
			if ((plugin.getConfig().getBoolean("ModReq-End") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.end"))){
				player.sendMessage(Format.modreqSettings("End"));
			}
	    }
	    if ((event.getBlockPlaced().getTypeId() == 120) && (!player.hasPermission("ShadowAntiGrief.allow.end")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-End") == true)){
			event.setCancelled(true);
			player.sendMessage(Format.bannedSettings("End."));
			if ((plugin.getConfig().getBoolean("ModReq-End") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.end"))){
				player.sendMessage(Format.modreqSettings("End"));
			}
	    }
	}
}
