package pickquest.ai.pathfinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.ListIterator;

import org.bukkit.Location;

public class RandomPathing {
	private HashMap<Integer, Location> pathSequence = new HashMap<>(); 
	
	public HashMap<Integer, Location> getPathSequence() {
		return pathSequence;
	}

	public void setPathSequence(HashMap<Integer, Location> pathSequence) {
		this.pathSequence = pathSequence;
	}
	public void setsequencePath(Location origin, ArrayList<Location> points, Location destination) {
		sequencePath(origin, points, destination);
	}
	
	private HashMap<Integer, Location> sequencePath(Location origin, ArrayList<Location> points, Location destination) {
		Location current = origin;
		ArrayList<Location> processedPoints = new ArrayList<>();
		processedPoints.addAll(points);
		ListIterator<Location> pointsIterator = processedPoints.listIterator();
		Integer index = 0;
		Location loc = origin;
		int counter = 0;
		Collections.shuffle(processedPoints);
		while(pointsIterator.hasNext()) {
			loc=pointsIterator.next();
			if(!(pathSequence.isEmpty())) {
				current = pathSequence.get(pathSequence.size()-1);
			}
			else if(pathSequence.isEmpty()) {
				current= origin;
			}
			
			if(Math.abs(current.getX() - loc.getX()) > 0 && (Math.abs(current.getX() - loc.getX())) <= 1.3 && (Math.abs(current.getY() - loc.getY())) >= 0 && (Math.abs(current.getY() - loc.getY())) < 1 && (Math.abs(current.getZ() - loc.getZ())) >= 0 && (Math.abs(current.getZ() - loc.getZ())) < 1) { 
				pathSequence.put(index, loc);
				pointsIterator.remove();
				index++;
				
			}
			else if( ( (Math.abs(current.getY() - loc.getY())) > 0 && (Math.abs(current.getY() - loc.getY())) <= 1.3) && (Math.abs(current.getZ() - loc.getZ())) >= 0 && (Math.abs(current.getZ() - loc.getZ())) < 1 && (Math.abs(current.getX() - loc.getX())) >= 0 && (Math.abs(current.getX() - loc.getX())) < 1) {
				pathSequence.put(index, loc);
				pointsIterator.remove();
				index++;
				
			}
			else if(Math.abs(current.getZ() - loc.getZ()) > 0 && (Math.abs(current.getZ() - loc.getZ())) <= 1.3 && (Math.abs(current.getY() - loc.getY())) >= 0 && (Math.abs(current.getY() - loc.getY())) < 1 && (Math.abs(current.getX() - loc.getX())) >= 0 && (Math.abs(current.getX() - loc.getX())) < 1) {
				pathSequence.put(index, loc);
				pointsIterator.remove();
				index++;
				
			}
			if(!(pathSequence.isEmpty())) {
				current = pathSequence.get(pathSequence.size()-1);
			}
			
			if(!(pointsIterator.hasNext()) && !(processedPoints.isEmpty())) {
				
				System.out.println("reset fired");
				counter++;
				
				if(processedPoints.size() == 1) {
					pathSequence.put(index, loc);
				}
				if(pointsIterator.hasPrevious()) {
				int i = processedPoints.size() - 1;
						
						Collections.swap(processedPoints, (processedPoints.size() -1 ), i );
						if(!(pathSequence.isEmpty())) {
							current = pathSequence.get(pathSequence.size()-1);
						}
						while(pointsIterator.hasPrevious()) {
							pointsIterator.previous();
						}
					}
				}
			System.out.println(processedPoints);	

			if(counter > 250) {
				break;
				
			}
				}
		return pathSequence;
	}
}

	


