/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.timetable;

import dao.DBContext;
import dao.attendence.StudentDBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GroupStudent;

/**
 *
 * @author G5 5590
 */
public class GroupStudentDBContext extends DBContext{
     public GroupStudent getGroupStudentByID(int id) {

        String sql = "Select GroupStudentID,GroupID,StudentID from GroupStudent\n"
                + "where GroupStudentID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                GroupStudent group = new GroupStudent();
                group.setGroupStudentID(rs.getInt("GroupStudentID"));
                group.setGroup(new GroupDBContext().getGroupByID(rs.getInt("GroupID")));
                group.setStudent(new StudentDBContext().getStudentByID(rs.getInt("StudentID")));

                return group;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
