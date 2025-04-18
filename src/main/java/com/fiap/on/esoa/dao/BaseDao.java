package com.fiap.on.esoa.dao;

import com.fiap.on.esoa.env.EnvLoader;

import java.sql.*;

public abstract class BaseDao {
    protected Connection getConnection() throws SQLException {
        String user = EnvLoader.getInstance().getValue("AZURE_DB_LOGIN")
                .orElseThrow(() -> new RuntimeException("Azure DB Login is missing!"));

        String db = EnvLoader.getInstance().getValue("AZURE_DB_NAME")
                .orElseThrow(() -> new RuntimeException("Azure DB Name is missing!"));

        String password = EnvLoader.getInstance().getValue("AZURE_DB_PWD")
                .orElseThrow(() -> new RuntimeException("Azure DB Password is missing!"));

        String conn = "jdbc:sqlserver://fiap-on-esoa3-agnello.database.windows.net:1433;database=vinheria_agnello;user=admin_esoa3_agnello@fiap-on-esoa3-agnello;password={password};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

        conn = conn.replace("{user}", user)
                .replace("{db_name}", db)
                .replace("{password}", password);

        return DriverManager.getConnection(conn);
    }
}
