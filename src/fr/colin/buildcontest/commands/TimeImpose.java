package fr.colin.buildcontest.commands;

import fr.colin.buildcontest.Utils;
import fr.colin.buildcontest.VariableUtils;
import fr.colin.buildcontest.scoreboard.ScoreboardTimer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by colin on 23/02/2017.
 */
public class TimeImpose implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if(sender instanceof Player){


            if(sender.isOp()){



                ScoreboardTimer.getInstance().loadScoreboardTimeImpose(strings[0]);
                Utils.randomTp();

            }

        }

        return false;
    }



}
