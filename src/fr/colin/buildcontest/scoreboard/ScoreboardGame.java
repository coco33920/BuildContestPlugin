package fr.colin.buildcontest.scoreboard;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by colin on 23/02/2017.
 */
public class ScoreboardGame {
    private static ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
   private static Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
   private static Objective objective = scoreboard.registerNewObjective("§cBuild Contest", "dummy");

        public static void scoreboardLibre(){
            for(Player player : Bukkit.getOnlinePlayers()) {

                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                objective.setDisplayName("§cBuild Contest");
                Score score = objective.getScore("§c ");
                score.setScore(8);
                Score score1 = objective.getScore("§cStatut : §aEn Jeu");
                score1.setScore(7);
                Score score2 = objective.getScore("§a ");
                score2.setScore(6);
                Score score3 = objective.getScore("§cThème principal : §aLibre !");
                score3.setScore(5);
                Score score4 = objective.getScore("§b ");
                score4.setScore(4);
                Score score5 = objective.getScore("§cLibre !");
                score5.setScore(3);
                Score score6 = objective.getScore("§5 ");
                score6.setScore(2);
                long time = ScoreboardTimer.getInstance().time_libre * 1000;
                String date = new SimpleDateFormat("m:ss").format(new Date(time));
                Score score7 = objective.getScore("§cTemps restant : §a" + date);
                score7.setScore(1);
                Score score8 = objective.getScore("§8 " );
                score8.setScore(0);

                player.setScoreboard(scoreboard);
            }
        }


        public static void resetTimeScoreboardLibre(){
            int timec = ScoreboardTimer.getInstance().time_libre + 1;

            long time = timec * 1000;
            String date2 = new SimpleDateFormat("m:ss").format(new Date(time));
            scoreboard.resetScores("§cTemps restant : §a" + date2);
        }


        public static void updateTimeScoreboardLibre(){
            long time = ScoreboardTimer.getInstance().time_libre * 1000;
            String date = new SimpleDateFormat("m:ss").format(new Date(time));

            Score score = objective.getScore("§cTemps restant : §a" + date);
            score.setScore(1);
        }


    public static void scoreboardImpose(String theme){
        for(Player player : Bukkit.getOnlinePlayers()) {

            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            objective.setDisplayName("§cBuild Contest");
            Score score = objective.getScore("§c ");
            score.setScore(8);
            Score score1 = objective.getScore("§cStatut : §aEn Jeu");
            score1.setScore(7);
            Score score2 = objective.getScore("§a ");
            score2.setScore(6);
            Score score3 = objective.getScore("§cThème principal : §aNeige & Hiver");
            score3.setScore(5);
            Score score4 = objective.getScore("§b ");
            score4.setScore(4);
            Score score5 = objective.getScore("§cThème secondaire : §a" + theme );
            score5.setScore(3);
            Score score6 = objective.getScore("§5 ");
            score6.setScore(2);
            long time = ScoreboardTimer.getInstance().time_impose * 1000;
            String date = new SimpleDateFormat("m:ss").format(new Date(time));
            Score score7 = objective.getScore("§cTemps restant : §a" + date);
            score7.setScore(1);
            Score score8 = objective.getScore("§8 " );
            score8.setScore(0);

            player.setScoreboard(scoreboard);
        }
    }
    public static void resetTimeScoreboardImpose(){
        int timec = ScoreboardTimer.getInstance().time_impose + 1;

        long time = timec * 1000;
        String date2 = new SimpleDateFormat("m:ss").format(new Date(time));
        scoreboard.resetScores("§cTemps restant : §a" + date2);
    }


    public static void updateTimeScoreboardImpose(){
        long time = ScoreboardTimer.getInstance().time_impose * 1000;
        String date = new SimpleDateFormat("m:ss").format(new Date(time));

        Score score = objective.getScore("§cTemps restant : §a" + date);
        score.setScore(1);
    }




}
