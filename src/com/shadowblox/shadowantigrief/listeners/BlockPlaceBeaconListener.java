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

public class BlockPlaceBeaconListener implements Listener {
	public static ShadowAntiGrief plugin;

	public BlockPlaceBeaconListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}

	@EventHandler(ignoreCancelled = true)
	public void onBlockPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		Block block = event.getBlockPlaced();
		if ((block.getType() == Material.BEACON)
				&& (!player.hasPermission("ShadowAntiGrief.allow.beacon"))
				&& (!player.isOp())
				&& (plugin.getConfig().getBoolean("Enable-Beacon") == true)) {
			event.setCancelled(true);
			player.sendMessage(Format.bannedSettings("Beacon."));
			if ((plugin.getConfig().getBoolean("ModReq-Beacon") == true)
					&& (player
							.hasPermission("ShadowAntiGrief.allowrequest.beacon"))) {
				player.sendMessage(Format.modreqSettings("Beacon"));
			}
		}
	}
}
