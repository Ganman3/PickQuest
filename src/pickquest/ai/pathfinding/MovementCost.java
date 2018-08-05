package pickquest.ai.pathfinding;

import org.bukkit.Location;
import org.bukkit.Material;

public class MovementCost {
	public double getCalculatedCost(Location current, Location candidate, Location destination) {
		return calculateCost(current, candidate, destination);
	}
	
	public Location under;
	
	private double calculateCost(Location current, Location candidate, Location destination) {
		under = new Location(candidate.getWorld(),candidate.getX(),candidate.getY()-1,candidate.getZ());
		Material underBlock = under.getBlock().getType();
		double g=1;
		if((current.getY() - candidate.getY()) > 0 && (current.getY() <= destination.getY())) {
			g = g+0.5;
		}
		else if((current.getY() - candidate.getY()) < 0 && (current.getY() >= destination.getY())) {
			g = g+0.5;
		}
		if((current.getX() - candidate.getX() != 0) && (current.getZ() - candidate.getZ() != 0)) {
			g= g+1;
		}
		if(underBlock.equals(Material.STONE_BRICKS) || underBlock.equals(Material.POLISHED_ANDESITE) || underBlock.equals(Material.COBBLESTONE_STAIRS) || underBlock.equals(Material.DEAD_BUBBLE_CORAL_BLOCK)|| underBlock.equals(Material.GRAVEL)) {
			g = g-1.5;
		}
		return g;
	}
}
