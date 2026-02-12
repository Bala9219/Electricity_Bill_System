package Electricity_Billing_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class database {

    Connection connection;

    Statement statement;
    database(){
        try{
            String DB_URL = System.getenv("DB_URL");
            String DB_USER = System.getenv("DB_USER");
            String DB_PASSWORD = System.getenv("DB_PASSWORD");

            if (DB_URL == null || DB_USER == null || DB_PASSWORD == null) {
                throw new RuntimeException("Environment variables not set!");
            }

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
