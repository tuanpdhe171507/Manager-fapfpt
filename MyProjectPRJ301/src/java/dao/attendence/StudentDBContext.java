/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.attendence;

import dao.*;
import dao.timetable.GroupDBContext;
import dao.timetable.SessionDBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendence;
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
     public void takeAttendances(int seid, ArrayList<Attendence> atts) {
        try {
            connection.setAutoCommit(false);
            String sql_remove_atts = "delete from Attendence where SessionID=?";
            PreparedStatement stm_remove_atts = connection.prepareStatement(sql_remove_atts);
            stm_remove_atts.setInt(1, seid);
            stm_remove_atts.executeUpdate();

            for (Attendence att : atts) {
                String sql_insert_att = "INSERT INTO [Attendence](isPresent,Comment,SessionID,StudentID,RecordTime)\n"
                        + "values(?,?,?,?,GETDATE())";
                PreparedStatement stm_insert_att = connection.prepareStatement(sql_insert_att);
                stm_insert_att.setBoolean(1,att.getIsPresent());
                stm_insert_att.setString(2, att.getComment());
                stm_insert_att.setInt(3, seid);
                stm_insert_att.setInt(4, att.getStudent().getId());
                stm_insert_att.executeUpdate();
            }

            String sql_update_lession = "UPDATE Session SET IsTaken =1 where SessionID=?";
            PreparedStatement stm_update_lession = connection.prepareStatement(sql_update_lession);
            stm_update_lession.setInt(1, seid);
            stm_update_lession.executeUpdate();

            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }


    public ArrayList<Student> getLitsStudentByID(int id) {
        ArrayList<Student> lits = new ArrayList<>();
        String sql = "Select s.StudentID,s.Code,s.RollNumber,s.LastName,s.FirstName,s.Address,s.Gender,s.GroupID,s.Image from Student as s \n"
                + "INNER join GroupStudent as g\n"
                + "On s.StudentID=g.StudentID \n"
                + "Inner join [Session] as se\n"
                + "On se.GroupID= g.GroupID\n"
                + "Inner join [Group] as gr\n"
                + "On gr.GroupID=se.GroupID\n"
                + "where se.SessionID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
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
