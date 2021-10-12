package me.aly.heroes;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;

import superjump.superjump;

public class Main extends JavaPlugin implements CommandExecutor, Listener {

	public Inventory inv;
	
	@Override
	public void onEnable() {
		this.getCommand("superjump").setExecutor(new superjump());
		this.getServer().getPluginManager().registerEvents(this, this);
		createInv();
	}

	@Override
	public void onDisable() {
		
	}
	

	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("herogui") || label.equalsIgnoreCase("hgui")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Only players can run ths command");
				return true;
			}
			Player player = (Player) sender;
			player.openInventory(inv);
			return true;
				
				
		}
		return false;
	}
	
	@EventHandler()
	public void onClick(InventoryClickEvent event, Object inv) {
		if(!event.getInventory().equals(inv))
			return;
		if (event.getCurrentItem() == null) return;
		if (event.getCurrentItem().getItemMeta() == null) return;
		if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
		
		event.setCancelled(true);
		
		Player player = (Player) event.getWhoClicked();
		
		if (event.getSlot() == 0) {
			
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.BLUE);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You are now Super Steve!");
		}
		if (event.getSlot() == 8) {
			player.closeInventory();
		}
		return;
		
	}
	
	public ItemStack[] changeColor(ItemStack[] a, Color color) {
		for (ItemStack item : a) { 
			try {
				if (item.getType() == Material.LEATHER_BOOTS || item.getType() == Material.LEATHER_LEGGINGS ||
						item.getType() == Material.LEATHER_HELMET || item.getType() == Material.LEATHER_CHESTPLATE) {
					LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
					meta.setColor(color);
					item.setItemMeta(meta);

					}
			} catch (Exception e) {
		 		
		 	}
		}
		return a;
	}
	
	
	
	public void createInv() {
		inv = Bukkit.createInventory(null, 18, ChatColor.RED + "" + ChatColor.BOLD + "Choose the superhero");
		
		ItemStack item = new ItemStack(Material.WITHER_SKELETON_SKULL);
		ItemMeta meta = item.getItemMeta();
		
		// Super Steve
		meta.setDisplayName(ChatColor.RED + "Super Steve");
		List<String> lore =  new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Click to turn to hero!");
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(0, item);
		
		// Chicken Man
		meta.setDisplayName(ChatColor.RED + "Chicken Man");
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(1, item);
		
		// MR Flash
		meta.setDisplayName(ChatColor.RED + "MR Flash");
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(2, item);
		
		// Mermaid
		meta.setDisplayName(ChatColor.RED + "Mermaid");
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(3, item);
		
		// Hotty
		meta.setDisplayName(ChatColor.RED + "Hotty");
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(4, item);
		
		// Healer
		meta.setDisplayName(ChatColor.RED + "Healer");
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(5, item);
		
		// Water Walker
		meta.setDisplayName(ChatColor.RED + "Water Walker");
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(6, item);
		
		// MR Strider
		meta.setDisplayName(ChatColor.RED + "MR Strider");
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(7, item);
		
		// Close Button
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Close Menu");
		lore.clear();
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(8, item);
		
	}
	
}
	


