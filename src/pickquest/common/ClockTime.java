package pickquest.common;
//PickQuest -> ClockTime -> GameModeFork (Sorts players into world protocol)

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import pickquest.PickQuest;

public class ClockTime extends BukkitRunnable {
	private boolean executed;
	private PickQuest pq;
	public PickQuest getPQPlugin(PickQuest pq) {
		return pq;
	}
	public PickQuest getPickQuest() {
		return pq;
	}
	public void setPickQuest(PickQuest pq) {
		this.pq = pq;
	}
	public ClockTime(PickQuest pq) {
		this.setPickQuest(pq);
	}

	@Override
	public void run() {
		if(!executed) {
		//This allows for predictable, controlled timing, so that I don't have
			//to use my runnable in excess.
		for(World world: Bukkit.getWorlds()){
			if((world.getTime() % 10 != 0) || world.getTime() != 0) {
				long time = world.getTime();
				int rem = (int) (time % 10);
				long newtime = time -= rem;
				world.setTime(newtime);
				System.out.println("The time in " + world.getName() + "is now " + newtime + "!");
			}
		}
	}
	executed = true;	
			
		for(Player player:Bukkit.getOnlinePlayers()) {
				GameModeFork gf = new GameModeFork();
				gf.forkPlayer(player);
		}
		
	}

}
