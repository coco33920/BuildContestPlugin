package fr.colin.buildcontest;

import fr.colin.buildcontest.commands.*;
import fr.colin.buildcontest.events.PlayerBreak;
import fr.colin.buildcontest.events.PlayerChat;
import fr.colin.buildcontest.events.PlayerJoin;
import fr.colin.buildcontest.events.RegisterEvents;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.time.temporal.ValueRange;
import java.util.HashMap;

/**
 * Created by colin on 23/02/2017.
 */
public class BuildContest extends JavaPlugin{

    private static BuildContest instance;

    private SqlUtils bdd;
    public int tlibre;
    public int timpose;
    public HashMap<Player, Integer> playerMaps = new HashMap<>();
    public HashMap<Player, String> playerName = new HashMap<>();



    @Override
    public void onEnable() {
        instance = this;
        new RegisterEvents(this, new PlayerBreak(), new PlayerJoin(), new PlayerChat());
        getCommand("libre").setExecutor(new TimeLibre());
        getCommand("impose").setExecutor(new TimeImpose());
        getCommand("time").setExecutor(new TimeCommands());
        getCommand("kickall").setExecutor(new KickAllCommands());
        getCommand("vote").setExecutor(new VoteCommand());
        getCommand("adflpskzpxkspf").setExecutor(new AdflpskzpxkspfCommand());
        getCommand("login").setExecutor(new LoginCommand());
        getCommand("maps").setExecutor(new MapsCommand());
        getCommand("test").setExecutor(new TestCommand());
        bdd = new SqlUtils("127.0.0.1", "root", "root", "build");
        bdd.connection();
        if(!VariableUtils.getInstance().isVariableIsSet("TIME_LIBRE")){
            VariableUtils.getInstance().setVariable("TIME_LIBRE", 421);
        }
        if(!VariableUtils.getInstance().isVariableIsSet("TIME_IMPOSE")){
            VariableUtils.getInstance().setVariable("TIME_IMPOSE", 301);
        }

        tlibre  = VariableUtils.getInstance().getVariable("TIME_LIBRE");
        timpose = VariableUtils.getInstance().getVariable("TIME_IMPOSE");
        GameState.setCurrentState(GameState.LOBBY);
        super.onEnable();



    }


    @Override
    public void onDisable() {
        refreshWorld();
    }

    public void refreshWorld(){
        WorldUtils.deleteFile(new File("world"));
        WorldUtils.copyFile(new File("saveworld"), new File("world"));
    }
    public static BuildContest getInstance() {
        return instance;
    }

    public SqlUtils getBdd() {
        return bdd;
    }
}
