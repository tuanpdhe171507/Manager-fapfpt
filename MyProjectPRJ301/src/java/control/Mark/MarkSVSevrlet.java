/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.Mark;

import dao.mark.GradeDBContext;
import dao.timetable.GroupDBContext;
import dao.timetable.SemeterDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Grade;
import model.Group;
import model.Semeter;

/**
 *
 * @author G5 5590
 */
public class MarkSVSevrlet extends HttpServlet {

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
            out.println("<title>Servlet MarkSVSevrlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MarkSVSevrlet at " + request.getContextPath() + "</h1>");
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

        if (lists != null) {
            //int id = Integer.parseInt(request.getParameter("semeterId"));
            GroupDBContext groupDBContext = new GroupDBContext();
            ArrayList<Group> listSe2 = groupDBContext.getSemetersAndSubject(10);
            request.setAttribute("listSubject", listSe2);

        }
        if (request.getParameter("semeterId1ff")!=null) {
            int id1 = Integer.parseInt(request.getParameter("semeterId1ff"));
            GradeDBContext gdb = new GradeDBContext();
            ArrayList<Grade> listGrades = gdb.listGrade(13, id1);
            request.setAttribute("listGrade", listGrades);

            float averageScore = gdb.calculateAverage(listGrades);
            request.setAttribute("averageScore", averageScore);
        }

        request.getRequestDispatcher("viewMarkSv/mark.jsp").forward(request, response);
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

        request.getRequestDispatcher("viewMarkSv/mark.jsp").forward(request, response);
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
