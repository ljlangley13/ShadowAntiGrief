package com.shadowblox.shadowantigrief.managers;

import com.shadowblox.shadowantigrief.ShadowAntiGrief;
import com.shadowblox.shadowantigrief.commands.SAGCommand;
import com.shadowblox.shadowantigrief.commands.ShadowAntiGriefCommand;

public class CommandManager {
	public ShadowAntiGriefCommand shadowantigriefCommand;
	public SAGCommand sagCommand;
	public ShadowAntiGrief plugin;

	public CommandManager(ShadowAntiGrief shadowAntiGrief) {
		this.plugin = shadowAntiGrief;
	}

	public void initCommands() {
		this.shadowantigriefCommand = new ShadowAntiGriefCommand(plugin);
		this.sagCommand = new SAGCommand(plugin);

		this.plugin.getCommand("ShadowAntiGrief").setExecutor(
				this.shadowantigriefCommand);
		this.plugin.getCommand("SAG").setExecutor(this.sagCommand);
	}
}