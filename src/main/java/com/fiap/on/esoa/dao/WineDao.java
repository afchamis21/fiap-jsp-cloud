package com.fiap.on.esoa.dao;

import com.fiap.on.esoa.domain.Wine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WineDao extends BaseDao {

    private Wine mapResultSetToWine(ResultSet rs) throws SQLException {
        Wine wine = new Wine();

        wine.setMaker(rs.getString("Maker"));
        wine.setName(rs.getString("Name"));
        wine.setGrape(rs.getString("Grape"));
        wine.setImage(rs.getString("Image"));
        wine.setAlt(rs.getString("Alt"));
        wine.setRating(rs.getInt("Rating"));
        wine.setYear(rs.getInt("Year"));
        wine.setPrice(rs.getBigDecimal("Price"));
        wine.setCountry(rs.getString("Country"));

        return wine;
    }

    public List<Wine> listAll() {
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement("select Id, Maker, Name, Image, Alt, Country, Grape, Price, Rating, Year from dbo.Wine");
            ResultSet rs = ps.executeQuery();

            List<Wine> wines = new ArrayList<>();
            while (rs.next()) {
                wines.add(mapResultSetToWine(rs));
            }

            return wines;
        } catch (SQLException e) {
            System.out.println("Error listing all wines: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
