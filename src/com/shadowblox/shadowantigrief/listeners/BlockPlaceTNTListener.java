package com.shadowblox.shadowantigrief.listeners;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.shadowblox.shadowantigrief.Format;
import com.shadowblox.shadowantigrief.ShadowAntiGrief;

public class BlockPlaceTNTListener implements Listener{
	public static ShadowAntiGrief plugin;
	
	public BlockPlaceTNTListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}
	@EventHandler(ignoreCancelled=true)
	public void onBlockPlace(BlockPlaceEvent event){
	    Player player = event.getPlayer();
	    Block block = event.getBlockPlaced();
	    if ((block.getType() == Material.TNT) && (!player.hasPermission("ShadowAntiGrief.allow.tnt")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-TNT") == true)){
			event.setCancelled(true);
			player.sendMessage(Format.bannedSettings("TNT."));
			if ((plugin.getConfig().getBoolean("ModReq-TNT") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.tnt"))){
				player.sendMessage(Format.modreqSettings("TNT"));
			}
	    }	
	}
}
