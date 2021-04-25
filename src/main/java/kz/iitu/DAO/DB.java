package kz.iitu.DAO;

import java.sql.*;

public class DB {
    private static Connection con;

    public static Connection getCon(){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library",
                        "postgres","madiyar");

        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
