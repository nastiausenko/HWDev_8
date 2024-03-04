package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static final Database instance = new Database();
    private final String dbUrl = "jdbc:h2:~/test";
    private final String dbUser = "sa";
    private final String dbPass = "";
    private Connection connection;

    private Database() {
        try {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
    }

    public static Database getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
