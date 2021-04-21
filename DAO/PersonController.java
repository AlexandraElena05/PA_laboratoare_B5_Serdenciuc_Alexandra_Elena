package com.company.DAO;

import com.company.Database;

import java.sql.*;

public class PersonController {

    public void create(String name) throws SQLException {
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pstmt = con.prepareStatement("insert into persons (name) values (?)")) {
                pstmt.setString(1, name);
                pstmt.executeUpdate();
                pstmt.close();
                Database.commit();
            }
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id from persons where name like '" + name + "'")) {
            stmt.close();
            return rs.next() ? rs.getInt(1) : null;

        }
    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select name from persons where id like '" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
    public void findAll() throws SQLException{
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from persons")){
            while (rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2));
            }
        }
    }

}