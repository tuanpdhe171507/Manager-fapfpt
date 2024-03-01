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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendence;
import model.Group;
import model.Session;
import model.Student;
import model.Subject;
import org.apache.catalina.users.AbstractGroup;

/**
 *
 * @author G5 5590
 */
public class SessionDBContext extends DBContext {

    public ArrayList<Session> getSession() {
        ArrayList<Session> list = new ArrayList();
        String sql = "select SessionID,Date,IsTaken,GroupID,TeacherID,RoomID,TimeSlotID\n"
                + "from [Session]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Session session = new Session();
                session.setSessionID(rs.getInt("SessionID"));
                session.setDate(rs.getDate("Date"));
                session.setIsTaken(rs.getBoolean("IsTaken"));
                session.setGroup(new GroupDBContext().getGroupByID(rs.getInt("GroupID")));
                session.setTeacher(new TeacherDBContext().getByTeacherID(rs.getInt("TeacherID")));
                session.setRoom(new RoomDBContext().getRoomByID(rs.getInt("RoomID")));
                session.setTimeslot(new TimeSlotDBContext().getTimeSlotByID(rs.getInt("TimeSlotID")));

                list.add(session);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Attendence> getAttendencesByLession(int seid) {
        ArrayList<Attendence> atts = new ArrayList<>();
        try {
            String sql = "Select s.StudentID,gr.GroupName,s.RollNumber,s.LastName,s.FirstName,a.isPresent,a.Comment,s.[Image] from Student as s \n"
                    + "INNER join GroupStudent as g\n"
                    + "On s.StudentID=g.StudentID \n"
                    + "Inner join [Session] as se\n"
                    + "On se.GroupID= g.GroupID\n"
                    + "Inner join [Group] as gr\n"
                    + "On gr.GroupID=se.GroupID\n"
                    + "Left join [Attendence]as a\n"
                    + "On a.SessionID=se.SessionID and s.StudentID=a.StudentID\n"
                    + "where se.SessionID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, seid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendence a = new Attendence();
                Student s = new Student();
                Session ses = new Session();
                Group group= new Group();
                
                s.setId(rs.getInt("StudentID"));
                group.setGroupName(rs.getString("GroupName"));
                s.setGroup(group);
                             
                s.setRollNumber(rs.getString("RollNumber"));
                s.setLastName("LastName");
                s.setFristName(rs.getString("FirstName"));
                
                
                a.setIsPresent(rs.getBoolean("isPresent"));
                a.setComment(rs.getString("Comment"));
                s.setImage(rs.getString("Image"));
                a.setStudent(s);
                
                
                if (a.getAttendenceID()!= 0) {
//                    a.setDescription(rs.getString("description"));
//                    a.setPresent(rs.getBoolean("isPresent"));
//                    a.setTime(rs.getTimestamp("capturedtime"));
                }
                atts.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atts;
    }

    public static void main(String[] args) {
        // Tạo một đối tượng SessionDBContext
        SessionDBContext sessionDBContext = new SessionDBContext();

        // Thay đổi biến seid thành giá trị thích hợp
        int seid = 1;

        // Gọi phương thức getAttendencesByLession
        ArrayList<Attendence> attendences = sessionDBContext.getAttendencesByLession(seid);

        // In ra thông tin về các điểm danh
        for (Attendence attendance : attendences) {
            System.out.println("Student ID: " + attendance.getStudent().getId());
            System.out.println("Group Name: " + attendance.getStudent().getGroup().getGroupName());
            System.out.println("Roll Number: " + attendance.getStudent().getRollNumber());
            System.out.println("Last Name: " + attendance.getStudent().getLastName());
            System.out.println("First Name: " + attendance.getStudent().getFristName());
            System.out.println("Is Present: " + attendance.getIsPresent());
            System.out.println("Comment: " + attendance.getComment());
            System.out.println("Image: " + attendance.getStudent().getImage());
            System.out.println("--------------------------------------------");
        }
    }
}
