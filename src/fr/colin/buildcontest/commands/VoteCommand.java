package fr.colin.buildcontest.commands;

import fr.colin.buildcontest.GameState;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by colin on 17/03/2017.
 */
public class VoteCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(GameState.getCurrentState().equals(GameState.INGAME)){
            return false;
        }

        TextComponent textComponent = new TextComponent("§aTéléportation Map 1 !");
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/adflpskzpxkspf 1"));
        Player player = (Player) commandSender;
        player.spigot().sendMessage(textComponent);
        return false;
    }
}
