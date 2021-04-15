package com.company.DAO;

import com.company.Database;

import java.sql.*;

public class GenreController {

    public void create(String name) throws SQLException {
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pstmt = con.prepareStatement("insert into genres (name) values (?)")) {
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
             ResultSet rs = stmt.executeQuery("select id from genres where name like '" + name + "'")) {
            stmt.close();
            return rs.next() ? rs.getInt(1) : null;

        }
    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select name from genres where id like '" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
    public void findAll() throws SQLException{
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from genres")){
            while (rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2));
            }
        }
    }

}
