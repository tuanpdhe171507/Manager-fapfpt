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
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Student> getLitsStudentByID(int id) {
        ArrayList<Student> lits = new ArrayList<>();
        String sql = "Select gr.GroupID from Student as s \n"
                + "INNER join GroupStudent as g\n"
                + "On s.StudentID=g.StudentID \n"
                + "Inner join [Session] as se\n"
                + "On se.GroupID= g.GroupID\n"
                + "Inner join [Group] as gr\n"
                + "On gr.GroupID=se.GroupID\n"
                + "\n"
                + "where se.SessionID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                
                student.setRollNumber(rs.getString("RollNumber"));
                student.setCode(rs.getString("Code"));
                student.setFristName(rs.getString("FirstName"));
                student.setLastName(rs.getString("LastName"));
                student.setImage(rs.getString("Image"));
                student.setGender(rs.getBoolean("Gender"));
                student.setAddress(rs.getString("Address"));
                student.setGroup(new GroupDBContext().getGroupByID(rs.getInt("GroupID")));

                lits.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lits;
    }

      public static void main(String[] args) {
        // Tạo một đối tượng StudentDBContext
        StudentDBContext studentDBContext = new StudentDBContext();

        // Thay đổi biến id thành giá trị thích hợp
        int id = 1;

        // Gọi phương thức getLitsStudentByID
        ArrayList<Student> students = studentDBContext.getLitsStudentByID(id);

        // In ra thông tin về các sinh viên
        for (Student student : students) {
            System.out.println("Student ID: " + student.getId());
            System.out.println("Roll Number: " + student.getRollNumber());
            System.out.println("Code: " + student.getCode());
            System.out.println("First Name: " + student.getFristName());
            System.out.println("Last Name: " + student.getLastName());
            System.out.println("Image: " + student.getImage());
           
            System.out.println("Address: " + student.getAddress());
            System.out.println("Group ID: " + student.getGroup().getGroupID());
            System.out.println("--------------------------------------------");
        }
    }
}
