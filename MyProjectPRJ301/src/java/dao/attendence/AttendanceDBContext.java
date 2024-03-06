/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.attendence;

import com.sun.jdi.connect.spi.Connection;
import dao.CampusDBContext;
import dao.DBContext;
import dao.timetable.FuntionVSDBContext;
import dao.timetable.GroupDBContext;
import dao.timetable.GroupStudentDBContext;
import dao.timetable.RoomDBContext;
import dao.timetable.SessionDBContext;
import dao.timetable.SubjectDBContext;
import dao.timetable.TeacherDBContext;
import dao.timetable.TimeSlotDBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendence;
import model.FuntionSV;
import model.Group;
import model.GroupStudent;
import model.Student;

/**
 *
 * @author G5 5590
 */
public class AttendanceDBContext extends DBContext {

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
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

    public ArrayList<Attendence> listAttendencesByID(int seid) {
        ArrayList<Attendence> lists = new ArrayList();
        String sql = "Select AttendenceID,isPresent,RecordTime,Comment,SessionID,StudentID from Attendence \n"
                + "where SessionID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, seid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Attendence attendence = new Attendence();

                attendence.setAttendenceID(rs.getInt("AttendenceID"));
                attendence.setIsPresent(rs.getBoolean("isPresent"));
                attendence.setDatetime(rs.getTimestamp("RecordTime"));
                attendence.setComment(rs.getString("Comment"));
                attendence.setSession(new SessionDBContext().getSessionByID(rs.getInt("SessionID")));
                attendence.setStudent(new StudentDBContext().getStudentByID(rs.getInt("StudentID")));
                lists.add(attendence);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

    public ArrayList<Attendence> getAttendencesByLession(int seid) {
        ArrayList<Attendence> atts = new ArrayList<>();
        try {
            String sql = "Select se.SessionID,s.StudentID,a.isPresent,a.Comment,a.RecordTime from Student as s \n"
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

                a.setSession(new SessionDBContext().getSessionByID(rs.getInt("SessionID")));
                a.setStudent(new StudentDBContext().getStudentByID(rs.getInt("StudentID")));
                a.setIsPresent(rs.getBoolean("isPresent"));
                a.setComment(rs.getString("Comment"));
                a.setDatetime(rs.getTimestamp("RecordTime"));

                atts.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atts;
    }

    public Attendence AttendencesByID(int seid) {

        String sql = "Select AttendenceID,isPresent,RecordTime,Comment,SessionID,StudentID from Attendence \n"
                + "where AttendenceID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, seid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Attendence attendence = new Attendence();

                attendence.setAttendenceID(rs.getInt("AttendenceID"));
                attendence.setIsPresent(rs.getBoolean("isPresent"));
                attendence.setDatetime(rs.getTimestamp("RecordTime"));
                attendence.setComment(rs.getString("Comment"));
                attendence.setSession(new SessionDBContext().getSessionByID(rs.getInt("SessionID")));
                attendence.setStudent(new StudentDBContext().getStudentByID(rs.getInt("StudentID")));
                return attendence;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Attendence> getFuntionList() {
        ArrayList<Attendence> list = new ArrayList();
        String sql = "select se.Date,a.isPresent,b.SubjectID,t.TimeSlotID,r.RoomID from Attendence as a\n"
                + "join Session as se\n"
                + "On a.SessionID=se.SessionID\n"
                + "join [Group]as g\n"
                + "On g.GroupID=se.GroupID\n"
                + "join Subject as b\n"
                + "On b.SubjectID=g.SubjectID\n"
                + "join Student as s\n"
                + "On s.StudentID=a.StudentID\n"
                + "join TimeSlot as t\n"
                + "ON t.TimeSlotID=se.TimeSlotID\n"
                + "join Room as r\n"
                + "On r.RoomID= se.RoomID\n"
                + "where  s.StudentID=13";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Attendence attendence = new Attendence();

                attendence.setDateSQL(rs.getDate("Date"));
                attendence.setIsPresent(rs.getBoolean("isPresent"));
                attendence.setSubject(new SubjectDBContext().getByIDSubject(rs.getInt("SubjectID")));
                attendence.setTimeslot(new TimeSlotDBContext().getTimeSlotByID(rs.getInt("TimeSlotID")));
                attendence.setRoom(new RoomDBContext().getRoomByID(rs.getInt("RoomID")));

                list.add(attendence);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        // Tạo một đối tượng AttendanceDBContext
        AttendanceDBContext context = new AttendanceDBContext();

        // Gọi phương thức getFuntionList() và lưu trữ kết quả vào một danh sách
        ArrayList<Attendence> attendanceList = context.getFuntionList();

        // In ra thông tin từ danh sách
        for (Attendence attendance : attendanceList) {
            System.out.println("Date: " + attendance.getDateSQL());
            System.out.println("Is Present: " + attendance.getIsPresent());
            System.out.println("Subject ID: " + attendance.getSubject().getSubjectID());
            System.out.println("TimeSlot ID: " + attendance.getTimeslot());
            System.out.println("TimeSlot ID: " + attendance.getRoom());
        }
    }

}
