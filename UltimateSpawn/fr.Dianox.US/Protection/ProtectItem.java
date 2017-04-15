package fr.Dianox.US.Protection;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.EventHandler;

import fr.Dianox.US.config.MainConfig;

public class ProtectItem implements Listener {
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        
        if (MainConfig.getConfig().getBoolean("Protection.Drop.Item")) {
        	if (MainConfig.getConfig().getBoolean("Protection.Drop.Item-bypass")) {
        		if (p.hasPermission("UltimateSpawn.bypass.dropitem")){
        			//nothing
        		} else {
        			e.setCancelled(true);
        		}
        	} else {
        		e.setCancelled(true);
        	}
        }
	}
	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent e){
        Player p = e.getPlayer();
        
        if (MainConfig.getConfig().getBoolean("Protection.Pickup.Item")) {
        	if (MainConfig.getConfig().getBoolean("Protection.Pickup.Item-bypass")) {
        		if (p.hasPermission("UltimateSpawn.bypass.Pickupitem")){
        			//nothing
        		} else {
        			e.setCancelled(true);
        		}
        	} else {
        		e.setCancelled(true);
        	}
        }
	}

}
