package pickquest.common;

import java.util.ArrayList;

import org.bukkit.Location;

public class ScanRadiusBlk {
	private ArrayList<Location> coordinateCandidates = new ArrayList<>();
	public ArrayList<Location> getCoordinateCandidates() {
		return coordinateCandidates;
	}
	public void addToCoordinates(Location loc) {
		coordinateCandidates.add(loc);
	}
	public ArrayList<Location> scanRadius(Location loc, int radius) {
		
		for(double x = loc.getX() - radius; x<= (loc.getX() +radius); x++) {
			for (double y = loc.getY() - 1; y<= (loc.getY() + 1); y++) {
				for (double z = loc.getZ() - radius; z<= (loc.getZ() + radius); z++) {
					addToCoordinates(new Location(loc.getWorld(), x, y, z));
					//System.out.println("Added coordinate: " + (new Location(loc.getWorld(), x, y, z)));
				}
			}
		}
		return coordinateCandidates;
	}
}
