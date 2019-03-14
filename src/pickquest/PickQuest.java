package pickquest;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

<<<<<<< HEAD
//Structure
/*PickQuest - main class - loads and registers everything else
 
 *ClockTime - creates a universal time system for each sub-server/world - used for NPC and 
 random events. 
 
 *RegistryBoggeun - currently unused
 
 *OriginPoint/EndPoint - used to test pathfinding algorithm. After both are set, a command 
 can be used. 
 
 *BlockTimerTask - currently unused 
 
 *BasicPathfinding, Heuristic, MovementCost, ObstacleFinding, RandomPathing, HumanoidSafety, 
 WaitingLocations, ScanRadiusBlk, BlockMaterialData, SafeBlocks, TestSafeLoc- all currently 
 used in test pathfinding. 
 
 *TestSafeLoc - pushing for detachment, to be free for use, serve multiple functions 
 
 *BlockMaterialData- a list of blocks that are safe above, below, and at location of entity - 
 may only be viable for humanoid entities right now 
 
 *ScanRadiusBlk - simple operation - takes all blocks in a given radius and adds them to an arraylist 
 for processing
 
 *FishingFix - temporary fix to reduce AFK fishing farms - 2% chance to spawn a hostile mob with 
 *every caught fish. 
 
 *GameModeFork - serves basically no purpose, but may be used to subdivide players based on what 
 game mode and world they're in. Essential in RPG functions of each server. 
 
 *
 **/



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
