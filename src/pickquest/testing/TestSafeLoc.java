package pickquest.testing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import pickquest.ai.CustomNav;
import pickquest.ai.pathfinding.Heuristic;
import pickquest.ai.pathfinding.tool.EndPoint;
import pickquest.ai.pathfinding.tool.OriginPoint;


public class TestSafeLoc implements CommandExecutor {
	//For getting, setting, and using location points {
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
	//}
	
	public LinkedList<Location> bestValues = new LinkedList<Location>();
	/*Need to initialize at start of class so that it can be called and used in another class
	later on (scope reasons)*/
	public Heuristic bh = new Heuristic();
	
	
	public HashMap<UUID,Location> getOriginPoint = new HashMap<>();
	@EventHandler	
	@Override
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg3) {
		if(sender instanceof Player) {
		CustomNav cn = new CustomNav();
		Player p = (Player) sender;
		UUID pid = p.getUniqueId();
		//Check to make sure an origin point is set with tool
		if(OriginPoint.getDefinedOrigin(pid) == null) {
			p.sendMessage("Paths require an origin and a destination! Please set valid points.");
			return false;
		}
		//Check to make sure an end point is set with tool
		if(EndPoint.getDefinedEnd(pid) == null) {
			p.sendMessage("Paths require an origin and a destination! Please set valid points.");
			return false;
		}
		//Used for scope reasons - so that this can be modified and used in another classes
		setOrigin(OriginPoint.getDefinedOrigin(pid));
		setCurrent(getOrigin());
		setDestination(EndPoint.getDefinedEnd(pid));
		int ig = 0;
		do { 
			
			if(cn.getInt() == 0) {
				cn.findPath(origin, current, destination);
				
			}
			
			else if(cn.getInt() != 0 && !(getCurrent().equals(getDestination()))) {
				origin = cn.getCurrent();
				current = cn.getCurrent();
				destination = EndPoint.getDefinedEnd(pid);
				cn.findPath(origin, current, destination);
			}
			ig++;
			System.out.println(ig);
			
		} while(!(getCurrent().equals(destination)));
				}
		return true;
	}
}


	
