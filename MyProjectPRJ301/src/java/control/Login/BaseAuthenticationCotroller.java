/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control.Login;

import dao.LoginDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.Login.Login;


/**
 *
 * @author G5 5590
 */
public abstract class BaseAuthenticationCotroller extends HttpServlet{
    private Login getAuthenticatedAccount(HttpServletRequest req)
    {
        //được gọi từ AccountServlet sang
      Login account = (Login) req.getSession().getAttribute("account");
      if(account == null)
      {
//          Cookie[] cookies = req.getCookies();
//          if(cookies!=null)
//          {
//              String username = null;
//              String password = null;
//              for (Cookie cooky : cookies) {
//                  if(cooky.getName().equals("username"))
//                      username = cooky.getValue();
//                  
//                  if(cooky.getName().equals("password"))
//                      password = cooky.getValue();
//                  
//                  if(username !=null && password!=null)
//                      break;
//              }
          
          
                  // Lấy session từ request
              HttpSession session= req.getSession();
               //lấy giá trị của thuộc tính có tên "userN" từ session và gán vào biến username
              String username =(String) session.getAttribute("userN");
          
             
              if(username !=null)
              {
                  LoginDBContext db = new LoginDBContext();
                  account = db.getByUsernamePassword(username);
                  
                  //: Sau khi tìm kiếm thành công, đối tượng account được lưu vào session với tên thuộc tính là "account".
                  //Điều này cho phép truy cập vào thông tin tài khoản này từ các trang hoặc
                  //yêu cầu servlet khác sau này trong cùng một phiên làm việc.
                  req.getSession().setAttribute("account", account);
              }
          }
      
      return account;
    }
    
    protected abstract void doPost(HttpServletRequest req, HttpServletResponse resp, Login account)
            throws ServletException, IOException; 
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Login account = getAuthenticatedAccount(req);
        if(account!=null)
        {
            doPost(req, resp, account);
        }
        else
        {
            resp.getWriter().println("access denied!");
        }
    
    }

    protected abstract void doGet(HttpServletRequest req, HttpServletResponse resp, Login account)
            throws ServletException, IOException; 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Login account = getAuthenticatedAccount(req);
        if(account!=null)
        {
            doGet(req, resp, account);
        }
        else
        {
            resp.getWriter().println("access denied!");
        }
    }
}
