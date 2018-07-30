package pickquest.testing;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.HashMap;

import org.bukkit.Location;
//import org.bukkit.Material;
//import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;

import pickquest.common.HumanoidSafety;
import pickquest.common.Path;
import pickquest.common.ScanRadiusBlk;
import pickquest.data.BlockMaterialData;

public class TestSafeLoc implements CommandExecutor {
	@EventHandler
		
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg3) {
		if(sender instanceof Player) {
		
			Player p = (Player) sender;
			Location origin = new Location(p.getWorld(),p.getLocation().getX(),p.getLocation().getY(),p.getLocation().getZ());
			//Location current = origin;
			ScanRadiusBlk sra = new ScanRadiusBlk();
			ArrayList<Location> srd = sra.getCoordinateCandidates();
			sra.scanRadius(p.getLocation(),2);
			for(int i1 = 0; i1<srd.size(); i1++) {
				if(srd.get(i1).equals(origin)) {
					srd.remove(i1);
				}
			}
			BlockMaterialData bm = new BlockMaterialData();
			HumanoidSafety hs = new HumanoidSafety();
			ArrayList<Location> sl = hs.getSafeList();
			for(int i = 0; i<srd.size(); i++) {
				hs.testSafe(srd.get(i));
				if(i==(srd.size()-1)) {
					
					sl.remove(origin);
					for(Location loc: sl) {
						//if(bm.getBlockHash(loc).isEmpty()) {
							bm.setBlockMaterialData(loc);
							System.out.println(bm.getBlockHash(loc).get(loc).toString());
							
					}
				}
						//}
						Path path = new Path();
						HashMap<Integer, Location> sp = path.getPathSequence();
						path.setsequencePath(origin, sl, origin);
						System.out.println(sp);
				}
				
			}
			
		
	
		return true;
		}
	}


	
