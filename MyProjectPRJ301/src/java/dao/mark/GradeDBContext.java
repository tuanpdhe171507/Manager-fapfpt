/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mark;

import dao.DBContext;
import dao.attendence.StudentDBContext;
import dao.timetable.SubjectDBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Grade;


/**
 *
 * @author G5 5590
 */
public class GradeDBContext extends DBContext {

    public ArrayList<Grade> listGrade(int studentID) {
        ArrayList<Grade> lists = new ArrayList();
        String sql = "select a.GradeID,a.Comment,a.Score,a.AssesmentID,a.SubjectID,a.StudentID from Grade as a\n"
                + "where a.StudentID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, studentID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Grade grade = new Grade();

                grade.setId(rs.getInt("GradeID"));
                grade.setComent(rs.getString("Comment"));
                grade.setScore(rs.getFloat("Score"));
                grade.setAssessmentID(new AssessmentDBContext().listAssessment(rs.getInt("AssesmentID")));
                grade.setSubjectID(new SubjectDBContext().getByIDSubject(rs.getInt("SubjectID")));
                grade.setStudentID(new StudentDBContext().getStudentByID(rs.getInt("StudentID")));
                lists.add(grade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GradeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }
    
      public static void main(String[] args) {
       
        GradeDBContext studentDBContext = new GradeDBContext();

    
        int studentIDToCheck = 1;

     
        ArrayList<Grade> grades = studentDBContext.listGrade(studentIDToCheck);

       
        for (Grade grade : grades) {
            System.out.println("Grade ID: " + grade.getId());
            System.out.println("Comment: " + grade.getComent());
            System.out.println("Score: " + grade.getScore());
            System.out.println("Assessment: " + grade.getAssessmentID().getName()); // In ra tên của bài đánh giá
            System.out.println("Subject: " + grade.getSubjectID()); // In ra tên của môn học
            System.out.println("Student: " + grade.getStudentID()); // In ra tên của sinh viên
            System.out.println("----------------------------------");
        }
    }

}
