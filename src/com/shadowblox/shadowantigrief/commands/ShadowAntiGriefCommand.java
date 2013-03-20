package com.shadowblox.shadowantigrief.commands;

import com.shadowblox.shadowantigrief.Format;
import com.shadowblox.shadowantigrief.ShadowAntiGrief;
import com.shadowblox.shadowantigrief.korikutils.SubCommandExecutor;
import org.bukkit.command.CommandSender;

public class ShadowAntiGriefCommand extends SubCommandExecutor{
	public ShadowAntiGriefCommand(ShadowAntiGrief instance){
	}
  @command
  public void Null(CommandSender sender, String[] args)
  {
    sender.sendMessage(Format.infoSettings("ShadowAntiGrief:"));
    sender.sendMessage(Format.helpSettings("Help") + Format.helpDescriptionSettings("Shows you the help."));
  }
  @command
  public void help(CommandSender sender, String[] args)
  {
    sender.sendMessage(Format.infoSettings("ShadowAntiGrief Commands:"));
    sender.sendMessage(Format.helpSettings("Help") + Format.helpDescriptionSettings("Shows you the help."));
    sender.sendMessage(Format.helpSettings("Version") + Format.helpDescriptionSettings("Shows you the plugin version."));
  }
  @command
  public void version(CommandSender sender, String[] args)
  {
    sender.sendMessage(Format.infoSettings("The version of ShadowAntiGrief you're running is: " + ShadowAntiGrief.getInstance().getDescription().getVersion()));
  }
}