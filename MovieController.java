package com.company.DAO;

import com.company.Database;

import java.sql.*;

public class MovieController {
    public void create(String title, int filmId) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("insert into movies (title, film_id) values (?, ?)")) {
            pstmt.setString(1, title);
            pstmt.setInt(2, filmId);
            pstmt.executeUpdate();
            pstmt.close();
            Database.commit();
        }
    }

    public Integer findByTitle(String title) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id from movies where title like '" + title + "'")) {
            stmt.close();
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select title from movies where id like '" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public String findByFilmId(int filmId) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select title from movies where film_id like '" + filmId + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public ResultSet findAll() throws SQLException{
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from movies")){
            return rs;
        }
    }
}
