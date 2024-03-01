/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.timetable;

import dao.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Room;
import model.TimeSlot;

/**
 *
 * @author G5 5590
 */
public class RoomDBContext extends DBContext {

    public Room getRoomByID(int id) {

        String sql = "select RoomID,RoomName,BuldingName from [Room]\n"
                + "where RoomID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("RoomID"));
                room.setName(rs.getString("RoomName"));
                room.setBuldingName(rs.getString("BuldingName"));

                return room;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
      RoomDBContext c = new RoomDBContext();
        Room semeter = c.getRoomByID(1);
        if (semeter != null) {
            System.out.println("SemeterID: " + semeter.getId());
            System.out.println("SemeterName: " + semeter.getName());
            System.out.println("StartDate: " + semeter.getBuldingName());

        } else {
            System.out.println("Semester not found with ID 1");
        }
    }
}
