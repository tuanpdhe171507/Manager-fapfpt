/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.timetable;

import dao.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Group;
import model.Semeter;
import model.Session;

/**
 *
 * @author G5 5590
 */
public class SemeterDBContext extends DBContext {

    public Semeter getByID(int id) {

        String sql = "select * from [Semeter]\n"
                + "where SemeterID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Semeter semeter = new Semeter();
                semeter.setSemeterID(rs.getInt("SemeterID"));
                semeter.setSemeterName(rs.getString("SemeterName"));
                semeter.setStartDate(rs.getDate("StartDate"));
                semeter.setEndDate(rs.getDate("EndDate"));
                return semeter;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CampusDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
    SemeterDBContext c = new SemeterDBContext();
    Semeter semeter = c.getByID(1);
    if (semeter != null) {
        System.out.println("SemeterID: " + semeter.getSemeterID());
        System.out.println("SemeterName: " + semeter.getSemeterName());
        System.out.println("StartDate: " + semeter.getStartDate());
        System.out.println("EndDate: " + semeter.getEndDate());
    } else {
        System.out.println("Semester not found with ID 1");
    }
}
}
