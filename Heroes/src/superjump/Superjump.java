package superjump;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class superjump implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("superjump") || label.equalsIgnoreCase("launch")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (player.hasPermission("hero.jump")) {
					if (args.length == 0) {
						player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD +"Boom!");
						player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));
						return true;
					}
					if (isNum(args[0])) {
						player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD +"Boom!");
						player.setVelocity(player.getLocation().getDirection().multiply(Integer.parseInt(args[0])).setY(2));
						return true;
					}
					else player.sendMessage(ChatColor.RED + "Please use a number");
				}
				else {
					player.sendMessage(ChatColor.RED + "You don't have permission to use this");
					return true;
				}
				

			}
			else {
				sender.sendMessage("hi console, lame");
			}
		}
		
		return false;
	}
	
	public boolean isNum(String num) {
		try {
			Integer.parseInt(num);
				
			}catch (Exception e) {
				return false;
			}
			return true;
	}

}
