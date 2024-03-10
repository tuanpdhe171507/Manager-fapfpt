/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.TblCapstonesDBContext;
import dao.TblUsersDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import model.TblCapstones;
import model.TblUsers;

/**
 *
 * @author G5 5590
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        TblUsersDBContext db = new TblUsersDBContext();
        String roleID = db.getByRoleID().getRoleID();
        TblUsers account = db.getByUsernamePassword(username, password);

        if (account != null && roleID.equalsIgnoreCase("AD")) {
            HttpSession session = req.getSession();
            session.setAttribute("account", account);
            session.setAttribute("userN", username);
            session.setAttribute("passW", password);

            String fullName = account.getFullName();

            req.setAttribute("text", "Welcome the " + fullName);

       
             req.getRequestDispatcher("captstonesList.jsp").forward(req, resp);

            // resp.sendRedirect("captstonesList.jsp");
        } else {

            req.setAttribute("text1", "Incorrect UserName or PassWord");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

}
