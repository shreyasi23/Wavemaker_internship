package com.ScienceFair;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class checkLogin implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        servletResponse.setContentType("html/text");

        PrintWriter out = servletResponse.getWriter();

        String tname, tID, teacherID = "", teacherName = "";
        String queryTeacherDetails = "select teacherID, teacherName from incharge;";
        tname = req.getParameter("tname");
        tID = req.getParameter("tID");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SciFair_db?useSSL=false","root", "Shreya@2001");
            Statement statement = connection.createStatement();
            ResultSet rs1 = statement.executeQuery(queryTeacherDetails);
            while(rs1.next()){
                teacherID = rs1.getString("teacherID");
                teacherName = rs1.getString("teacherName");
            }
            if(tID.equals(teacherID) && tname.equals(teacherName)){
                filterChain.doFilter(servletRequest, servletResponse);
            }
            else{
                    out.println("Teacher Name or Techer ID is incorrect!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
