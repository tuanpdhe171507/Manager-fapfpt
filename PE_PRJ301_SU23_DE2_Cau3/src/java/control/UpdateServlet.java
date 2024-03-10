/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.ClassDBContext;
import dao.StudentDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Classes;
import model.Students;
import java.sql.*;

/**
 *
 * @author G5 5590
 */
public class UpdateServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String id= req.getParameter("code");
       String name=req.getParameter("name");
       String dateofBirth=req.getParameter("date");
      
       String classes= req.getParameter("did");
       
       Classes classes1= new Classes();
       Students students= new Students();
       classes1.setClassid(Integer.parseInt(classes));
       
       students.setStudentID(id);
       students.setStudentName(name);
       students.setBithDay(Date.valueOf(dateofBirth));
       students.setGender(req.getParameter("gender").equals("male"));
       students.setClassID(classes1);
       
       StudentDBContext studentDBContext= new StudentDBContext();
       studentDBContext.update(students);
        resp.sendRedirect("list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         StudentDBContext bContext= new StudentDBContext();
        ArrayList<Students> list= bContext.getLitsStudent();
        req.setAttribute("lists", list);
        
       String idStudent= req.getParameter("id");
        StudentDBContext studentDBContext= new StudentDBContext();
        Students students=studentDBContext.getLitsStudentByID(idStudent);
        req.setAttribute("liststu", students);
       
        
        
        ClassDBContext classDBContext= new ClassDBContext();
        ArrayList<Classes> listClass= classDBContext.getListClasses();
        req.setAttribute("listClass", listClass);
        
         req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
    
}
