/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mark;

import dao.DBContext;
import dao.timetable.SubjectDBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Assessment;
import model.Grade;

/**
 *
 * @author G5 5590
 */
public class GradeDBContext extends DBContext {

    public ArrayList<Grade> listGrade(int studentID, int subjectID) {
        ArrayList<Grade> lists = new ArrayList();
        String sql = "select sj.SubjectID,a.name,g.weight,c.value from Score as c\n"
                + "inner join Grade as g\n"
                + "On c.assessmentId=g.assessmentId and c.subjectId=g.subjectCode\n"
                + "inner join Assessment as a\n"
                + "On a.aid=c.assessmentId\n"
                + "inner join Subject as sj\n"
                + "On sj.SubjectID= c.subjectId\n"
                + "where c.studentId=? and sj.SubjectID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, studentID);
            st.setInt(2, subjectID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Grade grade = new Grade();
                                             
                Assessment ass= new Assessment();
                grade.setSubjectid(new SubjectDBContext().getByIDSubject(rs.getInt("SubjectID")));
                ass.setName(rs.getString("name"));
                grade.setAssessmentName(rs.getString("name"));
                grade.setWeight(rs.getFloat("weight"));
                grade.setValueScore(rs.getFloat("value"));
                
                lists.add(grade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GradeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

    public static void main(String[] args) {
    GradeDBContext dbContext = new GradeDBContext();
    int studentIDToSearch = 1; 
    int subjectIDToSearch = 24;
    
 
    ArrayList<Grade> grades = dbContext.listGrade(studentIDToSearch, subjectIDToSearch);
    
    if (!grades.isEmpty()) {
      
        System.out.println("Grades for Student ID " + studentIDToSearch + " in Subject ID " + subjectIDToSearch + ":");
        for (Grade grade : grades) {
         
            System.out.println("Value: " + grade.getValueScore());
          
        }
    } else {
     
        System.out.println("No grades found for Student ID " + studentIDToSearch + " in Subject ID " + subjectIDToSearch);
    }
}

}
