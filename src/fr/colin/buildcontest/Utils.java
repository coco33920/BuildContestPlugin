package fr.colin.buildcontest;

import fr.colin.buildcontest.scoreboard.ScoreboardGame;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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
    private static Location lobby = new Location(w, -263.5, 32, 418.5);
    private static Location spawn_1 =  new Location(w, -233.5, 8, -32.5);
    private static Location spawn_2 =  new Location(w, -233.5, 8, 37.5);
    private static Location spawn_3 =  new Location(w, -233.5, 8, 107.5);
    private static Location spawn_4 =  new Location(w, -233.5, 8, 177.5);
    private static Location spawn_5 =  new Location(w, -233.5, 8, 247.5);
    private static Location spawn_6 =  new Location(w, -233.5, 8, 317.5);
    private static List<Location> locationsList = new ArrayList<>();



    public static Location getLobby() {
        return lobby;
    }

    public static List<Location> getLocations() {


        return locationsList;
    }
    public static void fillLocationList(){
        locationsList.add(spawn_1);
        locationsList.add(spawn_2);
        locationsList.add(spawn_3);
        locationsList.add(spawn_4);
        locationsList.add(spawn_5);
        locationsList.add(spawn_6);
    }

    public static void randomTp() {
      fillLocationList();

        int players = Bukkit.getOnlinePlayers().size();
       if (players < 3) {
            for (Player player : Bukkit.getOnlinePlayers()) {

                if (player.isOp()) {
                    player.sendMessage("§cIl n'y a pas assez de joueur pour commencer la partie :) ");
                }


            }


            return;
        } else {
            int i = 0;

           for (Player player : Bukkit.getOnlinePlayers()) {

               if (!player.getName().equalsIgnoreCase("coco33920")) {
                   player.teleport(locationsList.get(i));
                    i++;

                    for(Player player1 : Bukkit.getOnlinePlayers()){
                        if(player1.isOp()){
                            player1.sendMessage("§cMap : §a" + i + " §cJoueur : " + "§a " + player.getName());
                            BuildContest.getInstance().playerMaps.put(player, i);
                        }
                    }
               }
           }
           GameState.setCurrentState(GameState.INGAME);
       }


    }

    public static String getPrefix(Player player){


        Rank rank = PlayerAccounts.getInstance().getPlayerRank(player);
        String prefix = "§" + rank.getColor() + "[" + rank.getDisplayName() + "]";

        return prefix;



    }




}
