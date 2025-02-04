package com.viayxempire;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.List;

public class ClickEvent implements Listener {

    private final Plugin p;
    private final String prefix = ChatColor.YELLOW + "[EmpireProtect] ";

    public ClickEvent(Plugin plugin) {
        this.p = plugin;
    }

    // Yardımcı metot: Hem Türkçe hem İngilizce isim kontrolü yapar.
    private boolean checkItemName(ItemMeta meta, String nameTurkish, String nameEnglish) {
        if (meta == null) return false;
        String displayName = meta.getDisplayName();
        return displayName.contains(ChatColor.GREEN + nameTurkish) || displayName.contains(ChatColor.GREEN + nameEnglish);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;

        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getInventory();
        String inventoryTitle = event.getView().getTitle();
        if (!inventoryTitle.equalsIgnoreCase(ChatColor.DARK_GREEN + "Empire Protect")) return;

        // Dil ayarını config'den al; varsayılan olarak "tr" kabul ediliyor.
        String language = p.getConfig().getString("Settings.Language", "tr");

        if (event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR) {
            event.setCancelled(true);
            ItemMeta meta = event.getCurrentItem().getItemMeta();
            if (meta == null) return;

            if (checkItemName(meta, "Giriş Yazısı", "Welcome Title")) {
                String key = "Join.TitleEnabled";
                if (language.equalsIgnoreCase("en")) {
                    toggleSetting(player, key, "Join title disabled!", "Join title enabled!");
                } else {
                    toggleSetting(player, key, "Giriş yazısı devre dışı bırakıldı!", "Giriş yazısı etkinleştirildi!");
                }
            }
            else if (checkItemName(meta, "Girişte Spawn'a Işınlama", "Teleport to Spawn on Join")) {
                String key = "Spawn.SendToSpawn";
                if (language.equalsIgnoreCase("en")) {
                    toggleSetting(player, key, "Teleport to spawn on join disabled!", "Teleport to spawn on join enabled!");
                } else {
                    toggleSetting(player, key, "Spawn'a ışınlama devre dışı bırakıldı!", "Spawn'a ışınlama etkinleştirildi!");
                }
            }
            else if (checkItemName(meta, "Eşya Alma", "Item Pickup")) {
                String key = "Settings.spawn.pickup";
                if (language.equalsIgnoreCase("en")) {
                    toggleSetting(player, key, "Item pickup disabled!", "Item pickup enabled!");
                } else {
                    toggleSetting(player, key, "Eşya alma devre dışı bırakıldı!", "Eşya alma etkinleştirildi!");
                }
            }
            else if (checkItemName(meta, "Eşya Atma", "Item Drop")) {
                String key = "Settings.spawn.drop";
                if (language.equalsIgnoreCase("en")) {
                    toggleSetting(player, key, "Item drop disabled!", "Item drop enabled!");
                } else {
                    toggleSetting(player, key, "Eşya atma devre dışı bırakıldı!", "Eşya atma etkinleştirildi!");
                }
            }
            else if (checkItemName(meta, "Blok Koyma", "Block Placement")) {
                String key = "Settings.spawn.place";
                if (language.equalsIgnoreCase("en")) {
                    toggleSetting(player, key, "Block placement disabled!", "Block placement enabled!");
                } else {
                    toggleSetting(player, key, "Blok koyma devre dışı bırakıldı!", "Blok koyma etkinleştirildi!");
                }
            }
            else if (checkItemName(meta, "Blok Kırma", "Block Break")) {
                String key = "Settings.spawn.break";
                if (language.equalsIgnoreCase("en")) {
                    toggleSetting(player, key, "Block break disabled!", "Block break enabled!");
                } else {
                    toggleSetting(player, key, "Blok kırma devre dışı bırakıldı!", "Blok kırma etkinleştirildi!");
                }
            }
            else if (checkItemName(meta, "Etkileşim", "Interact")) {
                String key = "Settings.spawn.use";
                if (language.equalsIgnoreCase("en")) {
                    toggleSetting(player, key, "Interaction disabled!", "Interaction enabled!");
                } else {
                    toggleSetting(player, key, "Etkileşim devre dışı bırakıldı!", "Etkileşim etkinleştirildi!");
                }
            }
            else if (checkItemName(meta, "PvP (Dövüş)", "PvP (Combat)")) {
                String key = "Settings.spawn.pvp";
                if (language.equalsIgnoreCase("en")) {
                    toggleSetting(player, key, "PvP disabled!", "PvP enabled!");
                } else {
                    toggleSetting(player, key, "PvP devre dışı bırakıldı!", "PvP etkinleştirildi!");
                }
            }
            else if (checkItemName(meta, "Yaratık Doğması", "Mob Spawning")) {
                String key = "Settings.spawn.mobspawn";
                if (language.equalsIgnoreCase("en")) {
                    toggleSetting(player, key, "Mob spawning disabled!", "Mob spawning enabled!");
                } else {
                    toggleSetting(player, key, "Yaratık doğması devre dışı bırakıldı!", "Yaratık doğması etkinleştirildi!");
                }
            }
            else if (checkItemName(meta, "Sohbet Kullanma", "Chat Usage")) {
                String key = "Settings.spawn.chat";
                if (language.equalsIgnoreCase("en")) {
                    toggleSetting(player, key, "Chat usage disabled!", "Chat usage enabled!");
                } else {
                    toggleSetting(player, key, "Sohbet kullanma devre dışı bırakıldı!", "Sohbet kullanma etkinleştirildi!");
                }
            }
            else if (checkItemName(meta, "Gün Döngüsü", "Daylight Cycle")) {
                String key = "Settings.DaylightCycle";
                if (language.equalsIgnoreCase("en")) {
                    toggleSetting(player, key, "Daylight cycle disabled!", "Daylight cycle enabled!");
                } else {
                    toggleSetting(player, key, "Gün döngüsü devre dışı bırakıldı!", "Gün döngüsü etkinleştirildi!");
                }
                updateDaylightCycle();
            }
            else if (checkItemName(meta, "Hava Döngüsü", "Weather Cycle")) {
                String key = "Settings.WeatherChange";
                if (language.equalsIgnoreCase("en")) {
                    toggleSetting(player, key, "Weather cycle disabled!", "Weather cycle enabled!");
                } else {
                    toggleSetting(player, key, "Hava döngüsü devre dışı bırakıldı!", "Hava döngüsü etkinleştirildi!");
                }
                updateWeatherCycle();
            }
            else if (checkItemName(meta, "Set Spawn Area", "Spawn Bölgesi Ayarla")) {
                player.closeInventory();
                player.performCommand("ep setspawn");
            }
            else if (checkItemName(meta, "Add Protected World", "Korunacak Dünya Ekle")) {
                player.closeInventory();
                List<String> worlds = p.getConfig().getStringList("Settings.spawn.worlds");
                String worldName = player.getLocation().getWorld().getName();
                if (worlds.contains(worldName)) {
                    if (language.equalsIgnoreCase("en")) {
                        player.sendMessage(ChatColor.GREEN + "This world is already protected: " + ChatColor.YELLOW + worldName);
                    } else {
                        player.sendMessage(ChatColor.GREEN + "Bu dünya zaten korunuyor: " + ChatColor.YELLOW + worldName);
                    }
                } else {
                    worlds.add(worldName);
                    p.getConfig().set("Settings.spawn.worlds", worlds);
                    p.saveConfig();
                    if (language.equalsIgnoreCase("en")) {
                        player.sendMessage(ChatColor.GREEN + "Added to protected worlds list: " + ChatColor.YELLOW + worldName);
                    } else {
                        player.sendMessage(ChatColor.GREEN + "Korunan dünyalar listesine eklendi: " + ChatColor.YELLOW + worldName);
                    }
                }
            }
            else if (checkItemName(meta, "Language", "Dil")) {
                player.closeInventory();
                String currentLanguage = p.getConfig().getString("Settings.Language", "en");
                if ("tr".equalsIgnoreCase(currentLanguage)) {
                    p.getConfig().set("Settings.Language", "en");
                    player.sendMessage(ChatColor.GREEN + "Language set to English.");
                } else {
                    p.getConfig().set("Settings.Language", "tr");
                    player.sendMessage(ChatColor.GREEN + "Dil Türkçe olarak ayarlandı.");
                }
                p.saveConfig();
            }
        }
    }


