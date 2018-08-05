package pickquest.testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import pickquest.ai.pathfinding.Heuristic;
import pickquest.ai.pathfinding.tool.EndPoint;
import pickquest.ai.pathfinding.tool.OriginPoint;
import pickquest.common.HumanoidSafety;
import pickquest.common.operations.ScanRadiusBlk;
import pickquest.data.BlockMaterialData;

public class TestSafeLoc implements CommandExecutor {
	public HashMap<UUID,Location> getOriginPoint = new HashMap<>();
	@EventHandler	
	@Override
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg3) {
		if(sender instanceof Player) {
		int i1 = 0;
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
			else {
			Location origin = OriginPoint.getDefinedOrigin(pid);
			Location current = origin;
			Location destination = EndPoint.getDefinedEnd(pid);
			System.out.println(origin.getBlock() + " " + origin);
			System.out.println(current.getBlock() + " " + current);
			System.out.println(destination.getBlock() + " " + destination);
			double predictedDistanceX = Math.sqrt(Math.pow(Math.abs(current.getX() - destination.getX()), 2.0));
			double predictedDistanceY = Math.sqrt(Math.pow(Math.abs(current.getY() - destination.getY()), 2.0));
			double predictedDistanceZ = Math.sqrt(Math.pow(Math.abs(current.getZ() - destination.getZ()), 2.0));
			double predictedHeuristic = predictedDistanceX + predictedDistanceY + predictedDistanceZ;
			//The current testing point where path should move
			//Initialise radius class
			ScanRadiusBlk sra = new ScanRadiusBlk();
			//Initialise array in which to put locations in radius
			ArrayList<Location> srd = sra.getCoordinateCandidates();
			//Initialise class to test whether location is safe for human entrance
			HumanoidSafety hs = new HumanoidSafety();
			//Arraylist in which to put locations in radius that are safe
			ArrayList<Location> sl = hs.getSafeList();
			//Initialise class from which heuristics are first calculated (possible testing)
			Heuristic bh = new Heuristic();
			//As long as the current location isn't the end location
			while(!(current.equals(destination))) {
			//Do I need two maps to store heuristics? Trying to remember	
			//---Map<Double, Location> heuristic = bh.getHeuristicValues();
				//Initialise operation to grab blocks in radius around current location, 1 radius
				sra.scanRadius(current,1);
				for(int i=0;i<srd.size();i++) {
					//System.out.println("current value: " + i + "current loop: " + i1 + "  " + srd.get(i));
				}
				//For each block put in the radius arraylist
				for(int i2 = 0; i2<srd.size(); i2++) {
					
					hs.testSafe(srd.get(i2));
					if(srd.get(i2).equals(current)) {
						srd.remove(i2);
						
						sl.remove(current);
					}
			}
				System.out.println("destination: " + destination);
				System.out.println(i1 + " current: " + current);
				for(int i=0;i<sl.size();i++) {
					System.out.println(i + ": " + sl.get(i));
				}
				
				
				for(int i = 0;i<sl.size();i++) {
					bh.findHeuristic(current, sl.get(i), destination);
					
					//System.out.println(heuristic);
				}
				
				sl.clear();
				srd.clear();
				LinkedList<Location> bestValues = bh.returnBestValues();
				int currentHeuristicIndex = bestValues.size() - 1;
				System.out.println("Best value in queue: " + bestValues.get(bestValues.size()-1));
				System.out.println("All values: " + bestValues);
				current = bestValues.get(currentHeuristicIndex);
				
				
				i1++;
				if(i1 > (predictedHeuristic * 2)) {
					p.sendMessage("Sorry! Path could not be safely calculated!\nIt's either out of range, or our algorithm's not refined.");
					return false;
				}
				if(current.equals(destination)) {
					for(int i=0;i<bestValues.size();i++) {
						bestValues.get(i).getBlock().setType(Material.GLOWSTONE);
					}
				}
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
			BlockMaterialData bm = new BlockMaterialData();
			//HumanoidSafety hs = new HumanoidSafety();
			//ArrayList<Location> sl = hs.getSafeList();
			/*for(int i = 0; i<srd.size(); i++) {
				hs.testSafe(srd.get(i));
				if(i==(srd.size()-1)) {*/
					
					//sl.remove(origin);
					for(Location loc: sl) {
						//if(bm.getBlockHash(loc).isEmpty()) {
							bm.setBlockMaterialData(loc);
							//System.out.println(bm.getBlockHash(loc).get(loc).toString());
							
					}
				}
			p.sendMessage("Path calculated successfully!\nNumber of steps: " + i1);
						//}
						/*Path path = new Path();
						HashMap<Integer, Location> sp = path.getPathSequence();
						path.setsequencePath(origin, sl, origin);
						System.out.println(sp);
				}*/
				
			//}
			
			}
	
			
		

		return true;
	}
}


	
