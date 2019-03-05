package pickquest.common;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;


public class TestingAlert implements CommandExecutor {
	@EventHandler	
	@Override
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg3) {
		if(sender instanceof Player) {
			for(Player p : Bukkit.getServer().getOnlinePlayers()) {
			p.sendMessage("We are currently testing!\nServer restarts may be frequent and play may be difficult.\nThank you for your patience.");
		
			}
			}
		return true;
}
}
