package pickquest.common;

import java.util.ArrayList;

import org.bukkit.Location;

public class WaitingLocations {
	private static ArrayList<Location> waitingLocations = new ArrayList<>();
	public static ArrayList<Location> getwaiting() {
		return waitingLocations;
	}
	
}
