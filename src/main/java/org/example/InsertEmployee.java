package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEmployee {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/company_db?useSSL=false&allowPublicKeyRetrieval=true";
        String username = "root";
        String password = "password"; // change this

        String sql = "INSERT INTO employee(name, email, salary) VALUES (?, ?, ?)";

        try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, "Rahul");
            ps.setString(2, "rahul@gmail.com");
            ps.setDouble(3, 60000);

            ps.executeUpdate();
            System.out.println("✅ Employee inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}