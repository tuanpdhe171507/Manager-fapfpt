/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.timetable;

import dao.*;
import dao.attendence.AttendanceDBContext;
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

    public ArrayList<Session> getSessionByStudentidAndSubjectid(int id) {
        ArrayList<Session> list = new ArrayList();
        String sql = "select se.Date,se.IsTaken,t.TimeSlotID,r.RoomID,g.GroupID,te.TeacherID from Session as se\n"
                + "join Student as s\n"
                + "ON s.StudentID=se.StudentID\n"
                + "join [Group] as g\n"
                + "On g.GroupID=se.GroupID\n"
                + "join Subject as a\n"
                + "ON a.SubjectID=g.SubjectID\n"
                + "Join TimeSlot as t\n"
                + "ON t.TimeSlotID=se.TimeSlotID\n"
                + "join Room as r\n"
                + "ON r.RoomID=se.RoomID\n"
                + "join Teacher as te\n"
                + "On te.TeacherID=se.TeacherID\n"
                + "where a.SubjectID=? and s.StudentID=13";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Session session = new Session();

                session.setDate(rs.getDate("Date"));
                session.setIsTaken(rs.getBoolean("IsTaken"));
                session.setTimeslot(new TimeSlotDBContext().getTimeSlotByID(rs.getInt("TimeSlotID")));
                session.setRoom(new RoomDBContext().getRoomByID(rs.getInt("RoomID")));
                session.setGroup(new GroupDBContext().getGroupByID(rs.getInt("GroupID")));
                session.setTeacher(new TeacherDBContext().getByTeacherID(rs.getInt("TeacherID")));

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

    public static void main(String[] args) {
        // Tạo một đối tượng SessionDBContext
        SessionDBContext sessionDBContext = new SessionDBContext();

        // Gọi phương thức getSession
        ArrayList<Session> sessions = sessionDBContext.getSessionByStudentidAndSubjectid(22);

        // In ra thông tin về các session
        for (Session session : sessions) {

            System.out.println("Date: " + session.getDate());

        }
    }

}
