package fr.colin.buildcontest.events;

import fr.colin.buildcontest.PlayerAccounts;
import fr.colin.buildcontest.Rank;
import fr.colin.buildcontest.SqlUtils;
import fr.colin.buildcontest.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by colin on 02/03/2017.
 */
public class PlayerChat implements Listener{



    @EventHandler
    public void onPlayerSendMessage(AsyncPlayerChatEvent event){

        String message = event.getMessage();
        Player player = event.getPlayer();
        Rank rank = PlayerAccounts.getInstance().getPlayerRank(player);
        if(rank.getPower() < 100) {
            event.setCancelled(true);
            Bukkit.broadcastMessage(Utils.getPrefix(player) + " " + player.getName() + " : " + message);
        }else{
            event.setCancelled(true);
            Bukkit.broadcastMessage(Utils.getPrefix(player) + " " + player.getName() + " : " + ChatColor.translateAlternateColorCodes('&', message));
        }

    }



}
