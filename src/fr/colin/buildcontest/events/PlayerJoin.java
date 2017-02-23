package fr.colin.buildcontest.events;

import fr.colin.buildcontest.Utils;
import fr.colin.buildcontest.scoreboard.ScoreboardLobby;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by colin on 23/02/2017.
 */
public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){


        Player player = event.getPlayer();
        player.teleport(Utils.getLobby());
        ScoreboardLobby.generate(player);




    }


}
