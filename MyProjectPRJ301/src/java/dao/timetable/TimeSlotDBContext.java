/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.timetable;

import dao.CampusDBContext;
import dao.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Semeter;
import model.TimeSlot;

/**
 *
 * @author G5 5590
 */
public class TimeSlotDBContext extends DBContext {

    public TimeSlot getTimeSlotByID(int id) {

        String sql = "Select TimeSlotID,SlotName,TimeStart,TimeEnd from TimeSlot\n"
                + "where TimeSlotID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                TimeSlot timeSlot = new TimeSlot();
                timeSlot.setId(rs.getInt("TimeSlotID"));
                timeSlot.setName(rs.getString("SlotName"));
                timeSlot.setTimeStart(rs.getString("TimeStart"));
                timeSlot.setTimeEnd(rs.getString("TimeEnd"));

                return timeSlot;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimeSlotDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<TimeSlot> listSlot() {
        ArrayList<TimeSlot> lits = new ArrayList();
        String sql = "Select TimeSlotID,SlotName,TimeStart,TimeEnd from TimeSlot";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TimeSlot timeSlot= new TimeSlot();
                timeSlot.setId(rs.getInt("TimeSlotID"));
                timeSlot.setName(rs.getString("SlotName"));
                timeSlot.setTimeStart(rs.getString("TimeStart"));
                timeSlot.setTimeEnd(rs.getString("TimeEnd"));
                lits.add(timeSlot);
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(CampusDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lits;
    }

    

    public static void main(String[] args) {
        TimeSlotDBContext c = new TimeSlotDBContext();
        TimeSlot semeter = c.getTimeSlotByID(1);
        if (semeter != null) {
            System.out.println("SemeterID: " + semeter.getName());
            System.out.println("SemeterName: " + semeter.getTimeStart());
            System.out.println("StartDate: " + semeter.getTimeEnd());

        } else {
            System.out.println("Semester not found with ID 1");
        }
    }
}
