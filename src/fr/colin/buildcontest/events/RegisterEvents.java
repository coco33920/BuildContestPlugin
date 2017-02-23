package fr.colin.buildcontest.events;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

/**
 * Created by colin on 23/02/2017.
 */
public class RegisterEvents {


    public RegisterEvents(Plugin plugin, Listener... listeners){


        PluginManager pm = Bukkit.getPluginManager();
        for(Listener listener : listeners){


            pm.registerEvents(listener, plugin);

        }

    }


}
