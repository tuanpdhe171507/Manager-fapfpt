/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.AccountDBContex;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.Account;

/**
 *
 * @author G5 5590
 */
public abstract class BaseAuthenticationCotroller extends HttpServlet{
    private Account getAuthenticatedAccount(HttpServletRequest req)
    {
        //được gọi từ AccountServlet sang
      Account account = (Account) req.getSession().getAttribute("account");
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
              //Chú ý rằng "userN" là tên của thuộc tính được sử dụng để lưu trữ tên người dùng trong session.
              String password = (String) session.getAttribute("passW");
              if(username !=null && password!=null)
              {
                  AccountDBContex db = new AccountDBContex();
                  account = db.getByUsernamePassword(username, password);
                  
                  //: Sau khi tìm kiếm thành công, đối tượng account được lưu vào session với tên thuộc tính là "account".
                  //Điều này cho phép truy cập vào thông tin tài khoản này từ các trang hoặc
                  //yêu cầu servlet khác sau này trong cùng một phiên làm việc.
                  req.getSession().setAttribute("account", account);
              }
          }
      
      return account;
    }
    
    protected abstract void doPost(HttpServletRequest req, HttpServletResponse resp, Account account)
            throws ServletException, IOException; 
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = getAuthenticatedAccount(req);
        if(account!=null)
        {
            doPost(req, resp, account);
        }
        else
        {
            resp.getWriter().println("access denied!");
        }
    
    }

    protected abstract void doGet(HttpServletRequest req, HttpServletResponse resp, Account account)
            throws ServletException, IOException; 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Account account = getAuthenticatedAccount(req);
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
