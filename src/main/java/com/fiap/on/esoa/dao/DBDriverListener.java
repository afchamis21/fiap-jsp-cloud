package com.fiap.on.esoa.dao;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class DBDriverListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            DriverManager.registerDriver(new SQLServerDriver());
        } catch (SQLException e) {
            throw new RuntimeException("Failed to register SQL Server JDBC driver", e);
        }
   }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            DriverManager.deregisterDriver(DriverManager.getDriver("jdbc:sqlserver://"));
        } catch (SQLException e) {
            throw new RuntimeException("Failed to deregister SQL Server JDBC driver", e);
        }
    }
}
