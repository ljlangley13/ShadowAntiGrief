package com.shadowblox.shadowantigrief.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.shadowblox.shadowantigrief.ShadowAntiGrief;

public class ChatListener implements Listener {
	public static ShadowAntiGrief plugin;

	public ChatListener(ShadowAntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}

	@EventHandler(priority=EventPriority.HIGHEST)
	public void onCommandPostProcess(PlayerCommandPreprocessEvent event) {
		if(plugin.getConfig().getBoolean("Enable-OPNoCommands") == true){
			Player player = (Player) event.getPlayer();
			if (player.isOp()) {
				player.sendMessage(ChatColor.DARK_RED + "All commands are disabled for OP.");
				event.setCancelled(true);
			}
		}

	}
}