package fr.colin.buildcontest.events;

import fr.colin.buildcontest.GameState;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.WorldLoadEvent;

/**
 * Created by colin on 23/02/2017.
 */
public class PlayerBreak implements Listener {


    @EventHandler
    public void onPlayerBreak(BlockBreakEvent event){


        if(GameState.getCurrentState().equals(GameState.LOBBY)){
            event.setCancelled(true);
            return;
        }

        Player player = event.getPlayer();

        Block block = event.getBlock();

        Material material = block.getType();

        if(material == Material.BEDROCK || material == Material.BARRIER ){
            if(player.isOp() == false) {
                event.setCancelled(true);
            }

        }





    }

    @EventHandler
    public void onPlayerPlace(BlockPlaceEvent event){

        if(GameState.getCurrentState().equals(GameState.LOBBY)){
            event.setCancelled(true);
            return;
        }


        Player player = event.getPlayer();

        Material material = event.getBlock().getType();


        if(material == Material.BEDROCK || material == Material.BARRIER ){
            if(!player.isOp()) {
                event.setCancelled(true);
            }

        }


    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event){
        event.setCancelled(true);
    }
    @EventHandler
    public void onWorldLoad(WorldLoadEvent event){

        event.getWorld().setGameRuleValue("doDaylightCycle", "false");


    }


}
