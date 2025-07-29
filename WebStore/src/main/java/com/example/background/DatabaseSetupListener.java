package com.example.background;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DatabaseSetupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS users (" +
                         "id INT AUTO_INCREMENT PRIMARY KEY, " +
                         "username VARCHAR(255) NOT NULL UNIQUE, " +
                         "password VARCHAR(255) NOT NULL, " +
                         "name VARCHAR(255), " +
                         "email VARCHAR(255), " +
                         "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                         "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP)";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS resumes (" +
                  "id INT AUTO_INCREMENT PRIMARY KEY, " +
                  "user_id INT, " +
                  "resume_text TEXT, " +
                  "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                  "FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE)";
            stmt.executeUpdate(sql);

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // No cleanup needed
    }
}
