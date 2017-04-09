package fr.colin.buildcontest.commands;

import fr.colin.buildcontest.VariableUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by colin on 03/03/2017.
 */
public class TimeCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (strings.length < 3) {
            commandSender.sendMessage(ChatColor.AQUA + "Erreur : essayez /time set libre/impose <temps>");
            return false;
        }
        if (strings[0].equalsIgnoreCase("set")) {
            if (strings[1].equalsIgnoreCase("libre")) {
                String string = strings[2];
                int time;
                try {
                    time = Integer.parseInt(string);

                }catch (NumberFormatException e){
                    commandSender.sendMessage(ChatColor.RED+"Erreur ce n'est pas un nombre correct");
                    return false;
                }
                VariableUtils.getInstance().updateVariable("TIME_LIBRE", time);
                commandSender.sendMessage(ChatColor.GREEN+"Vous avez mit la valeur de TIME_LIBRE à " + time);

                return false;
            } else if (strings[1].equalsIgnoreCase("impose")) {
                String string = strings[2];
                int time;
                try {
                    time = Integer.parseInt(string);

                }catch (NumberFormatException e){
                    commandSender.sendMessage(ChatColor.RED+"Erreur ce n'est pas un nombre correct");
                    return false;
                }
                VariableUtils.getInstance().updateVariable("TIME_IMPOSE", time);
                commandSender.sendMessage(ChatColor.GREEN+"Vous avez mit la valeur de TIME_IMPOSE à " + time);
                return false;
            } else {
                commandSender.sendMessage(ChatColor.AQUA + "Erreur : essayez /time set libre/impose <temps>");
                return false;
            }
        } else {
            commandSender.sendMessage(ChatColor.AQUA + "Erreur : essayez /time set libre/impose <temps>");
            return false;
        }
    }
}
