package fr.colin.buildcontest;

import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by colin on 02/03/2017.
 */
public class PlayerAccounts {


    SqlUtils bdd = BuildContest.getInstance().getBdd();
    Connection connection = bdd.getConnection();

    private static PlayerAccounts instance = new PlayerAccounts();

    public static PlayerAccounts getInstance() {
        return instance;
    }

    public boolean hasAccount(Player player){

        try {
            PreparedStatement sql = connection.prepareStatement("SELECT * FROM joueurs WHERE UUID = ?");
            sql.setString(1, player.getUniqueId().toString());
            sql.execute();


            ResultSet resultSet = sql.getResultSet();
            while (resultSet.next()){
                sql.close();
                return true;
            }
            sql.close();
            return false;



        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    public void createAccount(Player player){
        if(hasAccount(player)){
            return;
        }

        try {
            PreparedStatement sql = connection.prepareStatement("INSERT INTO joueurs" + " (UUID, NAME, RANK) VALUES (?, ?, ?); ");
            sql.setString(1, player.getUniqueId().toString());
            sql.setString(2, player.getName());
            sql.setInt(3, 0);
            sql.execute();
            sql.close();

        }catch (SQLException e){
            e.printStackTrace();
        }




    }

    public Rank getPlayerRank(Player player){

        if(!hasAccount(player)){
            return Rank.JOUEUR;
        }
        int power = 0;

        try {
            PreparedStatement sql = connection.prepareStatement("SELECT RANK FROM joueurs WHERE UUID = ?;");
            sql.setString(1, player.getUniqueId().toString());
            sql.execute();
            ResultSet rs = sql.getResultSet();
            rs.next();
            power = sql.getResultSet().getInt(1);
            sql.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return Rank.getRankWithPower(power);
    }




}
