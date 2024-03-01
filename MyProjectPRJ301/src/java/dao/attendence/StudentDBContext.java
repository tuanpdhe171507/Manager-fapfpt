/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.attendence;

import dao.*;
import dao.timetable.GroupDBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Group;
import model.Semeter;
import model.Student;
import model.WeekTimeTable;

/**
 *
 * @author G5 5590
 */
public class StudentDBContext extends DBContext {

    public Student getStudentByID(int id) {

        String sql = "select* from[Student]\n"
                + "where StudentID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("StudentID"));
                student.setRollNumber(rs.getString("RollNumber"));
                student.setCode(rs.getString("Code"));
                student.setFristName(rs.getString("FirstName"));
                student.setLastName(rs.getString("LastName"));
                student.setImage(rs.getString("Image"));
                student.setGender(rs.getBoolean("Gender"));
                student.setAddress(rs.getString("Address"));
                student.setGroup(new GroupDBContext().getGroupByID(rs.getInt("GroupID")));

                return student;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CampusDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

   

    public static void main(String[] args) {
        StudentDBContext c = new StudentDBContext();
        Student subject = c.getStudentByID(9);
        if (subject != null) {
            System.out.println("SemeterID: " + subject.getId());
            System.out.println("SemeterName: " + subject.getRollNumber());
            System.out.println("StartDate: " + subject.getCode());
            System.out.println("EndDate: " + subject.getFristName());
            System.out.println("EndDate: " + subject.getLastName());

        } else {
            System.out.println("Semester not found with ID 1");
        }
    }
}
