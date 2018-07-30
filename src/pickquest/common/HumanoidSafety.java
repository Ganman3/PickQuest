package pickquest.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.Location;
import org.bukkit.block.Block;

//Note: change to Enumsets later
enum unsafeUnder {
	AIR, CAVE_AIR, LEGACY_AIR, WATER, LONG_GRASS, OAK_SAPLING, 
	SPRUCE_SAPLING, BIRCH_SAPLING, JUNGLE_SAPLING, DARK_OAK_SAPLING,
	ACACIA_SAPLING, RED_MUSHROOM, BROWN_MUSHROOM, WHEAT, REEDS, 
	PUMPKIN_STEM, VINE, NETHER_WART, CARROTS, POTATOES, DANDELION, 
	POPPY, BLUE_ORCHID, ALLIUM, AZURE_BLUET, RED_TULIP, ORANGE_TULIP,
	WHITE_TULIP, PINK_TULIP, OXEYE_DAISY, SUNFLOWER, LILAC, RED_ROSE,
	YELLOW_FLOWER, CARPET, SNOW
	
}
enum safeAbove {
	AIR, CAVE_AIR, LEGACY_AIR, WATER, DOUBLE_PLANT
}
enum safeAt {
	AIR, CAVE_AIR, LEGACY_AIR, WATER, LONG_GRASS, OAK_SAPLING, 
	SPRUCE_SAPLING, BIRCH_SAPLING, JUNGLE_SAPLING, DARK_OAK_SAPLING,
	ACACIA_SAPLING, RED_MUSHROOM, BROWN_MUSHROOM, WHEAT, REEDS, 
	PUMPKIN_STEM, VINE, NETHER_WART, CARROTS, POTATOES, DANDELION, 
	POPPY, BLUE_ORCHID, ALLIUM, AZURE_BLUET, RED_TULIP, ORANGE_TULIP,
	WHITE_TULIP, PINK_TULIP, OXEYE_DAISY, SUNFLOWER, LILAC, RED_ROSE,
	YELLOW_FLOWER, CARPET, SNOW
}

public class HumanoidSafety {
	public List<String> iterateUnsafeUnder() {
		List<String> unsafeU = Stream.of(unsafeUnder.values()).map(Enum::name).collect(Collectors.toList());
		return unsafeU;
	}
	
	public List<String> iterateSafeAbove() {
		List<String> safeA = Stream.of(safeAbove.values()).map(Enum::name).collect(Collectors.toList());
		return safeA;
	}
	
	public List<String> iterateSafeAt() {
		List<String> safeT = Stream.of(safeAt.values()).map(Enum::name).collect(Collectors.toList());
		return safeT;
	}
	
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
			if(iterateUnsafeUnder().contains(material1)) {
			}
			else if(iterateSafeAbove().contains(material3)) {
							if(iterateSafeAt().contains(material2)) {
								safeList.add(new Location(loc.getWorld(),loc.getX(),loc.getY(),loc.getZ()));

							}
							else if(material2.contains("DOOR")) {
								safeList.add(new Location(loc.getWorld(),loc.getX(),loc.getY(),loc.getZ()));
						}
					
					}
			return safeList;
				}
		
	public void testSafe(Location loc) {
		this.testForSafeList(loc);
		return;
	}
	
}
