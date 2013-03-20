package com.shadowblox.shadowantigrief.listeners;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.shadowblox.shadowantigrief.Format;
import com.shadowblox.shadowantigrief.ShadowAntiGrief;

public class BlockPlaceBedrockListener implements Listener{
	public static ShadowAntiGrief plugin;
	
	public BlockPlaceBedrockListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}
	@EventHandler(ignoreCancelled=true)
	public void onBlockPlace(BlockPlaceEvent event){
	    Player player = event.getPlayer();
	    if ((event.getBlockPlaced().getTypeId() == 7) && (!player.hasPermission("ShadowAntiGrief.allow.bedrock")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Bedrock") == true)){
			event.setCancelled(true);
			player.sendMessage(Format.bannedSettings("Bedrock."));
			if ((plugin.getConfig().getBoolean("ModReq-Bedrock") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.bedrock"))){
				player.sendMessage(Format.modreqSettings("Bedrock"));
			}
	    }	
	}
}
