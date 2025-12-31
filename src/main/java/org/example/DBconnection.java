package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/company_db";
        String username = "root";
        String password = "password";

        try{
            //1.Load driver (optional for newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2  create connection
            Connection connection = DriverManager.getConnection(
                    url, username, password);

            System.out.println("Database connected successfully!");

            // 3. Close connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
