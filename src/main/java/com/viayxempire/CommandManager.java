package com.viayxempire;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.bukkit.Bukkit.getLogger;

public class CommandManager implements CommandExecutor {

    Plugin p;
    public CommandManager(Plugin pl) {
        p = pl;
    }

    public File getDataFolder() {
        return p.getDataFolder();
    }

    String prefix = "[EmpireProtect]";

    private static final String GREEN = "\033[0;32m";
    private static final String YELLOW = "\033[0;33m";
    private static final String RED = "\033[0;31m";
    private static final String RESET = "\033[0m";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // (İsteğe bağlı: sender oyuncu ise bazı işlemler yapılabilir)
        if (sender instanceof Player) {
            Player player = (Player) sender;
        }
        // Yönetici izni kontrolü
        if (sender.hasPermission(p.getConfig().getString("Settings.spawn.adminperm"))) {
            // Dil ayarını oku, varsayılan "tr"
            String language = p.getConfig().getString("Settings.Language", "tr");

            if (args.length != 0) {
                String arg = args[0];

                // Allow/Deny toggle: "pickup" ayarı (allow/deny)
                if (arg.equalsIgnoreCase("pickup")) {
                    if (p.getConfig().getString("Settings.spawn.pickup", "deny").equalsIgnoreCase("deny")) {
                        p.getConfig().set("Settings.spawn.pickup", "allow");
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.GREEN + "Setting enabled!");
                        } else {
                            sender.sendMessage(ChatColor.GREEN + "Ayar aktifleştirildi!");
                        }
                    } else {
                        p.getConfig().set("Settings.spawn.pickup", "deny");
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.RED + "Setting disabled!");
                        } else {
                            sender.sendMessage(ChatColor.RED + "Ayar devre dışı!");
                        }
                    }
                    p.saveConfig();
                }
                // "place" ayarı (allow/deny)
                else if (arg.equalsIgnoreCase("place")) {
                    if (p.getConfig().getString("Settings.spawn.place", "deny").equalsIgnoreCase("deny")) {
                        p.getConfig().set("Settings.spawn.place", "allow");
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.GREEN + "Setting enabled!");
                        } else {
                            sender.sendMessage(ChatColor.GREEN + "Ayar aktifleştirildi!");
                        }
                    } else {
                        p.getConfig().set("Settings.spawn.place", "deny");
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.RED + "Setting disabled!");
                        } else {
                            sender.sendMessage(ChatColor.RED + "Ayar devre dışı!");
                        }
                    }
                    p.saveConfig();
                }
                // "break" ayarı (allow/deny)
                else if (arg.equalsIgnoreCase("break")) {
                    if (p.getConfig().getString("Settings.spawn.break", "deny").equalsIgnoreCase("deny")) {
                        p.getConfig().set("Settings.spawn.break", "allow");
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.GREEN + "Setting enabled!");
                        } else {
                            sender.sendMessage(ChatColor.GREEN + "Ayar aktifleştirildi!");
                        }
                    } else {
                        p.getConfig().set("Settings.spawn.break", "deny");
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.RED + "Setting disabled!");
                        } else {
                            sender.sendMessage(ChatColor.RED + "Ayar devre dışı!");
                        }
                    }
                    p.saveConfig();
                }
                // "drop" ayarı (allow/deny)
                else if (arg.equalsIgnoreCase("drop")) {
                    if (p.getConfig().getString("Settings.spawn.drop", "deny").equalsIgnoreCase("deny")) {
                        p.getConfig().set("Settings.spawn.drop", "allow");
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.GREEN + "Setting enabled!");
                        } else {
                            sender.sendMessage(ChatColor.GREEN + "Ayar aktifleştirildi!");
                        }
                    } else {
                        p.getConfig().set("Settings.spawn.drop", "deny");
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.RED + "Setting disabled!");
                        } else {
                            sender.sendMessage(ChatColor.RED + "Ayar devre dışı!");
                        }
                    }
                    p.saveConfig();
                }
                // "DaylightCycle" ayarı (allow/deny)
                else if (arg.equalsIgnoreCase("DaylightCycle")) {
                    if (p.getConfig().getString("Settings.DaylightCycle", "deny").equalsIgnoreCase("deny")) {
                        p.getConfig().set("Settings.DaylightCycle", "allow");
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.GREEN + "Setting enabled!");
                        } else {
                            sender.sendMessage(ChatColor.GREEN + "Ayar aktifleştirildi!");
                        }
                    } else {
                        p.getConfig().set("Settings.DaylightCycle", "deny");
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.RED + "Setting disabled!");
                        } else {
                            sender.sendMessage(ChatColor.RED + "Ayar devre dışı!");
                        }
                    }
                    p.saveConfig();
                }
                // "WeatherChange" ayarı (allow/deny)
                else if (arg.equalsIgnoreCase("WeatherChange")) {
                    if (p.getConfig().getString("Settings.WeatherChange", "deny").equalsIgnoreCase("deny")) {
                        p.getConfig().set("Settings.WeatherChange", "allow");
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.GREEN + "Setting enabled!");
                        } else {
                            sender.sendMessage(ChatColor.GREEN + "Ayar aktifleştirildi!");
                        }
                    } else {
                        p.getConfig().set("Settings.WeatherChange", "deny");
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.RED + "Setting disabled!");
                        } else {
                            sender.sendMessage(ChatColor.RED + "Ayar devre dışı!");
                        }
                    }
                    p.saveConfig();
                }
                // "use" ayarı (allow/deny)
                else if (arg.equalsIgnoreCase("use")) {
                    if (p.getConfig().getString("Settings.spawn.use", "deny").equalsIgnoreCase("deny")) {
                        p.getConfig().set("Settings.spawn.use", "allow");
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.GREEN + "Setting enabled!");
                        } else {
                            sender.sendMessage(ChatColor.GREEN + "Ayar aktifleştirildi!");
                        }
                    } else {
                        p.getConfig().set("Settings.spawn.use", "deny");
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.RED + "Setting disabled!");
                        } else {
                            sender.sendMessage(ChatColor.RED + "Ayar devre dışı!");
                        }
                    }
                    p.saveConfig();
                }
                // "pvp" ayarı (allow/deny)
                else if (arg.equalsIgnoreCase("pvp")) {
                    if (p.getConfig().getString("Settings.spawn.pvp", "deny").equalsIgnoreCase("deny")) {
                        p.getConfig().set("Settings.spawn.pvp", "allow");
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.GREEN + "Setting enabled!");
                        } else {
                            sender.sendMessage(ChatColor.GREEN + "Ayar aktifleştirildi!");
                        }
                    } else {
                        p.getConfig().set("Settings.spawn.pvp", "deny");
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.RED + "Setting disabled!");
                        } else {
                            sender.sendMessage(ChatColor.RED + "Ayar devre dışı!");
                        }
                    }
                    p.saveConfig();
                }
                // "mobspawn" ayarı (allow/deny)
                else if (arg.equalsIgnoreCase("mobspawn")) {
                    if (p.getConfig().getString("Settings.spawn.mobspawn", "deny").equalsIgnoreCase("deny")) {
                        p.getConfig().set("Settings.spawn.mobspawn", "allow");
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.GREEN + "Setting enabled!");
                        } else {
                            sender.sendMessage(ChatColor.GREEN + "Ayar aktifleştirildi!");
                        }
                    } else {
                        p.getConfig().set("Settings.spawn.mobspawn", "deny");
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.RED + "Setting disabled!");
                        } else {
                            sender.sendMessage(ChatColor.RED + "Ayar devre dışı!");
                        }
                    }
                    p.saveConfig();
                }
                // "chat" ayarı (allow/deny)
                else if (arg.equalsIgnoreCase("chat")) {
                    if (p.getConfig().getString("Settings.spawn.chat", "deny").equalsIgnoreCase("deny")) {
                        p.getConfig().set("Settings.spawn.chat", "allow");
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.GREEN + "Setting enabled!");
                        } else {
                            sender.sendMessage(ChatColor.GREEN + "Ayar aktifleştirildi!");
                        }
                    } else {
                        p.getConfig().set("Settings.spawn.chat", "deny");
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.RED + "Setting disabled!");
                        } else {
                            sender.sendMessage(ChatColor.RED + "Ayar devre dışı!");
                        }
                    }
                    p.saveConfig();
                }
                // Boolean toggle: "Title" (Join.TitleEnabled true/false)
                else if (arg.equalsIgnoreCase("Title")) {
                    if (!p.getConfig().getBoolean("Join.TitleEnabled", false)) {
                        p.getConfig().set("Join.TitleEnabled", true);
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.GREEN + "Setting enabled!");
                        } else {
                            sender.sendMessage(ChatColor.GREEN + "Ayar aktifleştirildi!");
                        }
                    } else {
                        p.getConfig().set("Join.TitleEnabled", false);
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.RED + "Setting disabled!");
                        } else {
                            sender.sendMessage(ChatColor.RED + "Ayar devre dışı!");
                        }
                    }
                    p.saveConfig();
                }
                // Boolean toggle: "setworld" (örneğin yine Join.TitleEnabled üzerinden toggle yapılıyorsa)
                else if (arg.equalsIgnoreCase("setworld")) {
                    if (!p.getConfig().getBoolean("Join.TitleEnabled", false)) {
                        p.getConfig().set("Join.TitleEnabled", true);
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.GREEN + "Setting enabled!");
                        } else {
                            sender.sendMessage(ChatColor.GREEN + "Ayar aktifleştirildi!");
                        }
                    } else {
                        p.getConfig().set("Join.TitleEnabled", false);
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.RED + "Setting disabled!");
                        } else {
                            sender.sendMessage(ChatColor.RED + "Ayar devre dışı!");
                        }
                    }
                    p.saveConfig();
                }
                // Boolean toggle: "joinspawn" (Join.TeleportSpawn true/false)
                else if (arg.equalsIgnoreCase("joinspawn")) {
                    if (!p.getConfig().getBoolean("Join.TeleportSpawn", false)) {
                        p.getConfig().set("Join.TeleportSpawn", true);
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.GREEN + "Setting enabled!");
                        } else {
                            sender.sendMessage(ChatColor.GREEN + "Ayar aktifleştirildi!");
                        }
                    } else {
                        p.getConfig().set("Join.TeleportSpawn", false);
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(ChatColor.RED + "Setting disabled!");
                        } else {
                            sender.sendMessage(ChatColor.RED + "Ayar devre dışı!");
                        }
                    }
                    p.saveConfig();
                }
                // "setspawn" komutu: Oyuncunun konumunu spawn olarak kaydeder.
                else if (arg.equalsIgnoreCase("setspawn")) {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        Location l = player.getLocation();
                        p.getConfig().set("Spawn.SendToSpawn", true);
                        p.getConfig().set("Spawn.X", l.getBlockX() + 0.5);
                        p.getConfig().set("Spawn.Y", l.getBlockY() + 0.5);
                        p.getConfig().set("Spawn.Z", l.getBlockZ() + 0.5);
                        p.getConfig().set("Spawn.Yaw", l.getYaw());
                        p.getConfig().set("Spawn.Pitch", l.getPitch());
                        p.getConfig().set("Spawn.World", l.getWorld().getName());
                        p.saveConfig();
                        if (language.equalsIgnoreCase("en")) {
                            player.sendMessage(ChatColor.GREEN + "Spawn area set!");
                        } else {
                            player.sendMessage(ChatColor.GREEN + "Spawn bölgesi ayarlandı!");
                        }
                    } else {
                        getLogger().info("Bu komut sadece oyun içinde kullanılabilir!");
                    }
                }
                // "update" komutu: Güncelleme işlemini başlatır.
                else if (arg.equalsIgnoreCase("update")) {
                    if (sender.hasPermission(p.getConfig().getString("Settings.spawn.adminperm"))) {
                        downloadAndUpdate();
                        if (language.equalsIgnoreCase("en")) {
                            sender.sendMessage(prefix + ChatColor.GREEN + " Update process started.");
                            sender.sendMessage(prefix + " Check console for status.");
                        } else {
                            sender.sendMessage(prefix + ChatColor.GREEN + " Güncelleme işlemi başlatıldı.");
                            sender.sendMessage(prefix + " Konsoldan durumu kontrol edebilirsiniz!");
                        }
                        return true;
                    } else {
                        sender.sendMessage("Bu komutu kullanma izniniz yok.");
                        return false;
                    }
                }
                // Yeni eklenen "reload" komutu: Eklenti yapılandırmasını yeniden yükler.
                else if (arg.equalsIgnoreCase("reload")) {
                    p.reloadConfig();
                    if (language.equalsIgnoreCase("en")) {
                        sender.sendMessage(ChatColor.GREEN + "Plugin configuration reloaded!");
                    } else {
                        sender.sendMessage(ChatColor.GREEN + "Eklenti yapılandırması yeniden yüklendi!");
                    }
                }
                // "help" komutu: Yardım bilgisini gösterir.
                else if (arg.equalsIgnoreCase("help")) {
                    String confPrefix = p.getConfig().getString("Settings.Prefix");
                    confPrefix = ChatColor.translateAlternateColorCodes('&', confPrefix);
                    if (language.equalsIgnoreCase("en")) {
                        sender.sendMessage(ChatColor.GOLD + "+----------------" + ChatColor.RED + ChatColor.BOLD + "EMPIRE PROTECT" + ChatColor.YELLOW + "-----------------+");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "Protected World(s): " + ChatColor.GREEN + p.getConfig().getString("Settings.spawn.worlds"));
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep title " + ChatColor.GREEN + "Join title");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep break " + ChatColor.GREEN + "Block break");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep place " + ChatColor.GREEN + "Block placement");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep drop " + ChatColor.GREEN + "Item drop");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep pickup " + ChatColor.GREEN + "Item pickup");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep pvp " + ChatColor.GREEN + "PvP (Combat)");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep use " + ChatColor.GREEN + "Interaction");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep mobspawn " + ChatColor.GREEN + "Mob spawning");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep joinspawn " + ChatColor.GREEN + "Join teleport");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep setspawn " + ChatColor.GREEN + "Set spawn area.");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep daylightcycle " + ChatColor.GREEN + "Daylight cycle.");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep weatherchange " + ChatColor.GREEN + "Weather cycle.");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep update " + ChatColor.GREEN + "Auto update plugin.");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep reload " + ChatColor.GREEN + "Reload plugin config.");
                        sender.sendMessage(ChatColor.GOLD + "+----------------" + ChatColor.RED + ChatColor.BOLD + "EMPIRE PROTECT" + ChatColor.YELLOW + "-----------------+");
                    } else {
                        sender.sendMessage(ChatColor.GOLD + "+----------------" + ChatColor.RED + ChatColor.BOLD + "EMPIRE PROTECT" + ChatColor.YELLOW + "-----------------+");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "Korunan Dünyalar: " + ChatColor.GREEN + p.getConfig().getString("Settings.spawn.worlds"));
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep title " + ChatColor.GREEN + "Giriş yazısı");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep break " + ChatColor.GREEN + "Blok kırma");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep place " + ChatColor.GREEN + "Block yerleştirme");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep drop " + ChatColor.GREEN + "Eşya atma");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep pickup " + ChatColor.GREEN + "Eşya alma");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep pvp " + ChatColor.GREEN + "PvP (Dövüş)");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep use " + ChatColor.GREEN + "Etkileşim");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep mobspawn " + ChatColor.GREEN + "Yaratık Doğması");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep joinspawn " + ChatColor.GREEN + "Giriş ışınlanması");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep setspawn " + ChatColor.GREEN + "Spawn bölgesi ayarlama.");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep daylightcycle " + ChatColor.GREEN + "Gün döngüsü ayarlama.");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep weatherchange " + ChatColor.GREEN + "Hava döngüsü ayarlama.");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep update " + ChatColor.GREEN + "Eklentiyi otomatik güncelle.");
                        sender.sendMessage(confPrefix + " " + ChatColor.YELLOW + "/ep reload " + ChatColor.GREEN + "Eklenti yapılandırmasını yeniden yükle.");
                        sender.sendMessage(ChatColor.GOLD + "+----------------" + ChatColor.RED + ChatColor.BOLD + "EMPIRE PROTECT" + ChatColor.YELLOW + "-----------------+");
                    }
                }
            } else {
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    player.performCommand("epgui");
                }
            }
        }
        return true;
    }

    private void downloadAndUpdate() {
        String downloadUrl = "https://drive.google.com/uc?export=download&id=1YSjN0pWxA2tveiNy6vTZRzZZuRXXJXzL";
        new Thread(() -> {
            try {
                URL url = new URL(downloadUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                File file = new File(getDataFolder().getParentFile(), "EmpireProtect.jar");
                try (BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
                     FileOutputStream fos = new FileOutputStream(file)) {

                    byte[] dataBuffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                        fos.write(dataBuffer, 0, bytesRead);
                    }
                    getLogger().info(YELLOW + prefix + GREEN + " Güncelleme indirildi." + RESET);
                    getLogger().info(YELLOW + prefix + RED + " Sunucuyu Yeniden Başlat." + RESET);
                    getLogger().info(YELLOW + prefix + GREEN + "----------------------." + RESET);
                    getLogger().info(YELLOW + prefix + GREEN + " Update downloaded." + RESET);
                    getLogger().info(YELLOW + prefix + RED + " Restart the server." + RESET);
                }
            } catch (IOException e) {
                getLogger().severe(YELLOW + prefix + RED + " Güncelleme indirilirken bir hata oluştu: " + e.getMessage());
            }
        }).start();
    }
}
