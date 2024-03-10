
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author G5 5590
 */
public class NewServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String numberString=req.getParameter("number");
         PrintWriter out =  resp.getWriter();
       
       if(numberString==null || numberString.isEmpty()){
           out.println("You must input an integer 0<n<10");
       }else if( Integer.parseInt(numberString)<1 ||  Integer.parseInt(numberString)>9){
           out.println("You must input an integer 0<n<10");
       }
       else{
           
            int sum=0;
           for (int i = 0; i <= Integer.parseInt(numberString); i++) {
                 sum+=i;
           }
           req.setAttribute("result", sum);
           req.getRequestDispatcher("MyExam.jsp").forward(req, resp);
       }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("MyExam.jsp").forward(req, resp);
    }
    
}
