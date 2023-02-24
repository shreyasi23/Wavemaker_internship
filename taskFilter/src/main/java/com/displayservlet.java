package com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class displayservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String studId, studName, studClass, section, projTitle;
        int rollNo;
        String displayParticipants = "select * from participants;";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SciFair_db?useSSL=false","root", "Shreya@2001");
            Statement statement = connection.createStatement();
            ResultSet rs =  statement.executeQuery(displayParticipants);
            out.println("<h2>List of Participants</h2>");
            out.println("<table><tr>");
            out.println("<th>Student ID</th>");
            out.println("<th>Student Name</th>");
            out.println("<th>Roll No.</th>");
            out.println("<th>Class</th>");
            out.println("<th>Section</th>");
            out.println("<th>Project Title</th>");
            out.println("</tr>");
            while(rs.next()){
                studId = rs.getString("studID");
                studName = rs.getString("studName");
                rollNo = rs.getInt("rollNo");
                studClass = rs.getString("class");
                section = rs.getString("section");
                projTitle = rs.getString("modelName");
                out.println("<tr><td>"+studId+"</td><td>"+studName+"</td><td>"+rollNo+"</td><td>"+studClass+"</td><td>"+section+"</td><td>"+projTitle+"</td></tr>");
            }
            out.println("</table>");
        } catch(SQLException e) {
            out.println(e);
        } catch(ClassNotFoundException e) {
            out.println(e);
        }
    }
}
