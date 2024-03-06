/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.timetable;

import dao.DBContext;
import dao.attendence.AttendanceDBContext;
import dao.attendence.StudentDBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FuntionSV;

/**
 *
 * @author G5 5590
 */
public class FuntionVSDBContext extends DBContext {

    public ArrayList<FuntionSV> getFuntionList() {
        ArrayList<FuntionSV> list = new ArrayList();
        String sql = "select se.Date,b.SubjectCode,t.TimeStart,t.TimeEnd from Attendence as a\n"
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
                + "where  s.StudentID=13";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                FuntionSV funtionSV = new FuntionSV();
                funtionSV.setFuntionsvID(rs.getInt("FuntionsvID"));
                funtionSV.setDate(rs.getDate("Date"));
                funtionSV.setStudentid(new StudentDBContext().getStudentByID(rs.getInt("StudentID")));
                funtionSV.setRoom(new RoomDBContext().getRoomByID(rs.getInt("RoomID")));
                funtionSV.setSubject(new SubjectDBContext().getByIDSubject(rs.getInt("SubjectID")));
                funtionSV.setTimeSlot(new TimeSlotDBContext().getTimeSlotByID(rs.getInt("TimeSlotID")));
                funtionSV.setAttendence(new AttendanceDBContext().AttendencesByID(rs.getInt("AttendanceID")));

                list.add(funtionSV);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuntionVSDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        FuntionVSDBContext funtionVSDBContext = new FuntionVSDBContext();
        ArrayList<FuntionSV> funtionList = funtionVSDBContext.getFuntionList();

        // In ra danh sách các FunctionSV
        for (FuntionSV funtionSV : funtionList) {
            System.out.println("FunctionSV ID: " + funtionSV.getFuntionsvID());
            System.out.println("Date: " + funtionSV.getDate());
            System.out.println("Student ID: " + funtionSV.getStudentid());
            System.out.println("Room ID: " + funtionSV.getRoom());
            System.out.println("Subject ID: " + funtionSV.getSubject().getSubjectID());
            System.out.println("TimeSlot ID: " + funtionSV.getTimeSlot());

            System.out.println("------------------------------------");
        }
    }
}
