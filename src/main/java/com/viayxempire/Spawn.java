package com.viayxempire;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Spawn implements CommandExecutor {

    public float sYaw;
    public float sPitch;
    public double sX;
    public double sY;
    public double sZ;
    public String sWorld;

    Plugin p;
    public Spawn(Plugin pl) {
        p = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (p.getConfig().getString("Spawn.SpawnCommand").equals("true")) {
                // Dil kontrolü
                String prefix = ChatColor.translateAlternateColorCodes('&', p.getConfig().getString("Settings.Prefix"));
                String spawnMessage;
                if (p.getConfig().getString("Settings.Language").equals("tr")) {
                    spawnMessage = Main.getMessages().getString("tr.spawn");
                } else if (p.getConfig().getString("Settings.Language").equals("en")) {
                    spawnMessage = Main.getMessages().getString("en.spawn");
                } else {
                    spawnMessage = "Spawn noktası ayarlanmış.";
                }
                spawnMessage = ChatColor.translateAlternateColorCodes('&', spawnMessage);

                // Dünya ve konum ayarları
                sYaw = p.getConfig().getInt("Spawn.Yaw");
                sPitch = p.getConfig().getInt("Spawn.Pitch");
                sX = p.getConfig().getDouble("Spawn.X");
                sY = p.getConfig().getDouble("Spawn.Y");
                sZ = p.getConfig().getDouble("Spawn.Z");
                sWorld = p.getConfig().getString("Spawn.World");

                World world = Bukkit.getServer().getWorld(sWorld);
                if (world == null) {
                    player.sendMessage(ChatColor.RED + "Hata: Belirtilen spawn dünyası bulunamadı: " + sWorld);
                    Bukkit.getLogger().severe("Hata: Belirtilen spawn dünyası bulunamadı: " + sWorld);
                    return true;
                }

                Location spawnLocation = new Location(world, sX, sY, sZ, sYaw, sPitch);
                player.teleport(spawnLocation);
                player.sendMessage(prefix + " " + spawnMessage);
            }
        }
        return true;
    }

}


