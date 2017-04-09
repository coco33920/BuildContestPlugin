package fr.colin.buildcontest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by colin on 02/03/2017.
 */
public class VariableUtils {


    PreparedStatement preparedStatement;
    Connection connection = BuildContest.getInstance().getBdd().getConnection();


    private static VariableUtils instance = new VariableUtils();

    public static VariableUtils getInstance() {
        return instance;
    }

    public int getVariable(String variableName){
        int valeur = 0;

        try {
            PreparedStatement sql = connection.prepareStatement("SELECT * FROM variables WHERE NAME = ?");
            sql.setString(1, variableName);
            sql.execute();

            ResultSet resultSet = sql.getResultSet();
            resultSet.next();
            int lol = resultSet.getInt("VALEUR");
            sql.close();
            return lol;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return valeur;

    }

    public void updateVariable(String variableName, int newVariableValue){
        try {

            PreparedStatement sql = connection.prepareStatement("UPDATE variables SET VALEUR = ? WHERE NAME = ?");
            sql.setString(2, variableName);
            sql.setInt(1, newVariableValue);
            sql.execute();
            sql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setVariable(String variableName, int newVariableValue){

        try {
            PreparedStatement sql = connection.prepareStatement("INSERT INTO variables" + "(NAME, VALEUR) VALUES (?, ?);");
            sql.setString(1, variableName);
            sql.setInt(2, newVariableValue);
            sql.execute();
            sql.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public boolean isVariableIsSet(String variableName){
        try {
            PreparedStatement sql = connection.prepareStatement("SELECT * FROM variables WHERE NAME = ?");
            sql.setString(1, variableName);
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




}
