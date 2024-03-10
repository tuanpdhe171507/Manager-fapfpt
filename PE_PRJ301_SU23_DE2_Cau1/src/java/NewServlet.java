
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
         String numberString= req.getParameter("number");
         int number= Integer.parseInt(numberString);
         PrintWriter out =  resp.getWriter();
         if(number<2 || number>5){
             out.println("You must input an integer 1<n<6");
         }else{
             long a= calculateFactorial(number);
             out.println("Result:"+a);
         }
    }
    //ham tinh giai thua.
      public static long calculateFactorial(int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // req.getRequestDispatcher("index.html").forward(req, resp);
    }
    
}
