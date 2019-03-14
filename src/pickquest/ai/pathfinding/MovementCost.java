package pickquest.ai.pathfinding;


import java.util.ArrayList;

import org.bukkit.Location;

import pickquest.common.operations.ScanRadiusBlk;



public class MovementCost {
	public double getCalculatedCost(Location current, Location candidate, Location destination) {
		return calculateCost(current, candidate, destination);
	}
	
	public Location under;
	
	private double calculateCost(Location current, Location candidate, Location destination) {

		
		ScanRadiusBlk sr =  new ScanRadiusBlk();
		ObstacleFinding os = new ObstacleFinding();
		under = new Location(candidate.getWorld(),candidate.getX(),candidate.getY()-1,candidate.getZ());
		//Material underBlock = under.getBlock().getType();
		double g=1;
		if((current.getY() - candidate.getY()) > 0 && (current.getY() <= destination.getY())) {
			g = g+1;
		}
		if((current.getY() - candidate.getY()) < 0) {
			g = g+0.5;
		}
		else if((current.getY() - candidate.getY()) < 0 && (current.getY() >= destination.getY())) {
			g = g+1;
		}
		if((current.getX() - candidate.getX() != 0) && (current.getZ() - candidate.getZ() != 0)) {
			g=g-0.5;
			if(current.getY() - candidate.getY() != 0) {
				g=g+5;
			}
		}
		
		//if(underBlock.equals(Material.STONE_BRICKS) || underBlock.equals(Material.POLISHED_ANDESITE) || underBlock.equals(Material.COBBLESTONE_STAIRS) || underBlock.equals(Material.DEAD_BUBBLE_CORAL_BLOCK)|| underBlock.equals(Material.GRAVEL)) {
			//g = g-0.5;
	//	}
		
		//ArrayList<Location> srd = sr.getCoordinateCandidates();
		ArrayList<Location> futuresrd = sr.scanRadius(candidate, 1);
		g = g + os.calculateCandSafety(futuresrd);
			
			
			//double candX = srd.get(i).getX();
			//double candZ = srd.get(i).getZ();
			//double candY = srd.get(i).getY();
			//if(candidate.getWorld().getHighestBlockYAt((int)candX, (int)candZ) - candY >= 2) {
				//g= g+3;
			//}
			//if(candidate.getWorld().getHighestBlockYAt((int)candX, (int)candZ) - candY < 2) {
				//g=g+3;
			//}
					
		
		return g;
	}




		
}

