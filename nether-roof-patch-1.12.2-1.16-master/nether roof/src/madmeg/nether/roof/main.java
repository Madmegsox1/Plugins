package madmeg.nether.roof;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener{
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "Nether roof patch active!");

	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "Nether roof patch deactivating");
		
	}
	
	@EventHandler
	public void yCheck(PlayerMoveEvent event) {
		Player p = (Player) event.getPlayer();
		double x = p.getLocation().getX();
		double y = 126;
		double z = p.getLocation().getZ();
		if (!(p.hasPermission("nether.roof"))){
			if (p.getLocation().getWorld().getName().endsWith("_nether")) {
					if (p.getLocation().getY() > 127) {
						World wold = p.getLocation().getWorld();
						p.teleport(new Location(wold, x, y, z));
						
						
						p.damage(7);
					}
				}
			}


	}

}
