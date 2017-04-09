package fr.colin.buildcontest.commands;

import fr.colin.buildcontest.scoreboard.ScoreboardTimer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by colin on 18/03/2017.
 */
public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;

        if(strings.length == 1){
            String name = strings[0];
            ScoreboardTimer.getInstance().loadScoreboardTimeImpose(name);
            return false;
        }

        ScoreboardTimer.getInstance().loadScoreboardTimeLibre();




        return false;
    }
}
