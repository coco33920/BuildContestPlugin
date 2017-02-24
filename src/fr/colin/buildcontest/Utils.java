package fr.colin.buildcontest;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by colin on 23/02/2017.
 */
public class Utils {
    private static World w = Bukkit.getWorlds().get(0);
    private static Location lobby = new Location(w, -274, 4, 359);
    private static Location spawn_1 =  new Location(w, -275, 4, 360);
    private static Location spawn_2 =  new Location(w, -276, 4, 361);
    private static Location spawn_3 =  new Location(w, -277, 4, 362);
    private static Location spawn_4 =  new Location(w, -278, 4, 363);
    private static Location spawn_5 =  new Location(w, -279, 4, 364);
    private static Location spawn_6 =  new Location(w, -280, 4, 365);
    private static List<Location> locationsList = new ArrayList<>();


    static {
        locationsList.add(spawn_1);
        locationsList.add(spawn_2);
        locationsList.add(spawn_3);
        locationsList.add(spawn_4);
        locationsList.add(spawn_5);
        locationsList.add(spawn_6);
    }

    public static Location getLobby() {
        return lobby;
    }

    public static List<Location> getLocations() {


        return locationsList;
    }

    public static void randomTp() {


        int players = Bukkit.getOnlinePlayers().size();
        if (players < 3) {
            for (Player player : Bukkit.getOnlinePlayers()) {

                if (player.isOp()) {
                    player.sendMessage("§cIl n'y a pas assez de joueur pour commencer la partie :) ");
                }


            }


            return;
        } else {
            ArrayList<Player> players1 = new ArrayList<>();
            for(Player player : Bukkit.getOnlinePlayers()){
                players1.add(player);
            }
           for(int i = 0; i < locationsList.size(); i++){
               players1.get(i).teleport(locationsList.get(i));
               players1.remove(i);
                locationsList.remove(i);
           }
        }


    }

}
