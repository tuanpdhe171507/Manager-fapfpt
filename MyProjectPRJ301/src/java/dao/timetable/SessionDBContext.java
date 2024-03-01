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
import model.Session;
import model.Subject;

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
   
    public static void main(String[] args) {
        SessionDBContext sessionDBContext = new SessionDBContext();
        ArrayList<Session> sessions = sessionDBContext.getSession();
        
        // Print out the retrieved sessions
        for (Session session : sessions) {
            System.out.println("Session ID: " + session.getSessionID());
            System.out.println("Date: " + session.getDate());
            System.out.println("IsTaken: " + session.getIsTaken());
            System.out.println("Group: " + session.getGroup());
            System.out.println("Teacher: " + session.getTeacher());
            System.out.println("Room: " + session.getRoom());
            System.out.println("Time Slot: " + session.getTimeslot());
            System.out.println("--------------------------");
        }
    }   
}
