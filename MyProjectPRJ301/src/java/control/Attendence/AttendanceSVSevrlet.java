/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.Attendence;

import dao.timetable.GroupDBContext;
import dao.timetable.SemeterDBContext;
import dao.timetable.SessionDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import model.Group;
import model.Semeter;
import model.Session;

/**
 *
 * @author G5 5590
 */
public class AttendanceSVSevrlet extends HttpServlet {

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
            out.println("<title>Servlet AttendanceSVSevrlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AttendanceSVSevrlet at " + request.getContextPath() + "</h1>");
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

        SemeterDBContext semeterDBContext = new SemeterDBContext();
        ArrayList<Semeter> lists = semeterDBContext.getSemetersByName();
        request.setAttribute("listSemeter", lists);

        if(lists!=null){
        GroupDBContext groupDBContext = new GroupDBContext();
        ArrayList<Group> listSe2 = groupDBContext.getSemetersAndSubject(10);
        request.setAttribute("listSubject", listSe2);
       
        }
        // Kiểm tra xem có tồn tại tham số "semeterId1ff" trong request hay không
        if (request.getParameter("semeterId1ff") != null) {

            int id1 = Integer.parseInt(request.getParameter("semeterId1ff"));
            SessionDBContext sessionDBContext = new SessionDBContext();
            ArrayList<Session> arrayList = sessionDBContext.getSessionByStudentidAndSubjectid(id1);
            request.setAttribute("diemDanh", arrayList);

            LocalDate currentDate1 = LocalDate.now();
            int year1 = currentDate1.getYear();
            int month1 = currentDate1.getMonthValue();
            int day1 = currentDate1.getDayOfMonth();
            Date currentDate2 = new Date(year1 - 1900, month1 - 1, day1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date formattedDate = new java.sql.Date(currentDate2.getTime());
            request.setAttribute("daynow", formattedDate);

          
        }

        request.getRequestDispatcher("viewTimeTableSv/AttendanceSV.jsp").forward(request, response);
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

        SemeterDBContext semeterDBContext = new SemeterDBContext();
        ArrayList<Semeter> lists = semeterDBContext.getSemetersByName();
        request.setAttribute("listSemeter", lists);

        int id = Integer.parseInt(request.getParameter("semeterId"));
        GroupDBContext groupDBContext = new GroupDBContext();
        ArrayList<Group> listSe = groupDBContext.getSemetersAndSubject(id);
        request.setAttribute("listSubject", listSe);
        
       if (request.getParameter("semeterId1ff") != null) {

            int id1 = Integer.parseInt(request.getParameter("semeterId1ff"));
            SessionDBContext sessionDBContext = new SessionDBContext();
            ArrayList<Session> arrayList = sessionDBContext.getSessionByStudentidAndSubjectid(id1);
            request.setAttribute("diemDanh", arrayList);

            LocalDate currentDate1 = LocalDate.now();
            int year1 = currentDate1.getYear();
            int month1 = currentDate1.getMonthValue();
            int day1 = currentDate1.getDayOfMonth();
            Date currentDate2 = new Date(year1 - 1900, month1 - 1, day1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date formattedDate = new java.sql.Date(currentDate2.getTime());
            request.setAttribute("daynow", formattedDate);

          
        }
        

        request.getRequestDispatcher("viewTimeTableSv/AttendanceSV.jsp").forward(request, response);
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
