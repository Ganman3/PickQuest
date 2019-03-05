package pickquest.ai.pathfinding.tool;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import pickquest.data.SafeBlocks;



public class OriginPoint implements Listener {
	
	public static Location atLocation;
	
	private static HashMap<UUID, Location> definedOrigin = new HashMap<>();
	
	public UUID pid;
	
	//public Location getOriginPoint(UUID pid) {
		//return definedOrigin.get(pid);
	//}
	
	public static Location getDefinedOrigin(UUID pid) {
		return definedOrigin.get(pid);
	}
	
	
	
	@EventHandler
	public void createOriginPoint(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		UUID pid = player.getUniqueId();
		SafeBlocks sb = new SafeBlocks();
		EnumSet<Material> unsafeUnder = sb.getUnsafeUnder();
		EnumSet<Material> safeAt = sb.getSafeAt();
		EnumSet<Material> safeAbove = sb.getSafeAbove();
		String unsafeUnderString = unsafeUnder.toString();
		String safeAtString = safeAt.toString();
		String safeAboveString = safeAbove.toString();
		if(player.getGameMode() == GameMode.CREATIVE) {
			if(e.getHand().equals(EquipmentSlot.HAND) && player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getType().equals(Material.LIGHT_GRAY_DYE)) {
		if(e.getAction() == Action.LEFT_CLICK_BLOCK) {
			
			
				Location blockLocation = e.getClickedBlock().getLocation();
				Location atLocation = new Location(player.getWorld(),blockLocation.getX(),blockLocation.getY() + 1,blockLocation.getZ());
				Location upLocation = new Location(player.getWorld(),blockLocation.getX(),blockLocation.getY() + 2,blockLocation.getZ());
				String blockMaterial = e.getClickedBlock().getLocation().getBlock().getType().toString();
				String atLocationBlock = atLocation.getBlock().getType().toString();
				String upLocationBlock = upLocation.getBlock().getType().toString();
				//System.out.println(blockMaterial + " " + blockLocation + " " + atLocation + " " + atLocationBlock + " " + upLocation + " " + upLocationBlock);
				if(unsafeUnderString.contains(blockMaterial)) {
					player.sendMessage("That block is unsafe for humanoid mobs!");
					
				}
				else if(safeAtString.contains(atLocationBlock)) {
					if(safeAboveString.contains(upLocationBlock)) {
						definedOrigin.put(pid, atLocation);
						player.sendMessage("Path origin set!");
						//System.out.println(getDefinedOrigin(pid));
					}
					
				}
				else {
					e.setCancelled(true);
					player.sendMessage("That block is unsafe for humanoid mobs!");
				}
				e.setCancelled(true);
				
				
			}
			
	}
}
		
		}
}
