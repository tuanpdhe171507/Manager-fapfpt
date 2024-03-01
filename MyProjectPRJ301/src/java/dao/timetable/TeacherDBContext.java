/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.timetable;

import dao.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Semeter;
import model.Teacher;

/**
 *
 * @author G5 5590
 */
public class TeacherDBContext extends DBContext {

    public Teacher getByTeacherID(int id) {

        String sql = "select * from[Teacher]\n"
                + "where TeacherID=?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeacherID(rs.getInt("TeacherID"));
                teacher.setCode(rs.getString("Code"));
                teacher.setFristName(rs.getString("FristName"));
                teacher.setLastName(rs.getString("lastName"));
                teacher.setPhoneNumber(rs.getString("PhoneNumber"));
                teacher.setEmailAddress(rs.getString("EmailAddress"));
                return teacher;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CampusDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) {
    TeacherDBContext c = new TeacherDBContext();
    Teacher semeter = c.getByTeacherID(1);
    if (semeter != null) {
        System.out.println("SemeterID: " + semeter.getTeacherID());
        System.out.println("SemeterName: " + semeter.getCode());
       
    } else {
        System.out.println("Semester not found with ID 1");
    }
}
}
