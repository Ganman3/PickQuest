package pickquest.ai;

import java.util.ArrayList;
import java.util.LinkedList;

import org.bukkit.Location;
//import org.bukkit.Material;
import org.bukkit.Material;

import pickquest.ai.pathfinding.Heuristic;
import pickquest.common.HumanoidSafety;
import pickquest.common.operations.ScanRadiusBlk;
import pickquest.data.BlockMaterialData;
import pickquest.testing.TestSafeLoc;

public class CustomNav {
	
	private int i1 = 0;
	public int getInt() {
		return i1;
	}
	public void setInt(int i1) {
		this.i1 = i1;
	}
	
	private Location current;
	
	public Location getCurrent() {
		return current;
	}
	
	public void setCurrent(Location current) {
		this.current= current;
	}
	public LinkedList<Location> path = new LinkedList<Location>();
	
	public void findPath(Location origin, Location current, Location dest) {
		this.current = current;
		TestSafeLoc ts = new TestSafeLoc();
		
		
		setInt(0);
		
		//System.out.println("current at start " + current);
		//System.out.println("Hello, we're trying again");
		BlockMaterialData bm = new BlockMaterialData();
		
		ScanRadiusBlk sra = new ScanRadiusBlk();
		ArrayList<Location> srd = sra.getCoordinateCandidates();
		HumanoidSafety hs = new HumanoidSafety();
		ArrayList<Location> sl = hs.getSafeList();
		
		
		
		//Is this necessary?
		Heuristic bh = new Heuristic();
		
		//THIS is your problem
		while((getInt() < bh.findHeuristic(origin, current, dest)) && !(current.equals(dest))) {
			ts.setCurrent(this.current);
			//System.out.println("Testsafe current" + ts.getCurrent());
			
			//System.out.println("This current:" + getCurrent());
			//System.out.println("Is this condition true? " + (getInt() < bh.findHeuristic(origin, current, dest)));
			//System.out.println(bh.findHeuristic(origin, current, dest));
			//System.out.println(getInt());
			//System.out.println(getCurrent());
			sra.scanRadius(current,1);
			for(int i = 0; i<srd.size(); i++) {
				hs.testSafe(srd.get(i));
				if(srd.get(i).equals(current)) {
					srd.remove(i);
					sl.remove(current);
					//System.out.println("Heyo");
				}
		}
			for(int i = 0;i<sl.size();i++) {
				bh.findHeuristic(current, sl.get(i), dest);
			}
			
			sl.clear();
			srd.clear();
			LinkedList<Location> bestValues = bh.returnBestValues();
			
			int currentHeuristicIndex = bestValues.size() - 1;
			current = bestValues.get(currentHeuristicIndex);
			setCurrent(current);
			path.add(current);
			
			//System.out.println("current at end: " + current);
			//ts.setCurrent(bestValues.getLast());	
			setInt(getInt() + 1);
			//setCurrent(this.current);
			
			//System.out.println("1" + current);
			
			//System.out.println(getInt());
			if(current.equals(dest)) {
				for(int i=0;i<path.size();i++) {
					path.get(i).getBlock().setType(Material.GLOWSTONE);
				}
				//for(int i=0;i<bestValues.size();i++) {
					//bestValues.get(i).getBlock().setType(Material.GLOWSTONE);
					//ts.bestValues.add(bestValues.get(i));
					//System.out.println(origin.getBlock().getLightFromSky());
					
				//}
			}
			
			//else if(!(current.equals(dest))) {
				
			//if(getInt() > (bh.findHeuristic(origin,origin,dest) * 2)) {
				//System.out.println(getInt());
				//if(Math.abs(dest.getX()-origin.getX()) < 2*Math.abs(dest.getX()-current.getX())) {
					
					
					//origin = bestValues.getLast();
					//System.out.println("x problem: origin: " + origin + ", current: " + current);
					//break;
					//findPath(origin, current, dest);
				//}
				//if(Math.abs(dest.getY()-origin.getY()) < 2*Math.abs(current.getY()-dest.getY())) {
					//p.sendMessage("Sorry! Path could not be safely calculated!\nIt's either out of range, or our algorithm's not refined.");
					
					//origin = bestValues.getLast();
					//System.out.println("y problem: origin: " + origin + ", current: " + current);
					
				//}
				//if(Math.abs(dest.getZ()-origin.getZ()) < 2*Math.abs(current.getZ() - dest.getZ())) {
					
					
					//origin = bestValues.getLast();
					//System.out.println("z problem: origin: " + origin + ", current: " + current);
					
				//}
			}
		
			//}
			
			//i1++;
		
	
		
	
	
//}*/
	//}
		for(Location loc: sl) {
			bm.setBlockMaterialData(loc);
			
		}
		
	}
}

//}
//}
