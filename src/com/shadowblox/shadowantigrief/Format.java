package com.shadowblox.shadowantigrief;

import org.bukkit.ChatColor;

public class Format {
	public static String bannedColour = "" + ChatColor.DARK_RED;
	public static String eggColour = "" + ChatColor.DARK_RED;
	public static String invisibilityColour = "" + ChatColor.DARK_RED;
	public static String errorRequestColour = "" + ChatColor.DARK_RED;
	public static String modreqColour = "" + ChatColor.GOLD;
	public static String infoColour = "" + ChatColor.GOLD;
	public static String requestColour = "" + ChatColor.GOLD;
	public static String rememberColour = "" + ChatColor.YELLOW;
	public static String helpinfoColour = "" + ChatColor.GRAY;
	public static String helpdescriptionColour = "" + ChatColor.WHITE;

	public static String bannedSettings(String string) {
		return bannedColour + "You're not allowed to place " + string;
	}
	public static String modreqSettings(String string) {
		return modreqColour + "If you would like to request " + string
				+ ", please type /modreq " + string + ".";
	}

	public static String eggSettings(String string) {
		return eggColour + "You're not allowed to use a " + string + " egg.";
	}

	public static String modreqBuildSettings(String string) {
		return modreqColour + "If you would like to request to " + string
				+ ", please type /modreq " + string + ".";
	}

	public static String infoSettings(String string) {
		return infoColour + "" + string;
	}
	
	public static String rememberSettings(String string) {
		return rememberColour + "" + string;
	}

	public static String helpSettings(String string) {
		return helpinfoColour + "/ShadowAntiGrief " + string;
	}
	
	public static String invisibilitySettings(String string) {
		return invisibilityColour + "You're not allowed to be invisable." + string;
	}

	public static String helpDescriptionSettings(String string) {
		return helpdescriptionColour + " - " + string;
	}

	public static String requestSettings(String string) {
		return requestColour + "" + string;
	}

	public static String errorRequestSettings(String string) {
		return errorRequestColour + "" + string;
	}
}
