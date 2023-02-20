package com.library;

import java.sql.*;

import static java.sql.DriverManager.getConnection;


public class loginFunc {

    public int checkUsers(librarianLoginCreds llgObj){
        String adminName, adminPass, checkName = "", checkPass = "";
        adminName = llgObj.getLibnName();
        adminPass = llgObj.getLibnPassword();
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LMS_db?useSSL=false","root","Shreya@2001");
            Statement statement = connection.createStatement();
            ResultSet rs1 = statement.executeQuery("select libName, paswd from librarian");

            while(rs1.next()){
                checkName = rs1.getString("libName");
                checkPass = rs1.getString("paswd");
            }
            if(checkName.equals(adminName) && checkPass.equals(adminPass)){
                System.out.println("Login Successful!\nWelcome "+checkName);
                return 1;
            }
            else{
                System.out.println("Incorrect username or password");
                return 2;
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

