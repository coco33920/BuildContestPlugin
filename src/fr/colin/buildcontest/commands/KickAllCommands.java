package fr.colin.buildcontest.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by colin on 11/03/2017.
 */
public class KickAllCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        for(Player player : Bukkit.getOnlinePlayers()){
            player.kickPlayer("§cFin de la partie :)");
        }
        return false;
    }
}
