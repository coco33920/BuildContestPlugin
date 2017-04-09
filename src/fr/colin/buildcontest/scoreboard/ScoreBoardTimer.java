package fr.colin.buildcontest.scoreboard;

import fr.colin.buildcontest.BuildContest;
import fr.colin.buildcontest.GameState;
import fr.colin.buildcontest.Utils;
import fr.colin.buildcontest.VariableUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * Created by colin on 23/02/2017.
 */
public class ScoreboardTimer {
    private static ScoreboardTimer ourInstance = new ScoreboardTimer();

    public static ScoreboardTimer getInstance() {
        return ourInstance;
}

    private ScoreboardTimer() {
    }

    private int task_libre;
    private int task_impose;
    //public int time_libre = VariableUtils.getInstance().getVariable("TIME_LIBRE");
    //public int time_impose = VariableUtils.getInstance().getVariable("TIME_IMPOSE");

    public int time_libre = 421;
    public int time_impose = 301;

    public void loadScoreboardTimeLibre() {


        task_libre = Bukkit.getScheduler().scheduleSyncRepeatingTask(BuildContest.getInstance(), new Runnable() {
            @Override
            public void run() {

                time_libre--;
                if(time_libre == 420){
                    ScoreboardGame.scoreboardLibre();
                }
                if (time_libre <= 420 && time_libre > 0) {
                    ScoreboardGame.resetTimeScoreboardLibre();
                    ScoreboardGame.updateTimeScoreboardLibre();
                }
                if (time_libre == 300) {
                    Bukkit.broadcastMessage("§cIl vous reste §a5 minutes !");
                }
                if (time_libre == 180) {
                    Bukkit.broadcastMessage("§cIl vous reste §a3 minutes !");
                }
                if (time_libre == 60) {
                    Bukkit.broadcastMessage("§cIl vous reste §a1 minutes !");
                }
                if (time_libre == 30) {
                    Bukkit.broadcastMessage("§cIl vous reste §a30 secondes !");
                }
                if (time_libre <= 10 && time_libre > 0) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.playSound(player.getLocation(), Sound.NOTE_PLING, 100, 100);
                    }
                    Bukkit.broadcastMessage("§cIl vous reste §a " + time_libre + " secondes !");
                }
                if (time_libre == 0) {
                    Bukkit.broadcastMessage("§cLa partie est terminée !");
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.teleport(Utils.getLobby());
                        Bukkit.getScheduler().cancelTask(task_libre);
                        GameState.setCurrentState(GameState.LOBBY);
                        ScoreboardLobby.generate(player);
                    }
                }


            }
        }, 20, 20);


    }


    public void loadScoreboardTimeImpose(String string) {


        task_impose = Bukkit.getScheduler().scheduleSyncRepeatingTask(BuildContest.getInstance(), new Runnable() {

            @Override
            public void run() {

                String to = string;
                if(string == null){
                    to = "Erreur";
                }
                time_impose--;
                if(time_impose == 300){
                    ScoreboardGame.scoreboardImpose(to);
                }
                if (time_impose <= 300 && time_impose > 0) {
                    ScoreboardGame.resetTimeScoreboardImpose();
                    ScoreboardGame.updateTimeScoreboardImpose();
                }
                if (time_impose == 180) {
                    Bukkit.broadcastMessage("§cIl vous reste §a3 minutes !");
                }
                if (time_impose == 60) {
                    Bukkit.broadcastMessage("§cIl vous reste §a1 minutes !");
                }
                if (time_impose == 30) {
                    Bukkit.broadcastMessage("§cIl vous reste §a30 secondes !");
                }
                if (time_impose <= 10 && time_impose > 0) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.playSound(player.getLocation(), Sound.NOTE_PLING, 100, 100);
                    }
                    Bukkit.broadcastMessage("§cIl vous reste §a " + time_impose + " secondes !");
                }
                if (time_impose == 0) {
                    Bukkit.broadcastMessage("§cLa partie est terminée !");
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.teleport(Utils.getLobby());
                        Bukkit.getScheduler().cancelTask(task_impose);
                        GameState.setCurrentState(GameState.LOBBY);
                        ScoreboardLobby.generate(player);


                    }
                }


            }
        }, 20, 20);


    }


}
