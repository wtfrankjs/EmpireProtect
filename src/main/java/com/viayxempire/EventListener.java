package com.viayxempire;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class EventListener implements Listener {
    private final Plugin p;
    private final String prefix;

    // Spawn konfigürasyon değerleri
    private float sYaw;
    private float sPitch;
    private double sX;
    private double sY;
    private double sZ;
    private String sWorld;

    public EventListener(Plugin pl) {
        this.p = pl;
        // Prefix'i config üzerinden alıp renk kodlarını uygular
        this.prefix = ChatColor.translateAlternateColorCodes('&', p.getConfig().getString("Settings.Prefix", "[EmpireProtect]"));
    }

    // Yardımcı metot: Belirtilen dünyanın spawn listesinde olup olmadığını kontrol eder.
    private boolean isSpawnWorld(World world) {
        List<String> worlds = p.getConfig().getStringList("Settings.spawn.worlds");
        return worlds.contains(world.getName());
    }

    // Yardımcı metot: Oyuncunun admin iznine sahip olup olmadığını kontrol eder.
    private boolean isAdmin(Player player) {
        return player.hasPermission(p.getConfig().getString("Settings.spawn.adminperm"));
    }

    // Oyuncu sunucuya katıldığında; eğer join title ayarı "allow" ise title mesajı gönderip, spawn'a ışınlar.
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (p.getConfig().getString("Join.TitleEnabled", "false").equalsIgnoreCase("true")) {
            String joinTitle = ChatColor.translateAlternateColorCodes('&', p.getConfig().getString("Join.Title", ""));
            String joinSubtitle = ChatColor.translateAlternateColorCodes('&', p.getConfig().getString("Join.Subtitle", ""));
            joinSubtitle = joinSubtitle.replace("%player%", player.getDisplayName());
            player.sendTitle(joinTitle, joinSubtitle);
        }
        teleportToSpawn(player);
    }

    // Teleport işlemi: Eğer "Spawn.SendToSpawn" ayarı "allow" ise oyuncuyu spawn noktasına ışınlar.
    private void teleportToSpawn(Player player) {
        if (p.getConfig().getString("Spawn.SendToSpawn", "false").equalsIgnoreCase("true")) {
            sYaw = (float) p.getConfig().getDouble("Spawn.Yaw", 0);
            sPitch = (float) p.getConfig().getDouble("Spawn.Pitch", 0);
            sX = p.getConfig().getDouble("Spawn.X", 0);
            sY = p.getConfig().getDouble("Spawn.Y", 0);
            sZ = p.getConfig().getDouble("Spawn.Z", 0);
            sWorld = p.getConfig().getString("Spawn.World", "world");

            World world = Bukkit.getWorld(sWorld);
            if (world == null) {
                Bukkit.getLogger().severe(prefix + " Hata: Belirtilen spawn dünyası bulunamadı: " + sWorld);
                Bukkit.getLogger().severe(prefix + " ERROR: This world is not found: " + sWorld);
                return;
            }
            Location spawnLoc = new Location(world, sX, sY, sZ, sYaw, sPitch);
            player.teleport(spawnLoc);
        }
    }

    // Spawn koruma mesajı gönderir.
    private void sendSpawnProtectionMessage(Player player) {
        String message;
        String language = p.getConfig().getString("Settings.Language", "en");
        if (language.equalsIgnoreCase("tr")) {
            message = Main.getMessages().getString("tr.Error1");
        } else {
            message = Main.getMessages().getString("en.Error1");
        }
        player.sendMessage(prefix + " " + ChatColor.translateAlternateColorCodes('&', message));
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        if (isAdmin(player)) return;
        // "deny" ise blok kırma engellensin.
        if (p.getConfig().getString("Settings.spawn.break", "deny").equalsIgnoreCase("deny") && isSpawnWorld(player.getWorld())) {
            e.setCancelled(true);
            sendSpawnProtectionMessage(player);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        if (isAdmin(player)) return;
        if (p.getConfig().getString("Settings.spawn.place", "deny").equalsIgnoreCase("deny") && isSpawnWorld(player.getWorld())) {
            e.setCancelled(true);
            sendSpawnProtectionMessage(player);
        }
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        World world = e.getWorld();
        if (isSpawnWorld(world) && p.getConfig().getString("Settings.WeatherChange", "allow").equalsIgnoreCase("deny")) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onThunderChange(ThunderChangeEvent e) {
        World world = e.getWorld();
        if (isSpawnWorld(world) && p.getConfig().getString("Settings.WeatherChange", "allow").equalsIgnoreCase("deny")) {
            if (e.toThunderState()) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        if (isAdmin(player)) return;
        if (p.getConfig().getString("Settings.spawn.drop", "deny").equalsIgnoreCase("deny") && isSpawnWorld(player.getWorld())) {
            e.setCancelled(true);
            sendSpawnProtectionMessage(player);
        }
    }

    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent e) {
        if (!(e.getPlayer() instanceof Player)) return;
        Player player = (Player) e.getPlayer();
        if (isAdmin(player)) return;
        if (p.getConfig().getString("Settings.spawn.pickup", "deny").equalsIgnoreCase("deny") && isSpawnWorld(player.getWorld())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        Entity entity = e.getEntity();
        if (entity instanceof Player && isSpawnWorld(entity.getWorld())) {
            if (p.getConfig().getString("Settings.spawn.pvp", "deny").equalsIgnoreCase("deny")) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent e) {
        World world = e.getEntity().getWorld();
        if (isSpawnWorld(world)) {
            if (p.getConfig().getString("Settings.spawn.mobspawn", "deny").equalsIgnoreCase("deny") && !(e.getEntity() instanceof Player)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        if (isSpawnWorld(player.getWorld()) && !isAdmin(player)) {
            if (p.getConfig().getString("Settings.spawn.chat", "deny").equalsIgnoreCase("deny")) {
                e.setCancelled(true);
                sendSpawnProtectionMessage(player);
            }
        }
    }

    @EventHandler
    public void onBucketEmpty(PlayerBucketEmptyEvent e) {
        Player player = e.getPlayer();
        if (isAdmin(player)) return;
        if (p.getConfig().getString("Settings.spawn.use", "deny").equalsIgnoreCase("deny") && isSpawnWorld(player.getWorld())) {
            e.setCancelled(true);
            sendSpawnProtectionMessage(player);
        }
    }

    @EventHandler
    public void onBucketFill(PlayerBucketFillEvent e) {
        Player player = e.getPlayer();
        if (isAdmin(player)) return;
        if (p.getConfig().getString("Settings.spawn.use", "deny").equalsIgnoreCase("deny") && isSpawnWorld(player.getWorld())) {
            e.setCancelled(true);
            sendSpawnProtectionMessage(player);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (isAdmin(player)) return;
        if (p.getConfig().getString("Settings.spawn.use", "deny").equalsIgnoreCase("deny") && isSpawnWorld(player.getWorld())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerItemDamage(PlayerItemDamageEvent e) {
        Player player = e.getPlayer();
        if (isAdmin(player)) return;
        if (p.getConfig().getString("Settings.spawn.use", "deny").equalsIgnoreCase("deny") && isSpawnWorld(player.getWorld())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent e) {
        Player player = e.getPlayer();
        if (isAdmin(player)) return;
        if (p.getConfig().getString("Settings.spawn.use", "deny").equalsIgnoreCase("deny") && isSpawnWorld(player.getWorld())) {
            e.setCancelled(true);
        }
    }
}
