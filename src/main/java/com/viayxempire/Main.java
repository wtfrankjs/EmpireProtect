package com.viayxempire;

import java.io.*;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.logging.Logger;

import org.bukkit.entity.Player;


public class Main extends JavaPlugin implements Listener{

    private static final Logger logger = Logger.getLogger("Minecraft");


    // ANSI escape codes for colors
    private static final String GREEN = "\033[0;32m";
    private static final String YELLOW = "\033[0;33m";
    private static final String RED = "\033[0;31m";
    private static final String RESET = "\033[0m";

    public static Configs messages;
    String ayarPath = "Settings.";
    String JoinPath = "Join.";
    String SpawnPath = "Spawn.";
    String trMsg = "tr.";
    String enMsg = "en.";
    FileConfiguration config;
    File configFile;
    String prefix = "[EmpireProtect]";
    private static final int RESOURCE_ID = 99442;

    public void onEnable() {
        checkForUpdates();
        //Config.yml

        saveDefaultConfig();
        config = getConfig();
        config.options().copyDefaults(true);
        saveConfig();

        //Messages
        messages = new Configs("messages", this);
        messages.createConfig();
        getMessages().addDefault(trMsg+ "Error1", "&cBurada bunu yapamazsın!");
        getMessages().addDefault(trMsg+ "Reloaded", "&aPlugin başarıyla yenilendi!");
        getMessages().addDefault(trMsg+ "spawn", "&aBaşarıyla Spawn Noktasına Işınlandınız.");
        getMessages().addDefault(enMsg+ "Error1", "&cYou can't do this here!");
        getMessages().addDefault(enMsg+ "Reloaded", "&aPlugin was reloaded successfully!");
        getMessages().addDefault(enMsg+ "spawn", "&aYou''ve Successfully Teleported to Spawn.");
        messages.saveDefaultConfig();
        messages.getConfig().options().copyDefaults(true);
        messages.saveConfig();

        //BAŞLATMA LOGLARI
        logger.info(prefix + GREEN + " x-------------------------------------------x" + RESET);
        logger.info(prefix + GREEN + " PLUGIN ENABLED!" + RESET);
        logger.info(prefix + YELLOW + " Copyright Reserved" + RESET);
        logger.info(prefix + YELLOW + " Discord: wtfrankjs" + RESET);
        logger.info(prefix + GREEN + " x-------------------------------------------x" + RESET);


        //Event Code
        getServer().getPluginManager().registerEvents(new EventListener(this), this);
        getServer().getPluginManager().registerEvents(new ClickEvent(this), this);
        getServer().getPluginManager().registerEvents(new Gui(this), this);
        getServer().getPluginManager().registerEvents(this, this);

        //Komutlar
        getCommand("empireprotect").setExecutor(new CommandManager(this));
        getCommand("spawn").setExecutor(new Spawn(this));
        getCommand("epgui").setExecutor(new Gui(this));



        //Update Checker
        new UpdateChecker(this, 99442).getVersion(version -> {
            if (this.getDescription().getVersion().equals(version)) {
            } else {
                logger.info(YELLOW + prefix + GREEN + "x-------------------------------------------x" + RESET);
                logger.info(YELLOW + prefix + RED + "      There is a new update available." + RESET);
                logger.info(YELLOW + prefix + RED + "    Update Plugin with /empireprotect update." + RESET);
                logger.info(YELLOW + prefix + GREEN + "x-------------------------------------------x" + RESET);

            }
        });

    }


    public void onDisable() {
        logger.info(YELLOW + "[EmpireProtect]" + " " + RED + "x---------------------------x"+ RESET);
        logger.info(YELLOW + "[EmpireProtect]" + " " + RED + "      Plugin Disabled!"+ RESET);
        logger.info(YELLOW + "[EmpireProtect]" + " " + RED + "     Copyright Reserved"+ RESET);
        logger.info(YELLOW + "[EmpireProtect]" + " " + RED + "     Discord: wtfrankjs"+ RESET);
        logger.info(YELLOW + "[EmpireProtect]" + " " + RED + "x---------------------------x" + RESET);
    }




    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (event.getPlayer().isOp()) { // Oyuncu OP ise
            checkForUpdates();
        }
    }

    private void checkForUpdates() {
        new UpdateChecker(this, RESOURCE_ID).getVersion(latestVersion -> {
            String currentVersion = getDescription().getVersion();
            if (!currentVersion.equals(latestVersion)) {
                String message = ChatColor.YELLOW + prefix + " " + ChatColor.GREEN + "Yeni bir güncelleme var\n" +
                        ChatColor.YELLOW + prefix + " " + ChatColor.RED + "Yeni Sürüm: " + ChatColor.YELLOW + latestVersion + "\n" +
                        ChatColor.YELLOW + prefix + " " + ChatColor.GREEN + "Güncellemek için " + ChatColor.YELLOW + "/empireprotect update" + ChatColor.GREEN + " kullan";

                // OP oyunculara mesaj gönder
                getServer().getOnlinePlayers().stream()
                        .filter(Player::isOp)
                        .forEach(opPlayer -> opPlayer.sendMessage(message));
            }
        });
    }

    public class UpdateChecker {

        private final JavaPlugin plugin;
        private final int resourceId;

        public UpdateChecker(JavaPlugin plugin, int resourceId) {
            this.plugin = plugin;
            this.resourceId = resourceId;
        }

        public void getVersion(final Consumer<String> consumer) {
            Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
                try (InputStream inputStream = new URL("https://raw.githubusercontent.com/wtfrankjs/EmpireProtect/refs/heads/main/versison.txt").openStream();
                     Scanner scanner = new Scanner(inputStream)) {
                    if (scanner.hasNext()) {
                        consumer.accept(scanner.next());
                    }
                } catch (IOException exception) {
                    plugin.getLogger().warning("Unable to check for updates: " + exception.getMessage());
                }
            });
        }
    }



    public static FileConfiguration getMessages() {
        return messages.getConfig();
    }
}