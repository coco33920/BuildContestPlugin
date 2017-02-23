package fr.colin.buildcontest;

import fr.colin.buildcontest.events.PlayerBreak;
import fr.colin.buildcontest.events.PlayerJoin;
import fr.colin.buildcontest.events.RegisterEvents;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by colin on 23/02/2017.
 */
public class BuildContest extends JavaPlugin{


    //TODO :
    //Barriere indestructible
    //6 Location Tp aleatoire des joueurs présents
    //TIMER DANS LE SCOREBOARD


    @Override
    public void onEnable() {
        new RegisterEvents(this, new PlayerBreak(), new PlayerJoin());
        super.onEnable();
    }
}
