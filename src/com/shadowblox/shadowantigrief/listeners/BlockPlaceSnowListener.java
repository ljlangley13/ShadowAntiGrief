package com.shadowblox.shadowantigrief.listeners;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.shadowblox.shadowantigrief.Format;
import com.shadowblox.shadowantigrief.ShadowAntiGrief;

public class BlockPlaceSnowListener implements Listener{
	public static ShadowAntiGrief plugin;
	
	public BlockPlaceSnowListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}
	@EventHandler(ignoreCancelled=true)
	public void onBlockPlace(BlockPlaceEvent event){
	    Player player = event.getPlayer();
	    if ((event.getBlockPlaced().getTypeId() == 78) && (!player.hasPermission("ShadowAntiGrief.allow.snow")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Snow") == true)){
			event.setCancelled(true);
			player.sendMessage(Format.bannedSettings("Snow."));
			if ((plugin.getConfig().getBoolean("ModReq-Snow") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.snow"))){
				player.sendMessage(Format.modreqSettings("Snow"));
			}
	    }
	    if ((event.getBlockPlaced().getTypeId() == 80) && (!player.hasPermission("ShadowAntiGrief.allow.snow")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Snow") == true)){
			event.setCancelled(true);
			player.sendMessage(Format.bannedSettings("Snow."));
			if ((plugin.getConfig().getBoolean("ModReq-Snow") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.snow"))){
				player.sendMessage(Format.modreqSettings("Snow"));
			}
	    }
	}
}