    // Ayar değerini, "Join.TitleEnabled", "Spawn.SendToSpawn" ve "Spawn.SpawnCommand" için true/false, diğerleri için "allow"/"deny" arasında değiştirir, config'i kaydeder ve oyuncuya mesaj gönderir.
    private void toggleSetting(Player player, String key, String denyMessage, String allowMessage) {
        // Belirtilen anahtarlar true/false olarak ele alınacak.
        if (key.equals("Join.TitleEnabled") || key.equals("Spawn.SendToSpawn") || key.equals("Spawn.SpawnCommand")) {
            boolean currentValue = p.getConfig().getBoolean(key, false);
            if (currentValue) {
                p.getConfig().set(key, false);
                player.sendMessage(prefix + ChatColor.GREEN + denyMessage);
            } else {
                p.getConfig().set(key, true);
                player.sendMessage(prefix + ChatColor.GREEN + allowMessage);
            }
            p.saveConfig();
            player.performCommand("ep");
            return;
        }

        // Diğer ayarlar için "allow"/"deny" toggle işlemi
        String current = p.getConfig().getString(key, "deny");
        if (current.equalsIgnoreCase("allow")) {
            p.getConfig().set(key, "deny");
            player.sendMessage(prefix + ChatColor.GREEN + denyMessage);
        } else {
            p.getConfig().set(key, "allow");
            player.sendMessage(prefix + ChatColor.GREEN + allowMessage);
        }
        p.saveConfig();
        player.performCommand("ep");
    }


    // Tüm korunan spawn dünyalarında gün döngüsünü, config ayarına göre günceller.
    private void updateDaylightCycle() {
        String cycleSetting = p.getConfig().getString("Settings.DaylightCycle", "allow");
        List<String> spawnWorlds = p.getConfig().getStringList("Settings.spawn.worlds");
        for (String worldName : spawnWorlds) {
            World world = Bukkit.getWorld(worldName);
            if (world != null) {
                if (cycleSetting.equalsIgnoreCase("deny")) {
                    world.setGameRuleValue("doDaylightCycle", "false");
                    long currentTime = world.getTime();
                    world.setTime(currentTime);
                } else {
                    world.setGameRuleValue("doDaylightCycle", "true");
                }
            }
        }
    }

    // Tüm korunan spawn dünyalarında hava durumunu, config ayarına göre günceller.
    private void updateWeatherCycle() {
        String weatherSetting = p.getConfig().getString("Settings.WeatherChange", "allow");
        List<String> spawnWorlds = p.getConfig().getStringList("Settings.spawn.worlds");
        for (String worldName : spawnWorlds) {
            World world = Bukkit.getWorld(worldName);
            if (world != null) {
                if (weatherSetting.equalsIgnoreCase("deny")) {
                    world.setStorm(false);
                    world.setThundering(false);
                }
            }
        }
    }
}
