package fr.Dianox.US.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass;
import fr.Dianox.US.config.ConfigMessage;
import fr.Dianox.US.config.ConfigSpawn;
import fr.Dianox.US.config.ConfigUtils;
import fr.Dianox.US.config.MainConfig;

public class MainCommand implements CommandExecutor {
	
	MainClass instance = MainClass.getInstance();
	
	public MainCommand() {}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)){
			sender.sendMessage(ConfigUtils.console_use_command);
	        return true;
		}
		
		Player p = (Player)sender;
		
		if(label.equalsIgnoreCase("UltimateSpawn") || label.equalsIgnoreCase("Us") && p.hasPermission("UltimateSpawn.help")){
			if((args.length == 0) || (args[0].equalsIgnoreCase("help"))){
				p.sendMessage("§3//§m---------------§r §c[§rUltimateSpawn§c] §3§m---------------§r§3\\\\");
				p.sendMessage("");
				p.sendMessage(" §8>> §7/setspawn - §eSet the spawn");
				p.sendMessage(" §8>> §7/spawn - §eGo to spawn");
				p.sendMessage(" §8>> §7/uspawn reload - §eReload this skript");
				p.sendMessage("");
				p.sendMessage("§3\\\\§m---------------§r §c[§rUltimateSpawn§c] §3§m---------------§r§3//");
			}
		    else if (args[0].equalsIgnoreCase("reload")) {
		    	if (p.hasPermission("UltimateSpawn.reload")) {
		    		MainConfig.reloadConfig();
		    		ConfigMessage.reloadConfig();
		    		ConfigSpawn.reloadConfig();
		    		ConfigUtils.load();
		          
		    		if ((sender instanceof Player)) {
		    			Bukkit.getLogger().info("UltimateSpawn : Config reloaded");
		    		}
		    		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("others.Config-reloaded")));
		    	} else {
		    		sender.sendMessage(ConfigUtils.no_permission);
		    	}
		          
		    }
		} else {
			sender.sendMessage(ConfigUtils.no_permission);
		}
		return true;
	}
}
