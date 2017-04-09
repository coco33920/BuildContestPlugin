package fr.colin.buildcontest.commands;

import fr.colin.buildcontest.BuildContest;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by colin on 17/03/2017.
 */
public class LoginCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if(!(strings.length == 1)){
                player.sendMessage("§cErreur veuillez ne mettre qu'un seul nom :)  Ex : /login Colin.");
                return false;
            }

            if (BuildContest.getInstance().playerName.containsKey(player)) {
                BuildContest.getInstance().playerName.remove(player);
            }
            String playerName = strings[0];
            BuildContest.getInstance().playerName.put(player, playerName);
            player.sendMessage("§cVous vous êtes enregistré sous le nom de : §a" + playerName);



        }
        return false;
    }
}
