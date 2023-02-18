package com.calculator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorFunc extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        try{
            int num1 = Integer.parseInt(req.getParameter("operand1"));
            int num2 = Integer.parseInt(req.getParameter("operand2"));
            int result = 0;
            String opratn = req.getParameter("operator");
            if(opratn.equals("+")){
                result = num1 + num2;
            }
            else if(opratn.equals("-")){
                result = num1 - num2;
            }
            else if(opratn.equals("*")){
                result = num1 * num2;
            }
            else{
                result = num1 / num2;
            }

            out.println("<h3>Result: "+result+"</h3>");
        }
        catch(Exception e){
            out.println("Error: "+e.getMessage());
        }
    }
}
