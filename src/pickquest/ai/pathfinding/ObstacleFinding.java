package pickquest.ai.pathfinding;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

public class ObstacleFinding {
	public double calculateCandSafety (ArrayList<Location> coordinates) {
		double costAdd = 0;
		for(int i=0;i<coordinates.size();i++) {
			Location current = coordinates.get(i);
			World world = current.getWorld();
			double x = current.getX();
			double y = current.getY();
			double z = current.getZ();
			Block upper = world.getBlockAt((int)x, (int)y+1, (int)z);
			Block lower = world.getBlockAt((int)x, (int)y - 1, (int)z);
			Block lowest = world.getBlockAt((int)x, (int)y - 2, (int) z);
			if(current.getBlock().getBlockData().getMaterial().isSolid()) {
				if(upper.getBlockData().getMaterial().isSolid()) {
					costAdd = costAdd + 1;
				}
			}
			if(lower.isEmpty()) {
				if(lowest.isEmpty() ) {
					costAdd = costAdd + 1;
				}
			}
			coordinates.remove(i);
			
		}
		return costAdd;
	}
}
