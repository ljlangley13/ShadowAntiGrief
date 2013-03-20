package com.shadowblox.shadowantigrief.listeners;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.shadowblox.shadowantigrief.Format;
import com.shadowblox.shadowantigrief.ShadowAntiGrief;

public class BlockPlaceIceListener implements Listener{
	public static ShadowAntiGrief plugin;
	
	public BlockPlaceIceListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}
	@EventHandler(ignoreCancelled=true)
	public void onBlockPlace(BlockPlaceEvent event){
	    Player player = event.getPlayer();
	    if ((event.getBlockPlaced().getTypeId() == 79) && (!player.hasPermission("ShadowAntiGrief.allow.ice")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Ice") == true)){
			event.setCancelled(true);
			player.sendMessage(Format.bannedSettings("Ice."));
			if ((plugin.getConfig().getBoolean("ModReq-Ice") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.ice"))){
				player.sendMessage(Format.modreqSettings("Ice"));
			}
	    }	
	}
}
