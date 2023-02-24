package com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class regservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String studid = req.getParameter("stud_id");
        String studname = req.getParameter("stud_name");
        int rollno = Integer.parseInt(req.getParameter("roll_no"));
        String studclass = req.getParameter("class");
        String studsec = req.getParameter("section");
        String prjtitle = req.getParameter("prj_title");
        String insertDataQuery = "insert into participants(studID, studName, rollNo, class, section, modelName) value(?,?,?,?,?,?);";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SciFair_db?useSSL=false","root", "Shreya@2001");
            PreparedStatement preparedStatement = connection.prepareStatement(insertDataQuery);
            preparedStatement.setString(1, studid);
            preparedStatement.setString(2, studname);
            preparedStatement.setInt(3, rollno);
            preparedStatement.setString(4, studclass);
            preparedStatement.setString(5, studsec);
            preparedStatement.setString(6, prjtitle);
            preparedStatement.executeUpdate();
            out.println("<h2>Registration successful!</h2>");
        } catch (SQLException e) {
            out.println(e);
        } catch (ClassNotFoundException e) {
            out.println(e);
        }
    }
}
