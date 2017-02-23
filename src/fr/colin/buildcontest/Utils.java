package fr.colin.buildcontest;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.Arrays;
import java.util.List;

/**
 * Created by colin on 23/02/2017.
 */
public class Utils {
    private static World w = Bukkit.getWorlds().get(0);
    private static Location lobby = new Location(w, -274, 4, 359);
    private static Location spawn_1;
    private static Location spawn_2;
    private static Location spawn_3;
    private static Location spawn_4;
    private static Location spawn_5;
    private static Location spawn_6;



    public static Location getLobby() {
        return lobby;
    }

    public static List<Location> getLocations() {
        List<Location> locationList = Arrays.asList(spawn_1, spawn_2, spawn_3, spawn_4, spawn_5, spawn_6);
        return locationList;
    }
}
