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

public class BlockPlaceDropperListener implements Listener{
	public static ShadowAntiGrief plugin;
	
	public BlockPlaceDropperListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}
	@EventHandler(ignoreCancelled=true)
	public void onBlockPlace(BlockPlaceEvent event){
	    Player player = event.getPlayer();
	    Block block = event.getBlockPlaced();
	    if ((block.getType() == Material.DROPPER) && (!player.hasPermission("ShadowAntiGrief.allow.dropper")) && (!player.isOp())  && (plugin.getConfig().getBoolean("Enable-Dropper") == true)){
			event.setCancelled(true);
			player.sendMessage(Format.bannedSettings("Dropper."));
			if ((plugin.getConfig().getBoolean("ModReq-Dropper") == true) && (player.hasPermission("ShadowAntiGrief.allowrequest.dropper"))){
				player.sendMessage(Format.modreqSettings("Dropper"));
			}
	    }	
	}
}
