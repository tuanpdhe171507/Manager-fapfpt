/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.Attendence;

import dao.attendence.AttendanceDBContext;
import dao.attendence.StudentDBContext;
import dao.timetable.SessionDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Attendence;
import model.Session;
import model.Student;

/**
 *
 * @author G5 5590
 */
public class AttendenceSevrlet extends HttpServlet {

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
            out.println("<title>Servlet AttendenceSevrlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AttendenceSevrlet at " + request.getContextPath() + "</h1>");
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

        SessionDBContext sdb = new SessionDBContext();

        AttendanceDBContext adb = new AttendanceDBContext();
        int sesid = Integer.parseInt(request.getParameter("sesid"));
        ArrayList<Attendence> list = adb.getAttendencesByLession(sesid);
        request.setAttribute("listStudents", list);

        ArrayList<Session> listSession = sdb.getSession();
        request.setAttribute("sesid", sesid);
        request.setAttribute("listSession", listSession);

        request.getRequestDispatcher("viewAttendence/viewAttendance.jsp").forward(request, response);
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

//        SessionDBContext sdb = new SessionDBContext();
//       
//
//        String[] studentid = request.getParameterValues("id");
//
//        int sesid = Integer.parseInt(request.getParameter("sesionid"));
//
//        ArrayList<Attendence> atts = new ArrayList<>();
//
//        for (int i = 0; i < studentid.length; i++) {
//            Student student = new Student();
//            student.setId(i);
//            Session session = new Session();
//            Attendence attendence = new Attendence();
//            attendence.setStudent(student);
//            session.setSessionID(sesid);
//            attendence.setSession(session);
//            attendence.setComment(request.getParameter("description" + studentid[i]));
//            attendence.setIsPresent(request.getParameter("present" + studentid[i]).equals("yes"));
//            atts.add(attendence);
//
//        }
//        sdb.takeAttendances(sesid, atts);
        int leid = Integer.parseInt(request.getParameter("id"));
        StudentDBContext db = new StudentDBContext();
        ArrayList<Student> students = db.getLitsStudentByID(leid);
        ArrayList<Attendence> atts = new ArrayList<>();
        Session lession = new Session();
        lession.setSessionID(leid);
        for (Student student : students) {
            Attendence a = new Attendence();
            a.setSession(lession);
            a.setStudent(student);
            a.setComment(request.getParameter("description"+student.getId()));
            a.setIsPresent(request.getParameter("present"+student.getId()).equals("yes"));
            atts.add(a);
        }
        db.takeAttendances(leid, atts);

        AttendanceDBContext adb= new AttendanceDBContext();
        ArrayList<Attendence> lists= adb.listAttendencesByID(leid);
        request.setAttribute("listStudentAddtendence", lists);
        
        request.getRequestDispatcher("viewAttendence/showSVAttendance.jsp").forward(request, response);
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
