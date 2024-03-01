/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.timetable;

import dao.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Subject;

/**
 *
 * @author G5 5590
 */
public class SubjectDBContext extends DBContext {

    public Subject getByIDSubject(int id) {

        String sql = "select * from [Subject]\n"
                + "where SubjectID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Subject subject = new Subject();
                subject.setSubjectID(rs.getInt("SubjectID"));
                subject.setCode(rs.getString("SubjectCode"));
                subject.setSubjectName(rs.getString("SubjectName"));
                subject.setCredit(rs.getInt("Credit"));
                subject.setSlotNumber(rs.getInt("SlotNumber"));  
                
                subject.setSemester(new SemeterDBContext().getByID(rs.getInt("SemesterID")));
                return subject;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CampusDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public static void main(String[] args) {
    SubjectDBContext c = new SubjectDBContext();
    Subject subject = c.getByIDSubject(1);
    if (subject != null) {
        System.out.println("SemeterID: " + subject.getSubjectID());
        System.out.println("SemeterName: " + subject.getCode());
        System.out.println("StartDate: " + subject.getCredit());
        System.out.println("EndDate: " + subject.getSlotNumber());
          System.out.println("EndDate: " + subject.getSemester());
    } else {
        System.out.println("Semester not found with ID 1");
    }
}
}
