/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.Login;

import dao.CampusDBContext;
import dao.LoginDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Login.Campus;
import model.Login.Login;

/**
 *
 * @author G5 5590
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CampusDBContext c = new CampusDBContext();
        List<Campus> list = c.listCampus();
        request.setAttribute("campus", list);
        request.getRequestDispatcher("view/head.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("did");
        LoginDBContext db = new LoginDBContext();
        Login account = db.getByUsernamePassword(username);

        if (account != null) {
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            session.setAttribute("userN", username);

//            Cookie c_user = new Cookie("username", username);
//            Cookie c_pass = new Cookie("password", password);
//            c_user.setMaxAge(3600*24*7);
//            c_pass.setMaxAge(3600*24*7);
//            response.addCookie(c_pass);
//            response.addCookie(c_user);


            
            request.getRequestDispatcher("view/Academic.jsp").forward(request, response);

            // response.getWriter().println("Login sucessful!");
        } else {
            // response.getWriter().println("Login failed");

            request.setAttribute("error", "Tài khoản của bạn không được phép đăng nhập vào hệ thống");
            request.setAttribute("error2", "Sinh viên có nhu cầu thực hiện các thủ tục, dịch vụ vui lòng liên hệ Trung tâm Dịch vụ Sinh viên: Hotline: (0236) 730 8686 Email: dvsv.fudn@fe.edu.vn");
            CampusDBContext c = new CampusDBContext();
            List<Campus> list = c.listCampus();
            request.setAttribute("campus", list);
            request.getRequestDispatcher("view/head.jsp").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
