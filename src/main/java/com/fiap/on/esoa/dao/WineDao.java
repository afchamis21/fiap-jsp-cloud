package com.fiap.on.esoa.dao;

import com.fiap.on.esoa.domain.Wine;

import java.sql.ResultSet;
import java.sql.SQLException;

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

        return wine;
    }
}
