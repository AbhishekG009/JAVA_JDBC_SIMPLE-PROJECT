package org.example;

import java.sql.*;

public class FetchEmployee {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/company_db";
        String username = "root";
        String password = "password";

        String query = "SELECT * FROM employee";

        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("email") + " " +
                                rs.getDouble("salary")
                );
            }

    }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
