package fr.esiee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {

    public static void main(String[] args) {

        String userLocal = "root";
        String pwdLocal = "";
        String urlLocal = "jdbc:mariadb://localhost:3306/easytrain";

        try {
            Connection conn = DriverManager.getConnection(urlLocal,userLocal,pwdLocal);
        System.out.println("Connection established");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
