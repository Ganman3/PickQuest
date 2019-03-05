package pickquest;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import pickquest.ai.pathfinding.tool.EndPoint;
import pickquest.ai.pathfinding.tool.OriginPoint;
import pickquest.common.ClockTime;
import pickquest.common.TestingAlert;
import pickquest.survivalfix.FishingFix;
import pickquest.testing.TestSafeLoc;

public class PickQuest extends JavaPlugin {
	
	@SuppressWarnings("unused")
	@Override
	public void onEnable() {
		BukkitTask ct = new ClockTime(this).runTaskTimer(this,0,10);
		this.getCommand("testsafe").setExecutor(new TestSafeLoc());
		this.getServer().getPluginManager().registerEvents(new OriginPoint(), this);
		this.getServer().getPluginManager().registerEvents(new EndPoint(), this);
		this.getServer().getPluginManager().registerEvents(new FishingFix(), this);
		this.getCommand("testmode").setExecutor(new TestingAlert());
	}
	@Override
	public void onDisable() {
		
	}
}
