package com.shadowblox.shadowantigrief;

import com.shadowblox.shadowantigrief.commands.ShadowAntiGriefCommand;
import com.shadowblox.shadowantigrief.listeners.BlockPlaceAnyListener;
import com.shadowblox.shadowantigrief.listeners.BlockPlaceBeaconListener;
import com.shadowblox.shadowantigrief.listeners.BlockPlaceBedrockListener;
import com.shadowblox.shadowantigrief.listeners.BlockPlaceDispenserListener;
import com.shadowblox.shadowantigrief.listeners.BlockPlaceDropperListener;
import com.shadowblox.shadowantigrief.listeners.BlockPlaceEndListener;
import com.shadowblox.shadowantigrief.listeners.BlockPlaceFireListener;
import com.shadowblox.shadowantigrief.listeners.BlockPlaceIceListener;
import com.shadowblox.shadowantigrief.listeners.BlockPlaceLavaListener;
import com.shadowblox.shadowantigrief.listeners.BlockPlaceSnowListener;
import com.shadowblox.shadowantigrief.listeners.BlockPlaceSpawnerListener;
import com.shadowblox.shadowantigrief.listeners.BlockPlaceTNTListener;
import com.shadowblox.shadowantigrief.listeners.BlockPlaceWaterListener;
import com.shadowblox.shadowantigrief.listeners.CreeperExplosionListener;
import com.shadowblox.shadowantigrief.listeners.EggBatListener;
import com.shadowblox.shadowantigrief.listeners.EggBlazeListener;
import com.shadowblox.shadowantigrief.listeners.EggCaveSpiderListener;
import com.shadowblox.shadowantigrief.listeners.EggChickenListener;
import com.shadowblox.shadowantigrief.listeners.EggCowListener;
import com.shadowblox.shadowantigrief.listeners.EggCreeperListener;
import com.shadowblox.shadowantigrief.listeners.EggEndermanListener;
import com.shadowblox.shadowantigrief.listeners.EggMagmaCubeListener;
import com.shadowblox.shadowantigrief.listeners.EggMooshroomListener;
import com.shadowblox.shadowantigrief.listeners.EggOcelotListener;
import com.shadowblox.shadowantigrief.listeners.EggPigListener;
import com.shadowblox.shadowantigrief.listeners.EggSheepListener;
import com.shadowblox.shadowantigrief.listeners.EggSilverfishListener;
import com.shadowblox.shadowantigrief.listeners.EggSkeletonListener;
import com.shadowblox.shadowantigrief.listeners.EggSpiderListener;
import com.shadowblox.shadowantigrief.listeners.EggSquidListener;
import com.shadowblox.shadowantigrief.listeners.EggVillagerListener;
import com.shadowblox.shadowantigrief.listeners.EggWitchListener;
import com.shadowblox.shadowantigrief.listeners.EggWolfListener;
import com.shadowblox.shadowantigrief.listeners.EggZombieListener;
import com.shadowblox.shadowantigrief.listeners.WitherListener;
import com.shadowblox.shadowantigrief.managers.CommandManager;
import java.io.File;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class ShadowAntiGrief extends JavaPlugin {
	public final Logger logger = Bukkit.getServer().getLogger();
	public static ShadowAntiGrief plugin;
	public CommandManager commandManager;
	public ShadowAntiGriefCommand shadowantigriefCommand;
	private static ShadowAntiGrief instance;

	public static ShadowAntiGrief getInstance() {
		return instance;
	}

	public void onEnable() {
		File configFile = new File(getDataFolder().getAbsolutePath(),
				"config.yml");
		if (!configFile.exists()) {
			configFile.mkdir();
			saveDefaultConfig();
		}
		initializeListeners();
		instance = this;
		commandManager = new CommandManager(this) {
			{
				initCommands();
			}
		};
	}

	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		this.logger.info(pdfFile.getName() + " has been disabled");
	}

	public void initializeListeners() {
		new BlockPlaceAnyListener(this);
		new BlockPlaceBeaconListener(this);
		new BlockPlaceBedrockListener(this);
		new BlockPlaceDispenserListener(this);
		new BlockPlaceDropperListener(this);
		new BlockPlaceEndListener(this);
		new BlockPlaceFireListener(this);
		new BlockPlaceIceListener(this);
		new BlockPlaceLavaListener(this);
		new BlockPlaceSnowListener(this);
		new BlockPlaceSpawnerListener(this);
		new BlockPlaceTNTListener(this);
		new BlockPlaceWaterListener(this);
		new WitherListener(this);
		new CreeperExplosionListener(this);

		new EggCreeperListener(this);
		new EggSkeletonListener(this);
		new EggSpiderListener(this);
		new EggZombieListener(this);
		new EggEndermanListener(this);
		new EggCaveSpiderListener(this);
		new EggSilverfishListener(this);
		new EggBlazeListener(this);
		new EggMagmaCubeListener(this);
		new EggWitchListener(this);
		new EggBatListener(this);
		new EggPigListener(this);
		new EggSheepListener(this);
		new EggCowListener(this);
		new EggChickenListener(this);
		new EggSquidListener(this);
		new EggWolfListener(this);
		new EggMooshroomListener(this);
		new WitherListener(this);
		new EggOcelotListener(this);
		new EggVillagerListener(this);
		new CreeperExplosionListener(this);
	}
}