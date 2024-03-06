/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.TimeTable;

import controller.authentication.authorization.BaseRBACController;
import dao.CampusDBContext;

import dao.WeekTimeTableDBContext;
import dao.timetable.SessionDBContext;
import dao.timetable.TimeSlotDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Login.Campus;
import model.WeekTimeTable;
import java.sql.*;
import model.Account;
import model.Login.Login;
import model.Role;
import model.Session;
import model.TimeSlot;

/**
 *
 * @author G5 5590
 */
public class TimeTableSevrlet extends  BaseRBACController {

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
            out.println("<title>Servlet TimeTableSevrlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TimeTableSevrlet at " + request.getContextPath() + "</h1>");
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
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Account account,ArrayList<Role> roles)
            throws ServletException, IOException {
        Date currentDate = new Date();

        int year = currentDate.getYear() + 1900;
        request.setAttribute("curentYear", year);

        WeekTimeTableDBContext db = new WeekTimeTableDBContext();
        List<Integer> listYear = db.getListYearTimeTables();
        request.setAttribute("years", listYear);

 
        
        List<WeekTimeTable> listDayAndMonth = db.getListDayAndMonthTimeTables(year);
        request.setAttribute("dayAndMonth", listDayAndMonth);

        int a;
        if (request.getParameter("weekday") == null) {
            WeekTimeTableDBContext dbc = new WeekTimeTableDBContext();
            a = dbc.getDayAndMonth().getWeekTimeTableID();
            request.setAttribute("dayMonth", a);
        } else {
            a = Integer.parseInt(request.getParameter("weekday"));
            request.setAttribute("dayMonth", Integer.parseInt(request.getParameter("weekday")));
        }

        try {
            java.util.Date startDateUtil = db.getByID(a).getStartDate();
            java.util.Date endDateUtil = db.getByID(a).getEndDate();

            // Chuyển đổi java.util.Date thành java.sql.Date
            java.sql.Date startDate = new java.sql.Date(startDateUtil.getTime());
            java.sql.Date endDate = new java.sql.Date(endDateUtil.getTime());

            List<java.sql.Date> daysInWeek = db.getListDaysInWeek(startDate, endDate);
            request.setAttribute("dates",daysInWeek);

            List<String> daysAndMonths = new ArrayList<>();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM");
            for (java.sql.Date date : daysInWeek) {
                daysAndMonths.add(dateFormat.format(date));
            }
            request.setAttribute("listday", daysAndMonths);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid date format.");
        }

            java.util.Date startDateUtil = db.getByID(a).getStartDate();
            java.util.Date endDateUtil = db.getByID(a).getEndDate();

            // Chuyển đổi java.util.Date thành java.sql.Date
            java.sql.Date startDate = new java.sql.Date(startDateUtil.getTime());
            java.sql.Date endDate = new java.sql.Date(endDateUtil.getTime());

            List<java.sql.Date> daysInWeek = db.getListDaysInWeek(startDate, endDate);
            request.setAttribute("dates",daysInWeek);
         
        CampusDBContext c = new CampusDBContext();
        List<Campus> list = c.listCampus();
        request.setAttribute("campus", list);

        TimeSlotDBContext sbd = new TimeSlotDBContext();
        List<TimeSlot> listSlot = sbd.listSlot();
        request.setAttribute("slots", listSlot);

        SessionDBContext sessionDBContext = new SessionDBContext();
        List<Session> listSessions = sessionDBContext.getSession();
        request.setAttribute("sessions", listSessions);
        request.getRequestDispatcher("viewAttendence/viewTKB.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response, Account account,ArrayList<Role> roles)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
  
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

   

}
