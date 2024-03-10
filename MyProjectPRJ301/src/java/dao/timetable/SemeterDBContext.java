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

    public ArrayList<Semeter> getSemetersByName() {
        ArrayList<Semeter> lists = new ArrayList<>();
        String sql = "select s.SemeterID, s.SemeterName,s.StartDate,s.EndDate from Semeter as s\n"
                + "where s.SemeterID >=3 and s.SemeterID<=10";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Semeter semeter = new Semeter();
                semeter.setSemeterID(rs.getInt("SemeterID"));
                semeter.setSemeterName(rs.getString("SemeterName"));
                semeter.setStartDate(rs.getDate("StartDate"));
                semeter.setEndDate(rs.getDate("EndDate"));
                lists.add(semeter);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemeterDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

   
    public static void main(String[] args) {
        SemeterDBContext dbContext = new SemeterDBContext(); // Tạo một instance của lớp SemeterDBContext

        // Gọi phương thức để lấy danh sách Semester từ cơ sở dữ liệu
        ArrayList<Semeter> semesters = dbContext.getSemetersByName();

        // In ra thông tin của các Semester được trả về
        for (Semeter semester : semesters) {
            System.out.println("Semester ID: " + semester.getSemeterID());
            System.out.println("Semester Name: " + semester.getSemeterName());
            System.out.println("Start Date: " + semester.getStartDate());
            System.out.println("End Date: " + semester.getEndDate());
            System.out.println("----------------------------");
        }
    }

}
