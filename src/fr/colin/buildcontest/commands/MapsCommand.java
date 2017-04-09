package fr.colin.buildcontest.commands;

import fr.colin.buildcontest.BuildContest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * Created by colin on 17/03/2017.
 */
public class MapsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


            int i = 0;
            for (HashMap.Entry<Player, String> entry : BuildContest.getInstance().playerName.entrySet())
            {
                i++;
                commandSender.sendMessage("§cMap §a"  + BuildContest.getInstance().playerMaps.get(entry.getKey()) +  " §cJoueur §a" + entry.getKey().getName() + " §cPrénom : §a" + entry.getValue());
            }




        return false;
    }
}
