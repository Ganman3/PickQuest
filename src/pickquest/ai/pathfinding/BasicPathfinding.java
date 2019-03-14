package pickquest.ai.pathfinding;

import java.util.ArrayList;

import org.bukkit.Location;

import pickquest.common.operations.ScanRadiusBlk;

public class BasicPathfinding {
	private boolean executed;
	
	private Location current;
	
	public void getBasicPathFinding(Location origin, Location finalpoint) {
		findBasicPathfinding(origin,finalpoint);
		return;
	}
	
	private void findBasicPathfinding(Location origin, Location finalpoint) {
		if(!executed) {
			origin = current;
		}
		while(!origin.equals(finalpoint)) {
			ScanRadiusBlk sra = new ScanRadiusBlk();
			ArrayList<Location> srd = sra.getCoordinateCandidates();
			sra.scanRadius(current,1);
			for(int i1 = 0; i1<srd.size(); i1++) {
				if(srd.get(i1).equals(origin)) {
					srd.remove(i1);
				}
			}
			
		}
	}
}
