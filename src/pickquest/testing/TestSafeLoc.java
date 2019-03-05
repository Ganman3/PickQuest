package pickquest.testing;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
//import java.util.LinkedList;
import java.util.UUID;
import org.bukkit.Location;
//import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

import pickquest.ai.CustomNav;
import pickquest.ai.pathfinding.Heuristic;
//import pickquest.ai.pathfinding.Heuristic;
import pickquest.ai.pathfinding.tool.EndPoint;
import pickquest.ai.pathfinding.tool.OriginPoint;
//import pickquest.common.HumanoidSafety;
//import pickquest.common.operations.ScanRadiusBlk;
//import pickquest.data.BlockMaterialData;

public class TestSafeLoc implements CommandExecutor {
	public LinkedList<Location> bestValues = new LinkedList<Location>();
	public Heuristic bh = new Heuristic();
	private Location origin;
	public Location getOrigin() {
		return origin;
	}
	public void setOrigin(Location origin) {
		this.origin = origin;
	}
	public Location getCurrent() {
		return current;
	}
	public void setCurrent(Location current) {
		this.current = current;
	}
	public Location getDestination() {
		return destination;
	}
	public void setDestination(Location destination) {
		this.destination = destination;
	}
	private Location current;
	private Location destination;
	
	public HashMap<UUID,Location> getOriginPoint = new HashMap<>();
	@EventHandler	
	@Override
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg3) {
		if(sender instanceof Player) {
		//int i1 = 0;
		//LinkedList<Location> bestValues = new LinkedList<Location>();
		CustomNav cn = new CustomNav();
		Player p = (Player) sender;
		UUID pid = p.getUniqueId();
		if(OriginPoint.getDefinedOrigin(pid) == null) {
			p.sendMessage("Paths require an origin and a destination! Please set valid points.");
			return false;
		}
		if(EndPoint.getDefinedEnd(pid) == null) {
			p.sendMessage("Paths require an origin and a destination! Please set valid points.");
			return false;
		}
		setOrigin(OriginPoint.getDefinedOrigin(pid));
		setCurrent(getOrigin());
		setDestination(EndPoint.getDefinedEnd(pid));
		int ig = 0;
		//System.out.println(getCurrent());
		//System.out.println(getDestination());
		//System.out.println(getOrigin());
		//System.out.println(cn.getInt());
		do { 
			
			if(cn.getInt() == 0) {
				//System.out.println("Hello");
				
				//System.out.println("Hello");
				cn.findPath(origin, current, destination);
				//System.out.println("current location: " + getCurrent());
			}
			
			else if(cn.getInt() != 0 && !(getCurrent().equals(getDestination()))) {
				//System.out.println(cn.getCurrent());
				//System.out.println(getDestination());
				//System.out.println("balls");
				//System.out.println(cn.getCurrent());
				origin = cn.getCurrent();
				current = cn.getCurrent();
				//System.out.println(current);
				destination = EndPoint.getDefinedEnd(pid);
				cn.findPath(origin, current, destination);
			}
			ig++;
			//System.out.println(cn.getCurrent());
			//System.out.println(getDestination());
			//System.out.println(cn.getInt());
			System.out.println(ig);
			
		} while(!(getCurrent().equals(destination)));
		//System.out.println(cn.getCurrent());
		//System.out.println(getDestination());
		//System.out.println(getOrigin());
			//while(cn.getInt() == 0) {
				
				//origin = OriginPoint.getDefinedOrigin(pid);
				//current = origin;
				//destination = EndPoint.getDefinedEnd(pid);
				//if(!(current.equals(destination))) {
				//System.out.println("Hello");
				//cn.findPath(origin,current,destination);
				//}
			//}
			
			//while(cn.getInt() != 0 && !(current.equals(destination))) {
				
				//System.out.println("Goodbye");
				//LinkedList<Location> bestValues = bh.returnBestValues();
				//if(!(current.equals(destination))) {
				//origin = bh.returnBestValues().getLast();
				//current = bh.returnBestValues().getLast();
				//destination = EndPoint.getDefinedEnd(pid);
				//cn.findPath(origin, current, destination);
			//}
			
			//Heuristic bh = new Heuristic();
			//cn.findPath(origin, current, destination);
			
			
			//double oldDistx = bh.getDistx();
			//double oldDisty = bh.getDisty();
			//double oldDistz = bh.getDistz();
			//LinkedList<Location> bestValues = bh.returnBestValues();
			
			
			//else {
				//This is where you'll import your method - take these as initial parameters 
			//System.out.println(p.getLocation().getBlock().getBlockData().getMaterial().toString());
			
			//System.out.println(origin.getBlock() + " " + origin);
			//System.out.println(current.getBlock() + " " + current);
			//System.out.println(destination.getBlock() + " " + destination);
			//This can be condensed to a method 
			//Heuristic hr = new Heuristic();
			
			//double predictedDistanceX = Math.sqrt(Math.pow(Math.abs(current.getX() - destination.getX()), 2.0));
			//double predictedDistanceY = Math.sqrt(Math.pow(Math.abs(current.getY() - destination.getY()), 2.0));
			//double predictedDistanceZ = Math.sqrt(Math.pow(Math.abs(current.getZ() - destination.getZ()), 2.0));
			//double predictedHeuristic = predictedDistanceX + predictedDistanceY + predictedDistanceZ;
			
			//The current testing point where path should move
			//Initialise radius class
			//ScanRadiusBlk sra = new ScanRadiusBlk();
			//Initialise array in which to put locations in radius
			//ArrayList<Location> srd = sra.getCoordinateCandidates();
			//Initialise class to test whether location is safe for human entrance
			//HumanoidSafety hs = new HumanoidSafety();
			//Arraylist in which to put locations in radius that are safe
			//ArrayList<Location> sl = hs.getSafeList();
			//Initialise class from which heuristics are first calculated (possible testing)
			
			
			//As long as the current location isn't the end location
			//while(!(current.equals(destination))) {
			//Do I need two maps to store heuristics? Trying to remember	
			//---Map<Double, Location> heuristic = bh.getHeuristicValues();
				//Initialise operation to grab blocks in radius around current location, 1 radius
				//sra.scanRadius(current,1);
				//for(int i=0;i<srd.size();i++) {
					//System.out.println("current value: " + i + "current loop: " + i1 + "  " + srd.get(i));
				//}
				//For each block put in the radius arraylist
				//for(int i2 = 0; i2<srd.size(); i2++) {
					//hs.testSafe(srd.get(i2));
					//if(srd.get(i2).equals(current)) {
						//srd.remove(i2);
						
						//sl.remove(current);
					//}
			//}
				//System.out.println("destination: " + destination);
				//System.out.println(i1 + " current: " + current);
				//for(int i=0;i<sl.size();i++) {
					//System.out.println(i + ": " + sl.get(i));
				//}
				
				
				//for(int i = 0;i<sl.size();i++) {
					//bh.findHeuristic(current, sl.get(i), destination);
					
					//System.out.println(heuristic);
				//}
				
				//sl.clear();
				//srd.clear();
				
				//int currentHeuristicIndex = bestValues.size() - 1;
				//System.out.println("Best value in queue: " + bestValues.get(bestValues.size()-1));
				//System.out.println("All values: " + bestValues);
				//current = bestValues.get(currentHeuristicIndex);
				//System.out.println(current.getX() + " " + current.getZ() + " ");
				
				//i1++;
				//if(current.equals(destination)) {
					//for(int i=0;i<bestValues.size();i++) {
						//bestValues.get(i).getBlock().setType(Material.GLOWSTONE);
						//System.out.println(origin.getBlock().getLightFromSky());
					//}
				//}
				//else if(i1 > (bh.findHeuristic(origin,origin,destination) * 2)) {
					//while(oldDistx < 2*Math.abs(current.getX()-destination.getX())) {
						//p.sendMessage("Sorry! Path could not be safely calculated!\nIt's either out of range, or our algorithm's not refined.");
						//current = bestValues.getLast();
						//cn.findPath(origin, current, destination);
					//}
					//while(oldDisty < 2*Math.abs(current.getY()-destination.getY())) {
						//p.sendMessage("Sorry! Path could not be safely calculated!\nIt's either out of range, or our algorithm's not refined.");
						//current = bestValues.getLast();
						//cn.findPath(origin, current, destination);
					//}
					//while(oldDistz < 2*Math.abs(current.getZ() - destination.getZ())) {
						//p.sendMessage("Sorry! Path could not be safely calculated!\nIt's either out of range, or our algorithm's not refined.");
						//current = bestValues.getLast();
						//cn.findPath(origin, current, destination);
					//for(int i=0;i<bestValues.size();i++) {
						//bestValues.get(i).getBlock().setType(Material.GLOWSTONE);
					//}
					
					
					
					//return false;
				}
				
			
			
				//System.out.println(0);
				//System.out.println(current);
				//System.out.println(destination);*/
				
				/*for(int i = 0; i<srd.size(); i++) {
					hs.testSafe(srd.get(i));
					if(i==(srd.size()-1)) {
						
						sl.remove(origin);
					}*/
			//ScanRadiusBlk sra = new ScanRadiusBlk();
			//ArrayList<Location> srd = sra.getCoordinateCandidates();
			//sra.scanRadius(current,1);
			//for(int i1 = 0; i1<srd.size(); i1++) {
				//if(srd.get(i1).equals(origin)) {
					//srd.remove(i1);
				//}
			//}
			
			//HumanoidSafety hs = new HumanoidSafety();
			//ArrayList<Location> sl = hs.getSafeList();
			/*for(int i = 0; i<srd.size(); i++) {
				hs.testSafe(srd.get(i));
				if(i==(srd.size()-1)) {*/
					
					//sl.remove(origin);
					
						//if(bm.getBlockHash(loc).isEmpty()) {
							
							//System.out.println(bm.getBlockHash(loc).get(loc).toString());
							
					
				//}
			//p.sendMessage("Path calculated successfully!\nNumber of steps: " + i1);
						//}
						/*Path path = new Path();
						HashMap<Integer, Location> sp = path.getPathSequence();
						path.setsequencePath(origin, sl, origin);
						System.out.println(sp);
				}*/
				
			//}
			
			//}
	
			
		

	//}
		return true;
	}
}


	
