package com.viayxempire;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;


public class Gui implements Listener, CommandExecutor{

    String prefix = ChatColor.YELLOW + "[TheEmpire] ";

    Plugin p;
    public Gui(Plugin pl) {
        p=pl;
    }

    String aktif = ChatColor.GREEN+"Aktif!" ;
    String aktif2 = ChatColor.YELLOW+"Kapatmak için tıkla!" ;
    String devredisi = ChatColor.RED+"Devredışı!" ;
    String devredisi2 = ChatColor.YELLOW+"Açmak için tıkla!" ;

    String enabled = ChatColor.GREEN+"Enabled!" ;
    String enabled2 = ChatColor.YELLOW+"Click to Disable!" ;
    String disabled = ChatColor.RED+"Disabled!" ;
    String disabled2 = ChatColor.YELLOW+"Click to Enable!" ;


    private void openGui(Player player) {
        Inventory inv = Bukkit.createInventory(null, 45, ChatColor.DARK_GREEN + "Empire Protect");

        ItemStack aa = new ItemStack(Material.DIRT);
        ItemMeta aaMeta = aa.getItemMeta();

        ItemStack ab = new ItemStack(Material.DIRT);
        ItemMeta abMeta = ab.getItemMeta();

        ItemStack ac = new ItemStack(Material.DIRT);
        ItemMeta acMeta = ac.getItemMeta();

        ItemStack ba = new ItemStack(Material.DIRT);
        ItemMeta baMeta = ba.getItemMeta();

        ItemStack bb = new ItemStack(Material.DIRT);
        ItemMeta bbMeta = bb.getItemMeta();

        ItemStack bc = new ItemStack(Material.DIRT);
        ItemMeta bcMeta = bc.getItemMeta();

        ItemStack ca = new ItemStack(Material.DIRT);
        ItemMeta caMeta = ca.getItemMeta();

        ItemStack cb = new ItemStack(Material.DIRT);
        ItemMeta cbMeta = cb.getItemMeta();

        ItemStack cc = new ItemStack(Material.DIRT);
        ItemMeta ccMeta = cc.getItemMeta();

        ItemStack cd = new ItemStack(Material.DIRT);
        ItemMeta cdMeta = cd.getItemMeta();

        ItemStack da = new ItemStack(Material.ENDER_PEARL);
        ItemMeta daMeta = da.getItemMeta();

        ItemStack db = new ItemStack(Material.ENDER_PEARL);
        ItemMeta dbMeta = db.getItemMeta();

        ItemStack ga = new ItemStack(Material.GRASS);
        ItemMeta gaMeta = ga.getItemMeta();

        ItemStack gb = new ItemStack(Material.GRASS);
        ItemMeta gbMeta = gb.getItemMeta();

        ItemStack gc = new ItemStack(Material.GRASS);
        ItemMeta gcMeta = gc.getItemMeta();

        ItemStack ha = new ItemStack(Material.GRASS);
        ItemMeta haMeta = ha.getItemMeta();

        ItemStack hb = new ItemStack(Material.GRASS);
        ItemMeta hbMeta = hb.getItemMeta();

        ItemStack hc = new ItemStack(Material.GRASS);
        ItemMeta hcMeta = hc.getItemMeta();

        ItemStack ja = new ItemStack(Material.GRASS);
        ItemMeta jaMeta = ja.getItemMeta();

        ItemStack jb = new ItemStack(Material.GRASS);
        ItemMeta jbMeta = jb.getItemMeta();

        ItemStack jc = new ItemStack(Material.GRASS);
        ItemMeta jcMeta = jc.getItemMeta();

        ItemStack fa = new ItemStack(Material.GRASS);
        ItemMeta faMeta = fa.getItemMeta();

        ItemStack fb = new ItemStack(Material.ENDER_PEARL);
        ItemMeta fbMeta = fa.getItemMeta();

        ItemStack fc = new ItemStack(Material.GRASS);
        ItemMeta fcMeta = fa.getItemMeta();

        ItemStack jh = new ItemStack(Material.DIRT);
        ItemMeta jhMeta = jc.getItemMeta();

        ItemStack ff = new ItemStack(Material.GRASS);
        ItemMeta ffMeta = ff.getItemMeta();

        ItemStack fd = new ItemStack(Material.DIRT);
        ItemMeta fdMeta = fd.getItemMeta();

        //-----------------------------------------------------------------------------
        if (p.getConfig().getString("Settings.Language").equalsIgnoreCase("en")){

            aaMeta.setDisplayName(ChatColor.GREEN + "Welcome Title");
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Join title");
            lore.add("Status: "+ disabled);
            lore.add(disabled2);
            aaMeta.setLore(lore);
            aa.setItemMeta(aaMeta);

            gaMeta.setDisplayName(ChatColor.GREEN + "Welcome Title");
            ArrayList<String> lore1 = new ArrayList<>();
            lore1.add(ChatColor.GRAY + "Join title");
            lore1.add("Status: "+ enabled);
            lore1.add(disabled2);
            gaMeta.setLore(lore1);
            ga.setItemMeta(gaMeta);

            gbMeta.setDisplayName(ChatColor.GREEN + "Teleport to Spawn on Join");
            ArrayList<String> lore4 = new ArrayList<>();
            lore4.add(ChatColor.GRAY + "Teleport player to Spawn on Join");
            lore4.add("Status: "+ enabled);
            lore4.add(disabled2);
            gbMeta.setLore(lore4);
            gb.setItemMeta(gbMeta);

            abMeta.setDisplayName(ChatColor.GREEN + "Teleport to Spawn on Join");
            ArrayList<String> lore3 = new ArrayList<>();
            lore3.add(ChatColor.GRAY + "Teleport player to Spawn on Join");
            lore3.add("Status: "+ disabled);
            lore3.add(disabled2);
            abMeta.setLore(lore3);
            ab.setItemMeta(abMeta);

            acMeta.setDisplayName(ChatColor.GREEN + "Block Placement");
            ArrayList<String> lore5 = new ArrayList<>();
            lore5.add(ChatColor.GRAY + "Prevents block placement");
            lore5.add("Status: " + disabled);
            lore5.add(disabled2);
            acMeta.setLore(lore5);
            ac.setItemMeta(acMeta);

            baMeta.setDisplayName(ChatColor.GREEN + "Block Break");
            ArrayList<String> lore7 = new ArrayList<>();
            lore7.add(ChatColor.GRAY + "Prevents block breaking");
            lore7.add("Status: " + disabled);
            lore7.add(disabled2);
            baMeta.setLore(lore7);
            ba.setItemMeta(baMeta);

            bbMeta.setDisplayName(ChatColor.GREEN + "Item Pickup");
            ArrayList<String> lore9 = new ArrayList<>();
            lore9.add(ChatColor.GRAY + "Prevents item pickup");
            lore9.add("Status: " + disabled);
            lore9.add(disabled2);
            bbMeta.setLore(lore9);
            bb.setItemMeta(bbMeta);

            bcMeta.setDisplayName(ChatColor.GREEN + "Item Drop");
            ArrayList<String> lore11 = new ArrayList<>();
            lore11.add(ChatColor.GRAY + "Prevents item dropping");
            lore11.add("Status: " + disabled);
            lore11.add(disabled2);
            bcMeta.setLore(lore11);
            bc.setItemMeta(bcMeta);

            cdMeta.setDisplayName(ChatColor.GREEN + "Interaction");
            ArrayList<String> lore21 = new ArrayList<>();
            lore21.add(ChatColor.GRAY + "Prevents interaction with items");
            lore21.add(ChatColor.GRAY + "and blocks.");
            lore21.add("Status: " + disabled);
            lore21.add(disabled2);
            cdMeta.setLore(lore21);
            cd.setItemMeta(cdMeta);

            caMeta.setDisplayName(ChatColor.GREEN + "PvP (Combat)");
            ArrayList<String> lore13 = new ArrayList<>();
            lore13.add(ChatColor.GRAY + "Prevents PvP");
            lore13.add("Status: " + disabled);
            lore13.add(disabled2);
            caMeta.setLore(lore13);
            ca.setItemMeta(caMeta);

            cbMeta.setDisplayName(ChatColor.GREEN + "Mob Spawning");
            ArrayList<String> lore15 = new ArrayList<>();
            lore15.add(ChatColor.GRAY + "Prevents mob spawning");
            lore15.add("Status: " + disabled);
            lore15.add(disabled2);
            cbMeta.setLore(lore15);
            cb.setItemMeta(cbMeta);

            ccMeta.setDisplayName(ChatColor.GREEN + "Chat Usage");
            ArrayList<String> lore17 = new ArrayList<>();
            lore17.add(ChatColor.GRAY + "Disables chat for players");
            lore17.add("Status: " + disabled);
            lore17.add(disabled2);
            ccMeta.setLore(lore17);
            cc.setItemMeta(ccMeta);

            daMeta.setDisplayName(ChatColor.GREEN + "Set Spawn Area");
            ArrayList<String> lore19 = new ArrayList<>();
            lore19.add("Sets the spawn point");
            lore19.add(ChatColor.YELLOW + "Right/Left Click!");
            daMeta.setLore(lore19);
            da.setItemMeta(daMeta);

            dbMeta.setDisplayName(ChatColor.GREEN + "Add Protected World");
            ArrayList<String> lore25 = new ArrayList<>();
            lore25.add("Configure protected worlds");
            lore25.add(ChatColor.YELLOW + "Click to add!");
            dbMeta.setLore(lore25);
            db.setItemMeta(dbMeta);

            fbMeta.setDisplayName(ChatColor.GREEN + "Language");
            ArrayList<String> lore30 = new ArrayList<>();
            lore30.add("Changes the language");
            lore30.add("Selected language: " + ChatColor.GREEN + p.getConfig().getString("Settings.Language"));
            lore30.add(ChatColor.YELLOW + "Click to change!");
            fbMeta.setLore(lore30);
            fb.setItemMeta(fbMeta);

            jhMeta.setDisplayName(ChatColor.GREEN + "Daylight Cycle");
            ArrayList<String> lore34 = new ArrayList<>();
            lore34.add(ChatColor.GRAY + "Toggles the daylight cycle");
            lore34.add("Status: " + disabled);
            lore34.add(disabled2);
            jhMeta.setLore(lore34);
            jh.setItemMeta(jhMeta);

            fdMeta.setDisplayName(ChatColor.GREEN + "Weather Cycle");
            ArrayList<String> lore38 = new ArrayList<>();
            lore38.add(ChatColor.GRAY + "Toggles the weather cycle");
            lore38.add("Status: " + disabled);
            lore38.add(disabled2);
            fdMeta.setLore(lore38);
            fd.setItemMeta(fdMeta);


            gcMeta.setDisplayName(ChatColor.GREEN + "Block Placement");
            ArrayList<String> lore6 = new ArrayList<>();
            lore6.add(ChatColor.GRAY + "Prevents block placement.");
            lore6.add("Status: " + enabled);
            lore6.add(enabled2);
            gcMeta.setLore(lore6);
            gc.setItemMeta(gcMeta);

            haMeta.setDisplayName(ChatColor.GREEN + "Block Break");
            ArrayList<String> lore2 = new ArrayList<>();
            lore2.add(ChatColor.GRAY + "Prevents block breaking.");
            lore2.add("Status: " + enabled);
            lore2.add(enabled2);
            haMeta.setLore(lore2);
            ha.setItemMeta(haMeta);

            hbMeta.setDisplayName(ChatColor.GREEN + "Item Pickup");
            ArrayList<String> lore8 = new ArrayList<>();
            lore8.add(ChatColor.GRAY + "Prevents item pickup.");
            lore8.add("Status: " + enabled);
            lore8.add(enabled2);
            hbMeta.setLore(lore8);
            hb.setItemMeta(hbMeta);

            hcMeta.setDisplayName(ChatColor.GREEN + "Item Drop");
            ArrayList<String> lore10 = new ArrayList<>();
            lore10.add(ChatColor.GRAY + "Prevents item dropping.");
            lore10.add("Status: " + enabled);
            lore10.add(enabled2);
            hcMeta.setLore(lore10);
            hc.setItemMeta(hcMeta);

            faMeta.setDisplayName(ChatColor.GREEN + "Interaction");
            ArrayList<String> lore20 = new ArrayList<>();
            lore20.add(ChatColor.GRAY + "Prevents interaction with items");
            lore20.add(ChatColor.GRAY + "and blocks.");
            lore20.add("Status: " + enabled);
            lore20.add(enabled2);
            faMeta.setLore(lore20);
            fa.setItemMeta(faMeta);

            jaMeta.setDisplayName(ChatColor.GREEN + "PvP (Combat)");
            ArrayList<String> lore12 = new ArrayList<>();
            lore12.add(ChatColor.GRAY + "Prevents PvP.");
            lore12.add("Status: " + enabled);
            lore12.add(enabled2);
            jaMeta.setLore(lore12);
            ja.setItemMeta(jaMeta);

            jbMeta.setDisplayName(ChatColor.GREEN + "Mob Spawning");
            ArrayList<String> lore22 = new ArrayList<>();
            lore22.add(ChatColor.GRAY + "Prevents mob spawning.");
            lore22.add("Status: " + enabled);
            lore22.add(enabled2);
            jbMeta.setLore(lore22);
            jb.setItemMeta(jbMeta);

            jcMeta.setDisplayName(ChatColor.GREEN + "Chat Usage");
            ArrayList<String> lore24 = new ArrayList<>();
            lore24.add(ChatColor.GRAY + "Disables chat for players.");
            lore24.add("Status: " + enabled);
            lore24.add(enabled2);
            jcMeta.setLore(lore24);
            jc.setItemMeta(jcMeta);

            fcMeta.setDisplayName(ChatColor.GREEN + "Daylight Cycle");
            ArrayList<String> lore32 = new ArrayList<>();
            lore32.add(ChatColor.GRAY + "Toggles the daylight cycle.");
            lore32.add("Status: " + enabled);
            lore32.add(enabled2);
            fcMeta.setLore(lore32);
            fc.setItemMeta(fcMeta);

            ffMeta.setDisplayName(ChatColor.GREEN + "Weather Cycle");
            ArrayList<String> lore36 = new ArrayList<>();
            lore36.add(ChatColor.GRAY + "Toggles the weather cycle.");
            lore36.add("Status: " + enabled);
            lore.add(enabled2);
            ffMeta.setLore(lore36);
            ff.setItemMeta(ffMeta);




            player.openInventory(inv);

            if (p.getConfig().getString("Join.TitleEnabled").equals("true")){
                inv.setItem(10, ga);
            }

            else if(p.getConfig().getString("Join.TitleEnabled").equals("false")){
                inv.setItem(10, aa);
            }

            if (p.getConfig().getString("Spawn.SendToSpawn").equals("true")){
                inv.setItem(11, gb);
            }

            else if (p.getConfig().getString("Spawn.SendToSpawn").equals("false")){
                inv.setItem(11, ab);
            }

            if(p.getConfig().getString("Settings.spawn.pickup").equals("allow")) {
                inv.setItem(12, bb);
            }

            else if (p.getConfig().getString("Settings.spawn.pickup").equals("deny")){
                inv.setItem(12, hb);
            }

            if(p.getConfig().getString("Settings.spawn.drop").equals("allow")){
                inv.setItem(13, bc);
            }

            else if (p.getConfig().getString("Settings.spawn.drop").equals("deny")){
                inv.setItem(13, hc);
            }

            if(p.getConfig().getString("Settings.spawn.place").equals("allow")){
                inv.setItem(14, ac);

            }

            else if (p.getConfig().getString("Settings.spawn.place").equals("deny")){
                inv.setItem(14, gc);
            }

            if(p.getConfig().getString("Settings.spawn.break").equals("allow")){
                inv.setItem(15, ba);
            }

            else if (p.getConfig().getString("Settings.spawn.break").equals("deny")){
                inv.setItem(15, ha);
            }


            if(p.getConfig().getString("Settings.spawn.use").equals("allow")){
                inv.setItem(16, cd);
            }

            else if (p.getConfig().getString("Settings.spawn.use").equals("deny")){
                inv.setItem(16, fa);
            }

            if(p.getConfig().getString("Settings.spawn.pvp").equals("allow")){
                inv.setItem(19, ca);
            }

            else if (p.getConfig().getString("Settings.spawn.pvp").equals("deny")){
                inv.setItem(19, ja);
            }

            if(p.getConfig().getString("Settings.spawn.mobspawn").equals("allow")){
                inv.setItem(20, cb);

            }
            else if (p.getConfig().getString("Settings.spawn.mobspawn").equals("deny")){
                inv.setItem(20, jb);

            }
            if(p.getConfig().getString("Settings.spawn.chat").equals("allow")){
                inv.setItem(21, cc);

            }
            else if (p.getConfig().getString("Settings.spawn.chat").equals("deny")){
                inv.setItem(21, jc);
            }
            if(p.getConfig().getString("Settings.DaylightCycle").equals("allow")){
                inv.setItem(22, jh);

            }
            else if (p.getConfig().getString("Settings.DaylightCycle").equals("deny")){
                inv.setItem(22, fc);
            }
            if(p.getConfig().getString("Settings.WeatherChange").equals("allow")){
                inv.setItem(23, fd);

            }
            else if (p.getConfig().getString("Settings.WeatherChange").equals("deny")){
                inv.setItem(23, ff);
            }
            inv.setItem(40 , da);
            inv.setItem(39 , db);
            inv.setItem(41 , fb);
        }
        else{


        aaMeta.setDisplayName(ChatColor.GREEN + "Giriş Yazısı");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Girişte ekrana çıkan yazı");
        lore.add("Durum: "+ devredisi);
        lore.add(devredisi2);
        aaMeta.setLore(lore);
        aa.setItemMeta(aaMeta);

        abMeta.setDisplayName(ChatColor.GREEN + "Girişte Spawn'a Işınlama");
        ArrayList<String> lore3 = new ArrayList<>();
        lore3.add(ChatColor.GRAY + "Girişte spawn bölgesine ışınlanma");
        lore3.add("Durum: "+ devredisi);
        lore3.add(devredisi2);
        abMeta.setLore(lore3);
        ab.setItemMeta(abMeta);

        acMeta.setDisplayName(ChatColor.GREEN + "Blok Koyma");
        ArrayList<String> lore5 = new ArrayList<>();
        lore5.add(ChatColor.GRAY + "Blok koymayı engeller");
        lore5.add("Durum: "+ devredisi);
        lore5.add(devredisi2);
        acMeta.setLore(lore5);
        ac.setItemMeta(acMeta);

        baMeta.setDisplayName(ChatColor.GREEN + "Blok Kırma");
        ArrayList<String> lore7 = new ArrayList<>();
        lore7.add(ChatColor.GRAY + "Blok kırmayı engeller");
        lore7.add("Durum: "+ devredisi);
        lore7.add(devredisi2);
        baMeta.setLore(lore7);
        ba.setItemMeta(baMeta);

        bbMeta.setDisplayName(ChatColor.GREEN + "Eşya Alma");
        ArrayList<String> lore9 = new ArrayList<>();
        lore9.add(ChatColor.GRAY + "Yerden eşya almayı engeller");
        lore9.add("Durum: "+ devredisi);
        lore9.add(devredisi2);
        bbMeta.setLore(lore9);
        bb.setItemMeta(bbMeta);

        bcMeta.setDisplayName(ChatColor.GREEN + "Eşya Atma");
        ArrayList<String> lore11 = new ArrayList<>();
        lore11.add(ChatColor.GRAY + "Yere eşya atmayı engeller");
        lore11.add("Durum: "+ devredisi);
        lore11.add(devredisi2);
        bcMeta.setLore(lore11);
        bc.setItemMeta(bcMeta);

        cdMeta.setDisplayName(ChatColor.GREEN + "Etkileşim");
        ArrayList<String> lore21 = new ArrayList<>();
        lore21.add(ChatColor.GRAY + "Eşyalarla etkileşime geçmeyi");
        lore21.add(ChatColor.GRAY + "engeller.");
        lore21.add("Durum: "+ devredisi);
        lore21.add(devredisi2);
        cdMeta.setLore(lore21);
        cd.setItemMeta(cdMeta);

        caMeta.setDisplayName(ChatColor.GREEN + "PvP (Dövüş)");
        ArrayList<String> lore13 = new ArrayList<>();
        lore13.add(ChatColor.GRAY + "PvP'yi engeller.");
        lore13.add("Durum: "+ devredisi);
        lore13.add(devredisi2);
        caMeta.setLore(lore13);
        ca.setItemMeta(caMeta);

        cbMeta.setDisplayName(ChatColor.GREEN + "Yaratık Doğması");
        ArrayList<String> lore15 = new ArrayList<>();
        lore15.add(ChatColor.GRAY + "Yaratık doğmasını engeller.");
        lore15.add("Durum: "+ devredisi);
        lore15.add(devredisi2);
        cbMeta.setLore(lore15);
        cb.setItemMeta(cbMeta);

        ccMeta.setDisplayName(ChatColor.GREEN + "Sohbet Kullanma");
        ArrayList<String> lore17 = new ArrayList<>();
        lore17.add(ChatColor.GRAY + "Sohbeti oyunculara kapatır.");
        lore17.add("Durum: "+ devredisi);
        lore17.add(devredisi2);
        ccMeta.setLore(lore17);
        cc.setItemMeta(ccMeta);

        daMeta.setDisplayName(ChatColor.GREEN + "Spawn Bölgesi Ayarla");
        ArrayList<String> lore19 = new ArrayList<>();
        lore19.add("Spawn noktası ayarlar");
        lore19.add(ChatColor.YELLOW + "Sol/Sağ Tıkla!");
        daMeta.setLore(lore19);
        da.setItemMeta(daMeta);

        dbMeta.setDisplayName(ChatColor.GREEN + "Korunacak Dünya Ekle");
        ArrayList<String> lore25 = new ArrayList<>();
        lore25.add("Korunacak Dünyaları Ayarla");
        lore25.add(ChatColor.YELLOW + "Eklemek için tıkla!");
        dbMeta.setLore(lore25);
        db.setItemMeta(dbMeta);

        fbMeta.setDisplayName(ChatColor.GREEN + "Dil");
        ArrayList<String> lore30 = new ArrayList<>();
        lore30.add("Dili değiştirir");
        lore30.add("Seçili dil: "+ ChatColor.GREEN + p.getConfig().getString("Settings.Language"));
        lore30.add(ChatColor.YELLOW + "Değiştirmek için tıkla!");
        fbMeta.setLore(lore30);
        fb.setItemMeta(fbMeta);

        jhMeta.setDisplayName(ChatColor.GREEN + "Gün Döngüsü");
        ArrayList<String> lore34 = new ArrayList<>();
        lore34.add(ChatColor.GRAY + "Gün Döngüsünü Açar/Kapatır.");
        lore34.add("Durum: "+ devredisi);
        lore34.add(devredisi2);
        jhMeta.setLore(lore34);
        jh.setItemMeta(jhMeta);

        fdMeta.setDisplayName(ChatColor.GREEN + "Hava Döngüsü");
        ArrayList<String> lore38 = new ArrayList<>();
        lore38.add(ChatColor.GRAY + "Gün Döngüsünü Açar/Kapatır.");
        lore38.add("Durum: "+ devredisi);
        lore38.add(devredisi2);
        fdMeta.setLore(lore38);
        fd.setItemMeta(fdMeta);

        //------------------------------------------------------------------------
        gaMeta.setDisplayName(ChatColor.GREEN + "Giriş Yazısı");
        ArrayList<String> lore1 = new ArrayList<>();
        lore1.add(ChatColor.GRAY + "Girişte ekrana çıkan yazı");
        lore1.add("Durum: "+ aktif);
        lore1.add(aktif2);
        gaMeta.setLore(lore1);
        ga.setItemMeta(gaMeta);

        gbMeta.setDisplayName(ChatColor.GREEN + "Girişte Spawn'a Işınlama");
        ArrayList<String> lore4 = new ArrayList<>();
        lore4.add(ChatColor.GRAY + "Girişte spawn bölgesine ışınlanma");
        lore4.add("Durum: "+ aktif);
        lore4.add(aktif2);
        gbMeta.setLore(lore4);
        gb.setItemMeta(gbMeta);

        gcMeta.setDisplayName(ChatColor.GREEN + "Blok Koyma");
        ArrayList<String> lore6 = new ArrayList<>();
        lore6.add(ChatColor.GRAY + "Blok koymayı engeller.");
        lore6.add("Durum: "+ aktif);
        lore6.add(aktif2);
        gcMeta.setLore(lore6);
        gc.setItemMeta(gcMeta);

        haMeta.setDisplayName(ChatColor.GREEN + "Blok Kırma");
        ArrayList<String> lore2 = new ArrayList<>();
        lore2.add(ChatColor.GRAY + "Blok kırmayı engeller.");
        lore2.add("Durum: "+ aktif);
        lore2.add(aktif2);
        haMeta.setLore(lore2);
        ha.setItemMeta(haMeta);

        hbMeta.setDisplayName(ChatColor.GREEN + "Eşya Alma");
        ArrayList<String> lore8 = new ArrayList<>();
        lore8.add(ChatColor.GRAY + "Yerden eşya almayı engeller.");
        lore8.add("Durum: "+ aktif);
        lore8.add(aktif2);
        hbMeta.setLore(lore8);
        hb.setItemMeta(hbMeta);

        hcMeta.setDisplayName(ChatColor.GREEN + "Eşya Atma");
        ArrayList<String> lore10 = new ArrayList<>();
        lore10.add(ChatColor.GRAY + "Yere eşya atmayı engeller.");
        lore10.add("Durum: "+ aktif);
        lore10.add(aktif2);
        hcMeta.setLore(lore8);
        hc.setItemMeta(hcMeta);

        faMeta.setDisplayName(ChatColor.GREEN + "Etkileşim");
        ArrayList<String> lore20 = new ArrayList<>();
        lore20.add(ChatColor.GRAY + "Eşyalarla etkileşime geçmeyi");
        lore20.add(ChatColor.GRAY + "engeller.");
        lore20.add("Durum: "+ aktif);
        lore20.add(aktif2);
        faMeta.setLore(lore20);
        fa.setItemMeta(faMeta);

        jaMeta.setDisplayName(ChatColor.GREEN + "PvP (Dövüş)");
        ArrayList<String> lore12 = new ArrayList<>();
        lore12.add(ChatColor.GRAY + "PvP'yi engeller.");
        lore12.add("Durum: "+ aktif);
        lore12.add(aktif2);
        jaMeta.setLore(lore12);
        ja.setItemMeta(jaMeta);

        jbMeta.setDisplayName(ChatColor.GREEN + "Yaratık Doğması");
        ArrayList<String> lore22 = new ArrayList<>();
        lore22.add(ChatColor.GRAY + "Yaratık doğmasını engeller.");
        lore22.add("Durum: "+ aktif);
        lore22.add(aktif2);
        jbMeta.setLore(lore22);
        jb.setItemMeta(jbMeta);

        jcMeta.setDisplayName(ChatColor.GREEN + "Sohbet Kullanma");
        ArrayList<String> lore24 = new ArrayList<>();
        lore24.add(ChatColor.GRAY + "Sohbeti oyunculara kapatır.");
        lore24.add("Durum: "+ aktif);
        lore24.add(aktif2);
        jcMeta.setLore(lore24);
        jc.setItemMeta(jcMeta);

        fcMeta.setDisplayName(ChatColor.GREEN + "Gün Döngüsü");
        ArrayList<String> lore32 = new ArrayList<>();
        lore32.add(ChatColor.GRAY + "Hava Döngüsünü Açar/Kapatır.");
        lore32.add("Durum: "+ aktif);
        lore32.add(aktif2);
        fcMeta.setLore(lore32);
        fc.setItemMeta(fcMeta);

        ffMeta.setDisplayName(ChatColor.GREEN + "Hava Döngüsü");
        ArrayList<String> lore36 = new ArrayList<>();
        lore36.add(ChatColor.GRAY + "Hava Döngüsünü Açar/Kapatır.");
        lore36.add("Durum: "+ aktif);
        lore36.add(aktif2);
        ffMeta.setLore(lore36);
        ff.setItemMeta(ffMeta);

        player.openInventory(inv);



        //---------------------------------------------------------------------------

        if (p.getConfig().getString("Join.TitleEnabled").equals("true")){
            inv.setItem(10, ga);
        }

        else if(p.getConfig().getString("Join.TitleEnabled").equals("false")){
            inv.setItem(10, aa);
        }

        if (p.getConfig().getString("Spawn.SendToSpawn").equals("true")){
            inv.setItem(11, gb);
        }

        else if (p.getConfig().getString("Spawn.SendToSpawn").equals("false")){
            inv.setItem(11, ab);
        }

        if(p.getConfig().getString("Settings.spawn.pickup").equals("allow")) {
            inv.setItem(12, bb);
        }

        else if (p.getConfig().getString("Settings.spawn.pickup").equals("deny")){
            inv.setItem(12, hb);
        }

        if(p.getConfig().getString("Settings.spawn.drop").equals("allow")){
            inv.setItem(13, bc);
        }

        else if (p.getConfig().getString("Settings.spawn.drop").equals("deny")){
            inv.setItem(13, hc);
        }

        if(p.getConfig().getString("Settings.spawn.place").equals("allow")){
            inv.setItem(14, ac);

        }

        else if (p.getConfig().getString("Settings.spawn.place").equals("deny")){
            inv.setItem(14, gc);
        }

        if(p.getConfig().getString("Settings.spawn.break").equals("allow")){
            inv.setItem(15, ba);
        }

        else if (p.getConfig().getString("Settings.spawn.break").equals("deny")){
            inv.setItem(15, ha);
        }


        if(p.getConfig().getString("Settings.spawn.use").equals("allow")){
            inv.setItem(16, cd);
        }

        else if (p.getConfig().getString("Settings.spawn.use").equals("deny")){
            inv.setItem(16, fa);
        }

        if(p.getConfig().getString("Settings.spawn.pvp").equals("allow")){
            inv.setItem(19, ca);
        }

        else if (p.getConfig().getString("Settings.spawn.pvp").equals("deny")){
            inv.setItem(19, ja);
        }

        if(p.getConfig().getString("Settings.spawn.mobspawn").equals("allow")){
            inv.setItem(20, cb);

        }
        else if (p.getConfig().getString("Settings.spawn.mobspawn").equals("deny")){
            inv.setItem(20, jb);

        }
        if(p.getConfig().getString("Settings.spawn.chat").equals("allow")){
            inv.setItem(21, cc);

        }
        else if (p.getConfig().getString("Settings.spawn.chat").equals("deny")){
            inv.setItem(21, jc);
        }
        if(p.getConfig().getString("Settings.DaylightCycle").equals("allow")){
            inv.setItem(22, jh);

        }
        else if (p.getConfig().getString("Settings.DaylightCycle").equals("deny")){
            inv.setItem(22, fc);
        }
        if(p.getConfig().getString("Settings.WeatherChange").equals("allow")){
            inv.setItem(23, fd);

        }
        else if (p.getConfig().getString("Settings.WeatherChange").equals("deny")){
            inv.setItem(23, ff);
        }

        inv.setItem(40 , da);
        inv.setItem(39 , db);
        inv.setItem(41 , fb);
        }
        }

    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        Player player = (Player) sender;
        if(commandLabel.equalsIgnoreCase("epgui")){
            if (player.hasPermission(p.getConfig().getString("Settings.spawn.adminperm"))){
                openGui(player);
            }
        }
        if(commandLabel.equalsIgnoreCase("ep")){
            if (player.hasPermission(p.getConfig().getString("Settings.spawn.adminperm"))){
                openGui(player);
            }
        }
        return true;
    }


}
