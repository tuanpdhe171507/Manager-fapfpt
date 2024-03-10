/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Students;
import java.sql.*;
import model.Classes;
/**
 *
 * @author G5 5590
 */
public class StudentDBContext extends DBContext {

    public ArrayList<Students> getLitsStudent() {
        ArrayList<Students> lits = new ArrayList<>();
        String sql = "select s.StudentID,s.StudentName,s.BirthDate,s.Gender,s.ClassID from Students as s";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Students student = new Students();
                student.setStudentID(rs.getString("StudentID"));
                student.setStudentName(rs.getString("StudentName"));
                student.setBithDay(rs.getDate("BirthDate"));
                student.setGender(rs.getBoolean("Gender"));
                student.setClassID(new ClassDBContext().getByIDSubject(rs.getInt("ClassID")));

                lits.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lits;
    }

    public Students getLitsStudentByID(String id) {

        String sql = "select s.StudentID,s.StudentName,s.BirthDate,s.Gender,s.ClassID from Students as s\n"
                + "where s.StudentID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
           st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Students student = new Students();
                student.setStudentID(rs.getString("StudentID"));
                student.setStudentName(rs.getString("StudentName"));
                student.setBithDay(rs.getDate("BirthDate"));
                student.setGender(rs.getBoolean("Gender"));
                student.setClassID(new ClassDBContext().getByIDSubject(rs.getInt("ClassID")));

                return student;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void update(Students entity) {
        try {
            String sql = "UPDATE [Students]\n"
                    + "SET [StudentName] = ?,\n"
                    + "    [BirthDate] = ?,\n"
                    + "    [Gender] = ?,\n"
                    + "    [ClassID] = ?\n"
                    + "WHERE [StudentID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(5, entity.getStudentID());
            stm.setString(1, entity.getStudentName());
            stm.setDate(2, entity.getBithDay());
            stm.setBoolean(3, entity.isGender());
            stm.setInt(4, entity.getClassID().getClassid());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public static void main(String[] args) {
        // Tạo một đối tượng sinh viên mới để cập nhật
        Students studentToUpdate = new Students();
        studentToUpdate.setStudentID("SE05150"); // Xác định ID của sinh viên cần cập nhật
        studentToUpdate.setStudentName("John Doe"); // Tên mới của sinh viên
        studentToUpdate.setBithDay(Date.valueOf("2000-01-01")); // Ngày sinh mới của sinh viên
        studentToUpdate.setGender(true); // Giới tính mới của sinh viên (true = nam, false = nữ)

        // Giả sử classID của sinh viên cần cập nhật là 1
        Classes classToUpdate = new Classes();
        classToUpdate.setClassid(2); // Xác định ID của lớp mới của sinh viên
        studentToUpdate.setClassID(classToUpdate); // Gán lớp mới cho sinh viên

        // Tạo một đối tượng StudentDBContext
        StudentDBContext dbContext = new StudentDBContext();

        // Gọi phương thức update để cập nhật thông tin sinh viên trong cơ sở dữ liệu
        dbContext.update(studentToUpdate);

        System.out.println("Student updated successfully!");
    }
}
