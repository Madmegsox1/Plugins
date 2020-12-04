package kill.madmeg;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "/kill activating!");

	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "/kill deactivating");
		
	}

	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if (lable.equalsIgnoreCase("kill")) {
			if (sender instanceof Player) {
				//player
				Player p = (Player) sender;
				
				p.damage(1000);
				Bukkit.broadcastMessage(ChatColor.AQUA +  p.getDisplayName() + ChatColor.DARK_RED + " Killed them self");

				return true;
			
			}
			
			else {
				//console
				sender.sendMessage("no you cant kill yourself consol");
				
			}
	}
		return false;
	}


}