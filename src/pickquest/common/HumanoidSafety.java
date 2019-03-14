package pickquest.common;

import java.util.ArrayList;
import java.util.EnumSet;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import pickquest.data.SafeBlocks;

//Note: change to Enumsets later

public class HumanoidSafety {
	SafeBlocks sb = new SafeBlocks();
	EnumSet<Material> unsafeUnder = sb.getUnsafeUnder();
	EnumSet<Material> safeAt = sb.getSafeAt();
	EnumSet<Material> safeAbove = sb.getSafeAbove();
	String unsafeUnderString = unsafeUnder.toString();
	String safeAtString = safeAt.toString();
	String safeAboveString = safeAbove.toString();
	/*public List<String> iterateUnsafeUnder() {
		List<String> unsafeU = Stream.of(unsafeUnder.values()).map(Enum::name).collect(Collectors.toList());
		return unsafeU;
	}
	
	/*public List<String> iterateSafeAbove() {
		List<String> safeA = Stream.of(safeAbove.values()).map(Enum::name).collect(Collectors.toList());
		return safeA;
	}
	
	public List<String> iterateSafeAt() {
		List<String> safeT = Stream.of(safeAt.values()).map(Enum::name).collect(Collectors.toList());
		return safeT;*/
	//}
	
	private ArrayList<Location> safeLocation = new ArrayList<>();
	
	public ArrayList<Location> getsafe() {
		return safeLocation;
	}
	boolean isSafe = false;
	
	private ArrayList<Location> safeList = new ArrayList<>();
	public ArrayList<Location> getSafeList() {
		return safeList;
	}
	private ArrayList<Location> testForSafeList(Location loc) {
		Location locunder = new Location(loc.getWorld(),loc.getX(),loc.getY()-1,loc.getZ());
		Location locat = new Location(loc.getWorld(),loc.getX(),loc.getY(),loc.getZ());
		Location locabove = new Location(loc.getWorld(),loc.getX(),loc.getY()+1,loc.getZ());
		Block under = locunder.getBlock();
		Block at = locat.getBlock();
		Block above = locabove.getBlock();
		String material1 = under.getBlockData().getMaterial().toString();
		String material3 = above.getBlockData().getMaterial().toString();
		String material2 = at.getBlockData().getMaterial().toString();
		//System.out.println(unsafeUnderString.contains(material1));
		//System.out.println(safeAboveString.contains(material2));
		
			if(unsafeUnderString.contains(material1)) {
				return safeList;
			}
			else if(safeAboveString.contains(material3)) {
							if(safeAtString.contains(material2)) {
								safeList.add(new Location(loc.getWorld(),loc.getX(),loc.getY(),loc.getZ()));
								//System.out.println("Block is safe!" + " Block under point: " + material1 + " Lower block: " + material2 + " Higher block: " + material3 + locunder + locat + locabove);
								isSafe = true;
							}
							
						}
			if(material3.contains("DOOR") && (material2.contains("DOOR") && !(unsafeUnderString.contains(material1)))) {
				safeList.add(new Location(loc.getWorld(),loc.getX(),loc.getY(),loc.getZ()));
				isSafe=true;
<<<<<<< HEAD
				//System.out.println(material1 + " " + material2 + " " + material3 + " " + locat + locabove);
=======
				System.out.println(material1 + " " + material2 + " " + material3 + " " + locat + locabove);
>>>>>>> 8b1463c3ebe4ed85bfddd2e4fbcb6bbd088619aa
					}
			
			
			return safeList;
				}
		
	public void testSafe(Location loc) {
		this.testForSafeList(loc);
		return;
	}
	
}
