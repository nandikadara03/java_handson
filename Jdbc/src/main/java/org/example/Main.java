package org.example;



//import org.example.jdbc.StudentDAO;
//import org.example.jdbc.model.Student;

import org.example.jdbc.StudentDAO;
import org.example.jdbc.model.Student;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/";
        String url2 = "jdbc:postgresql://localhost:5432/jdbc_db";
        String username = "Z00DPFS";
        String password = "";
        Connection db;

        try {
            db = DriverManager.getConnection(url, username, password);
            Statement databaseCreation = db.createStatement();
            databaseCreation.executeUpdate("DROP DATABASE IF EXISTS JDBC_DB");
            databaseCreation.executeUpdate("CREATE DATABASE JDBC_DB");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            db = DriverManager.getConnection(url2, username, password);


            StudentDAO studao = new StudentDAO(db); //Will create table if not exists
            Student fstu = new Student();
            fstu.setFirstName("Nandika");
            fstu.setLastName("Dara");
            fstu.setAddress("xyz");
            fstu.setCity("Bengaluru");
            fstu.setEmail("nandika@gmail.com");
            fstu.setPhone("9217709098");
            fstu.setState("KA");
            fstu.setZipcode("5600035");
            studao.create(fstu);

            Student findstu = studao.findById(1);
            System.out.println(findstu);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
