package pickquest.survivalfix;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
//import org.bukkit.event.player.PlayerFishEvent.State;

public class FishingFix implements Listener {
	@EventHandler
	public void fishUp(PlayerFishEvent e) {
		Player player = e.getPlayer();
		World world = player.getWorld();
		Location mobSpawn = player.getEyeLocation();
		Random fish = new Random();
	if(e.getCaught() != null) {
<<<<<<< HEAD
		if(world.toString().equals("I love you")) {
			
=======
>>>>>>> 8b1463c3ebe4ed85bfddd2e4fbcb6bbd088619aa
		
		int fishchance = fish.nextInt(100);
		System.out.println(fishchance);
		if(fishchance == 1){
			world.spawnEntity(mobSpawn, EntityType.GUARDIAN);
		}
		else if(fishchance == 2) {
			world.spawnEntity(mobSpawn, EntityType.WITCH);
		}
	}
<<<<<<< HEAD
	
}
	}
=======
}
>>>>>>> 8b1463c3ebe4ed85bfddd2e4fbcb6bbd088619aa
}
