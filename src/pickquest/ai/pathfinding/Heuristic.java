package pickquest.ai.pathfinding;
//import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
import java.util.LinkedList;
//import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.bukkit.Location;

//import pickquest.common.HumanoidSafety;

public class Heuristic {
	private Double distx;
	private Double disty;
	private Double distz;
	private Double f;
	private Double g;
	private Double h;
	public Double getf() {
		return f;
	}
	public Double getg() {//Give this its own class later
		return g;
	}
	public Double geth() {
		return h;
	}
	public Double getDistx() {
		return distx;
	}
	public Double getDisty() {
		return disty;
	}
	public Double getDistz() {
		return distz;
	}
	
	public LinkedList<Location> bestValues = new LinkedList<>();
	
	public SortedMap<Double,Location> heuristicValues = new TreeMap<>();
	
	public Map<Double,Location> getHeuristicValues() {
		return heuristicValues;
	}
	public LinkedList<Location> getbestValues() {
		return bestValues;
	}
	
	public double initPathCount() {
		return getbestValues().size();
	}
	public double findHeuristic(Location current, Location candidate, Location destination) {
		//System.out.println("Hello");
		//Get g cost later- right now, just use 1 for everything
		//System.out.println(candidate);
		
		MovementCost mc = new MovementCost();
		g = mc.getCalculatedCost(current, candidate, destination);
		distx = Math.sqrt(Math.pow(Math.abs(candidate.getX() - destination.getX()), 2.0));
		disty = Math.sqrt(Math.pow(Math.abs(candidate.getY() - destination.getY()), 2.0));
		distz = Math.sqrt(Math.pow(Math.abs(candidate.getZ() - destination.getZ()), 2.0));
		h = distx + disty + distz;
		if(bestValues.contains(candidate)) { 
			g=g+5;
		}
		f = g + h;
		//System.out.println(f + ", " + candidate);
		heuristicValues.put(f, candidate);
		//System.out.println(f + " " + "candidate: " + candidate + "current: " + current);
		//System.out.println(heuristicValues);
		//System.out.println("Estimated cost: " + f + "Candidate: " + candidate);
		return f;
	}
	
	
	public LinkedList<Location> returnBestValues() {
		//System.out.println(heuristicValues.firstKey());
		Double bestValue = heuristicValues.firstKey();
		Location bestLocation = heuristicValues.get(bestValue);
		bestValues.add(bestLocation);
		//ts.add(bestLocation);
		//System.out.println("Best values: " + bestValues);
		heuristicValues.clear();
		return bestValues;
	}
			
	
}

