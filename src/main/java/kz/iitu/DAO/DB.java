package kz.iitu.DAO;

import java.sql.*;

public class DB {

    public static Connection getCon() throws ClassNotFoundException, SQLException {

        String url = "jdbc:postgresql://localhost:5432/library";
        String username = "postgres";
        String password = "123456";
        System.out.println("In DBConnection.java class ");

        Class.forName("org.postgresql.Driver");

        return DriverManager.getConnection(url, username, password);
    }
}
