package com.viayxempire;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.common.base.Charsets;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;


public class Configs {
    private String name;

    private Plugin plug;
    //private static HashMap<String, HashMap<String, Object>> configs = new HashMap<String, HashMap<String, Object>>();
    private static FileConfiguration newConfig = null;
    private static File configFile = null;

    public Configs(String name, Plugin plug){
        this.plug = plug;
        this.name = name;
        configFile = new File(plug.getDataFolder()+File.separator+name+".yml");
    }

    public void createConfig() {
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public FileConfiguration getConfig() {
        if (newConfig == null) {
            reloadConfig();
        }
        return newConfig;
    }

    public void reloadConfig() {
        newConfig = YamlConfiguration.loadConfiguration(configFile);

        final InputStream defConfigStream = plug.getResource(name+".yml");
        if (defConfigStream == null) {
            return;
        }

        newConfig.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, Charsets.UTF_8)));
    }

    public void saveConfig() {
        try {
            getConfig().save(configFile);
        } catch (IOException ex) {
            System.out.println("Could not save config to " + configFile);
        }
    }

    public void saveDefaultConfig() {
        InputStream  data = plug.getClass().getResourceAsStream("/"+name+".yml");

        getConfig().setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(data, Charsets.UTF_8)));
      /*if (!configFile.exists()) {
          saveResource(name+".yml", false);
      }*/
    }

}
