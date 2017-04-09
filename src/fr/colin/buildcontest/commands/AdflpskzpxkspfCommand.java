package fr.colin.buildcontest.commands;

import fr.colin.buildcontest.Utils;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by colin on 17/03/2017.
 */
public class AdflpskzpxkspfCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;
        String NameMap = strings[0];
        int i = Integer.parseInt(NameMap);
        if(i > 6){
            return false;
        }
        int newI = i - 1;
        Utils.fillLocationList();
        player.teleport(Utils.getLocations().get(newI));
        TextComponent textComponent = new TextComponent("§aTéléportation Map " + (i+1) + " !" );

        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/adflpskzpxkspf " + (i+1)));
        if(i < 6) {
            player.spigot().sendMessage(textComponent);
        }

        return false;
    }
}
