/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.timetable;

import dao.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Group;
import model.Subject;

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

    public ArrayList<Group> getSemetersAndSubject(int id) {
        ArrayList<Group> lists = new ArrayList<>();
        String sql = "select DISTINCT s.SubjectID,g.GroupName,a.SemeterID from Subject as s\n"
                + "join Semeter as a\n"
                + "On a.SemeterID=s.SemesterID\n"
                + "join [Group] as g\n"
                + "On g.SubjectID=s.SubjectID\n"
                + "where a.SemeterID=? and g.GroupName='SE1817'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Group group = new Group();
                group.setSubject(new SubjectDBContext().getByIDSubject(rs.getInt("SubjectID")));
                group.setGroupName(rs.getString("GroupName"));
                group.setSemeter(new SemeterDBContext().getByID(rs.getInt("SemeterID")));

                lists.add(group);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

   public static void main(String[] args) {
        // Assume you have initialized your database connection somewhere
        // Connection connection = ...

        // Assume id is the semester ID you want to pass to the method
        int id = 10;

        GroupDBContext dbContext = new GroupDBContext();
        ArrayList<Group> groups = dbContext.getSemetersAndSubject(id);

        for (Group group : groups) {
            System.out.println("Subject ID: " + group.getSubject());
            System.out.println("Group Name: " + group.getGroupName());
            System.out.println("Semester ID: " + group.getSemeter());
            System.out.println(); // For spacing
        }
    }

}
