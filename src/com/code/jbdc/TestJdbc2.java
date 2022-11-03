package com.code.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc2 {
    public static void main(String[] args) {

        String jbdcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";
        try {
            System.out.println("Connecting to database:" + jbdcUrl);

            Connection myConn = DriverManager.getConnection(jbdcUrl, user, pass);
            System.out.println("Connection sucessful!!!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
