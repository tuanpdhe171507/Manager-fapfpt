/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.Mark;

import dao.attendence.StudentDBContext;
import dao.mark.GradeDBContext;
import dao.timetable.GroupDBContext;
import dao.timetable.SemeterDBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Grade;
import model.Group;
import model.Semeter;
import model.Student;

/**
 *
 * @author G5 5590
 */
public class MarkSevrlet extends HttpServlet {

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

        String stid = request.getParameter("studentid");
        String stu = request.getParameter("studentID");
        if (stu == null) {

            request.setAttribute("studentID", stid);
        } else {

            StudentDBContext sb = new StudentDBContext();
            int studentids = Integer.parseInt(stu);
            Student s = sb.getStudentByID(studentids);
            request.setAttribute("s", s);
            request.setAttribute("studentID", stu);
        }

        if (request.getParameter("semeterId1ff") != null) {

            int id1 = Integer.parseInt(request.getParameter("semeterId1ff"));
            int studentid = Integer.parseInt(request.getParameter("studentID"));
            GradeDBContext gdb = new GradeDBContext();

            ArrayList<Grade> listGrades = gdb.listGrade(studentid, id1);
            request.setAttribute("listGrade", listGrades);

            float averageScore = gdb.calculateAverage(listGrades);
            request.setAttribute("averageScore", averageScore);
        }


        request.getRequestDispatcher("viewMark/markViewLecture.jsp").forward(request, response);
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

        String stid = request.getParameter("studentid");

        String stu = request.getParameter("studentID");
        if (stu == null) {
            request.setAttribute("studentID", stid);
        } else {
//            StudentDBContext sb = new StudentDBContext();
//            int studentids = Integer.parseInt(stu);
//            Student s = sb.getStudentByID(studentids);
//            request.setAttribute("s", s);
            request.setAttribute("studentID", stu);
        }
         response.sendRedirect("mark");
        //request.getRequestDispatcher("viewMark/markViewLecture.jsp").forward(request, response);
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
