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

    public Session getSessionByID(int id) {

        String sql = "select SessionID,Date,IsTaken,GroupID,TeacherID,RoomID,TimeSlotID\n"
                + "from [Session]"
                + "where SessionID=? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Session session = new Session();
                session.setSessionID(rs.getInt("SessionID"));
                session.setDate(rs.getDate("Date"));
                session.setIsTaken(rs.getBoolean("IsTaken"));
                session.setGroup(new GroupDBContext().getGroupByID(rs.getInt("GroupID")));
                session.setTeacher(new TeacherDBContext().getByTeacherID(rs.getInt("TeacherID")));
                session.setRoom(new RoomDBContext().getRoomByID(rs.getInt("RoomID")));
                session.setTimeslot(new TimeSlotDBContext().getTimeSlotByID(rs.getInt("TimeSlotID")));

                return session;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

   
//    public static void main(String[] args) {
//        // Tạo một đối tượng SessionDBContext
//        SessionDBContext sessionDBContext = new SessionDBContext();
//
//        // Thay đổi biến id thành giá trị thích hợp
////        int id = 1;
////
////        // Gọi phương thức getSessionByID
////        Session session = sessionDBContext.getSessionByID(id);
////
////        // Kiểm tra xem session có tồn tại hay không
////        if (session != null) {
////            System.out.println("Session ID: " + session.getSessionID());
////            System.out.println("Date: " + session.getDate().toString().trim());
////            System.out.println("Is Taken: " + session.getIsTaken().toString().trim());
////            System.out.println("Group ID: " + session.getGroup().toString().trim());
////            System.out.println("Teacher ID: " + session.getTeacher().toString().trim());
////
////        } else {
////            System.out.println("Session not found.");
////        }
//          
//    }
     public static void main(String[] args) {
        // Tạo một đối tượng SessionDBContext
        SessionDBContext sessionDBContext = new SessionDBContext();

        // Gọi phương thức getSession
        ArrayList<Session> sessions = sessionDBContext.getSession();

        // In ra thông tin về các session
        for (Session session : sessions) {
          
            System.out.println("Date: " + session.getDate());
            
        }
    }

}
