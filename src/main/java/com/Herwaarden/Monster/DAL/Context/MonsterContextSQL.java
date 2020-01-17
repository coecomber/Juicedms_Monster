package com.Herwaarden.Monster.DAL.Context;

import com.Herwaarden.Monster.DAL.Interface.Context.IMonsterContext;
import com.Herwaarden.Monster.Model.MonsterModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonsterContextSQL implements IMonsterContext {
    private String sqlUrl;
    private String usernameUrl;
    private String passwordUrl;

    // Constructors
    public MonsterContextSQL(){
        sqlUrl = "jdbc:mysql://217.101.44.31/monsterDB";
        usernameUrl = "root";
        passwordUrl = "varken";
    }

    public MonsterModel getMonsterByFloor(int floor){
        List<MonsterModel> monsterModelList = new ArrayList<>();
        MonsterModel monsterModel = new MonsterModel();


        // create our mysql database connection
        try (Connection conn = DriverManager.getConnection(sqlUrl, usernameUrl, passwordUrl))
        {
            String query = "SELECT * FROM monstertable;";

            // create the java statement
            try (Statement st = conn.createStatement())
            {
                try (ResultSet rs = st.executeQuery(query))
                {
                    // iterate through the java resultset
                    while (rs.next())
                    {
                        if(rs.getInt("floor") == floor){
                            monsterModel.setName(rs.getString("name"));
                            monsterModel.setFloor(rs.getInt("floor"));
                            monsterModel.setGoldreward(rs.getInt("goldreward"));
                            monsterModel.setHealth(rs.getInt("health"));
                            monsterModelList.add(monsterModel);
                        }
                    }
                }
            }
        } catch (Exception e)
        {
            System.err.println(e);
            System.err.println("Got an exception in MonsterContextSQL.getMonsterByFloor().");
            System.err.println(e.getMessage());
        }

        if(monsterModelList.size() > 0){
            Random random = new Random();
            int listSize = monsterModelList.size();
            int randomIndex = random.nextInt(listSize);
            return monsterModelList.get(randomIndex);
        }
        return monsterModel;
    }
}
