/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;


import dao.TblUsersDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.TblUsers;


/**
 *
 * @author G5 5590
 */
public abstract class BaseAuthenticationCotroller extends HttpServlet{
    private TblUsers getAuthenticatedAccount(HttpServletRequest req)
    {
        
      TblUsers account = (TblUsers) req.getSession().getAttribute("account");
      if(account == null)
      {

              HttpSession session= req.getSession();
              
              String username =(String) session.getAttribute("userN");
          
              String password = (String) session.getAttribute("passW");
              if(username !=null && password!=null)
              {
                  TblUsersDBContext db = new TblUsersDBContext();
                  account = db.getByUsernamePassword(username, password);
          
                  req.getSession().setAttribute("account", account);
              }
          }
      
      return account;
    }
    
    protected abstract void doPost(HttpServletRequest req, HttpServletResponse resp, TblUsers account)
            throws ServletException, IOException; 
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TblUsers account = getAuthenticatedAccount(req);
        if(account!=null)
        {
            doPost(req, resp, account);
        }
        else
        {
            resp.getWriter().println("access denied!");
        }
    
    }

    protected abstract void doGet(HttpServletRequest req, HttpServletResponse resp, TblUsers account)
            throws ServletException, IOException; 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    TblUsers account = getAuthenticatedAccount(req);
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
