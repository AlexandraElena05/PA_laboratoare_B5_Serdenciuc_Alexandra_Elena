package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.PrimitiveIterator;

public class Database {
    private static Database db = new Database();
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "JAVA";
    private static final String PASSWORD = "JAVA";
    private static Connection connection = null;

    public Database() { }

    public static Database getInstance() {
        return db;
    }

    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {

        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            for (Throwable e : ex)
                if (e instanceof SQLException) {
                    SQLException sqlException = (SQLException) e;
                    System.out.println("sqlState : " + sqlException.getSQLState());
                    System.out.println("error code : " + sqlException.getErrorCode());
                    System.out.println("message : " + sqlException.getMessage());
                    Throwable t = ex.getCause();
                    while (t != null) {
                        System.out.println("Cause : " + t);
                        t = t.getCause();
                    }
                }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
