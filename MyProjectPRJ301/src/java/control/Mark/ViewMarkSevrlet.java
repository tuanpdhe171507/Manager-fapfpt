/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.Mark;

import dao.attendence.StudentDBContext;
import dao.mark.GradeDBContext;
import dao.timetable.SubjectDBContext;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Grade;
import model.Student;
import model.Subject;

/**
 *
 * @author G5 5590
 */
public class ViewMarkSevrlet extends HttpServlet {

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
            out.println("<title>Servlet ViewMarkSevrlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewMarkSevrlet at " + request.getContextPath() + "</h1>");
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
        
        int subjectid = Integer.parseInt(request.getParameter("subjectid1"));
        
        SubjectDBContext subjectDBContext = new SubjectDBContext();
        ArrayList<Subject> sub = subjectDBContext.getlistSubject(subjectid);
        request.setAttribute("si", sub);
     

        int studentid = Integer.parseInt(request.getParameter("studentid"));
        request.setAttribute("subjectid", subjectid);
        request.setAttribute("studentid", studentid);

        GradeDBContext gdb = new GradeDBContext();
        ArrayList<Grade> listGrades = gdb.listGrade(studentid, subjectid);
        request.setAttribute("listGrade", listGrades);
        
        
        float averageScore= gdb.calculateAverage(listGrades);
        request.setAttribute("averageScore", averageScore);
        
        StudentDBContext newBContext= new StudentDBContext();
        Student inforStudent=newBContext.getStudentByID(studentid);
        request.setAttribute("inforstudent", inforStudent);

        request.getRequestDispatcher("viewMark/viewDiemCuaMoiMon.jsp").forward(request, response);
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
