package pickquest;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import pickquest.common.ClockTime;
import pickquest.testing.TestSafeLoc;

public class PickQuest extends JavaPlugin {
	
	@SuppressWarnings("unused")
	@Override
	public void onEnable() {
		BukkitTask ct = new ClockTime(this).runTaskTimer(this,0,10);
		this.getCommand("testsafe").setExecutor(new TestSafeLoc());
		
	}
	@Override
	public void onDisable() {
		
	}
}
