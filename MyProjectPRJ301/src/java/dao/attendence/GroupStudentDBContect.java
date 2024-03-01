/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.attendence;

import com.sun.jdi.connect.spi.Connection;
import dao.CampusDBContext;
import dao.DBContext;
import dao.timetable.GroupDBContext;
import dao.timetable.SubjectDBContext;
import dao.timetable.TeacherDBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Group;
import model.GroupStudent;
import model.Student;

/**
 *
 * @author G5 5590
 */
public class GroupStudentDBContect extends DBContext {

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

    public ArrayList<GroupStudent> listGroupStudentByID(int groupID) {
        ArrayList<GroupStudent> lists = new ArrayList();
        String sql = "Select GroupStudentID,GroupID,StudentID from GroupStudent\n"
                + "where GroupID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, groupID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                GroupStudent student = new GroupStudent();

                student.setGroupStudentID(rs.getInt("GroupStudentID"));
                student.setGroup(new GroupDBContext().getGroupByID(rs.getInt("GroupID")));
                student.setStudent(new StudentDBContext().getStudentByID(rs.getInt("StudentID")));
                lists.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupStudentDBContect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

    public static void main(String[] args) {

        GroupStudentDBContect db = new GroupStudentDBContect();
        ArrayList<GroupStudent> students = db.listGroupStudentByID(15);

        // Displaying the retrieved students
        for (GroupStudent student : students) {
            System.out.println("GroupStudentID: " + student.getGroupStudentID()
                    + ", GroupID: " + student.getGroup()
                    + ", StudentID: " + student.getStudent());
        }
    }

}
