package fr.colin.buildcontest.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

/**
 * Created by colin on 23/02/2017.
 */
public class ScoreboardLobby {



    public static void generate(Player player){

        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("§cBuild Contest", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§cBuild Contest");
        Score score = objective.getScore("§c ");
        score.setScore(6);
        Score score1 = objective.getScore("§cStatut : §aEn attente" );
        score1.setScore(5);
        Score score2 = objective.getScore("§a ");
        score2.setScore(4);
        Score score3 = objective.getScore("§cThème principal : §aNeige & Ski");
        score3.setScore(3);
        Score score4 =  objective.getScore("§b ");
        score4.setScore(2);
        Score score5 = objective.getScore("§6Bonne chance :) !");
        score5.setScore(1);
        Score score6 = objective.getScore("§5 ");
        score6.setScore(0);

        player.setScoreboard(scoreboard);




    }


}
