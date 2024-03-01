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
import model.Group;

/**
 *
 * @author G5 5590
 */
public class GroupDBContext extends DBContext {

    public Group getGroupByID(int id) {

        String sql = "select * from [Group]\n"
                + "where GroupID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Group group = new Group();
                group.setGroupID(rs.getInt("GroupID"));
                group.setGroupName(rs.getString("GroupName"));
                group.setSubject(new SubjectDBContext().getByIDSubject(rs.getInt("SubjectID")));
                group.setTeacher(new TeacherDBContext().getByTeacherID(rs.getInt("TeacherID")));
                return group;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        GroupDBContext c = new GroupDBContext();
        Group subject = c.getGroupByID(1);
        if (subject != null) {
            System.out.println("SemeterID: " + subject.getGroupID());
            System.out.println("SemeterName: " + subject.getGroupName());
            System.out.println("StartDate: " + subject.getSubject());
            System.out.println("EndDate: " + subject.getTeacher());

        } else {
            System.out.println("Semester not found with ID 1");
        }
    }

}
