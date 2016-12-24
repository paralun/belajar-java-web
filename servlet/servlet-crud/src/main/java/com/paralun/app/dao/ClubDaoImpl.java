/*
 * Copyright (c) 2016 | James Kusmambang
 * Source : https://github.com/paralun
 */
package com.paralun.app.dao;

import com.paralun.app.model.Club;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClubDaoImpl implements ClubDao {
    
    private final Connection connection;

    public ClubDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Club club) {
        try {
            String sql = "insert into t_club(nama_club, stadion) values(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, club.getNamaClub());
            statement.setString(2, club.getStadion());
            statement.executeUpdate();
        }catch(Exception ex) {
            
        }
    }

    @Override
    public void update(Club club) {
        try {
            String sql = "update t_club set nama_club = ?, stadion = ? where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, club.getNamaClub());
            statement.setString(2, club.getStadion());
            statement.setInt(3, club.getId());
            statement.executeUpdate();
        }catch(Exception ex) {
            
        }
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Club getClub(int id) {
        try {
            String sql = "select * from t_club where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            Club club = new Club();
            if(result.next()) {
                club.setId(result.getInt("id"));
                club.setNamaClub(result.getString("nama_club"));
                club.setStadion(result.getString("stadion"));
            }
            
            return club;
        } catch (SQLException ex) {
            System.out.println("ERRRORR BRAAYYAY");
            return null;
        }
    }

    @Override
    public List<Club> getClubs() {
        try {
            List<Club> list = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from t_club");
            while (result.next()) {                
                Club club = new Club();
                club.setId(result.getInt("id"));
                club.setNamaClub(result.getString("nama_club"));
                club.setStadion(result.getString("stadion"));
                list.add(club);
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
