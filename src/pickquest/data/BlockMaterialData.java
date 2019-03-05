package pickquest.data;

import java.util.HashMap;

import org.bukkit.Location;
//import org.bukkit.block.Block;

public class BlockMaterialData {
	public HashMap<Location, String> getBlockHash(Location loc) {
		return blockHash;
	}
	private HashMap<Location, String> blockHash = new HashMap<>();
	public void setBlockMaterialData(Location loc) {
		if(blockHash.get(loc) == null || !(blockHash.containsKey(loc))|| blockHash.isEmpty()) {
			blockHash.put(loc, loc.getBlock().getType().toString());
		}
	}
}
