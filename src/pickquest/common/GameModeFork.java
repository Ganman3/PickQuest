package pickquest.common;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class GameModeFork {
	public void forkPlayer (Player player) {
		if (player.getGameMode() == GameMode.ADVENTURE && player.getWorld().getName().equals("Raalekh2")) {
			String worldname = player.getWorld().getName();
			if(Bukkit.getWorld(worldname).getTime() % 100 == 0 || Bukkit.getWorld(worldname).getTime() == 0) {
				System.out.println(Bukkit.getWorld(worldname).getTime());
			}
		}
		if(player.getGameMode() == GameMode.SURVIVAL && player.getWorld().getName().equals("I love you")) {
			
		}
	}
}
