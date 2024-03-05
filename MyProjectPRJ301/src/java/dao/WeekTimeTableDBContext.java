/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.timetable.GroupDBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.WeekTimeTable;

/**
 *
 * @author G5 5590
 */
public class WeekTimeTableDBContext extends DBContext {

    public ArrayList<Integer> getListYearTimeTables() {
        ArrayList<Integer> yearList = new ArrayList();
        String sql = "select YEAR(min(StartDate)) as minYear,YEAR(max(EndDate)) as maxYear from WeekTimeTable";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int minYear = rs.getInt("minYear");
                int maxYear = rs.getInt("maxYear");

                for (int i = minYear; i <= maxYear; i++) {
                    yearList.add(i);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(CampusDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return yearList;
    }

    public ArrayList<WeekTimeTable> getListDayAndMonthTimeTables(int year) {
        ArrayList<WeekTimeTable> dayAndMonth = new ArrayList();
        String sql = "SELECT WeekTimeTableID,StartDate, EndDate FROM WeekTimeTable\n"
                + "                WHERE YEAR(StartDate) >= ? AND YEAR(EndDate) <= ?\n"
                + "                Order by WeekTimeTableID ASC;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, year);
            st.setInt(2, year);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                WeekTimeTable timeTable = new WeekTimeTable();
                timeTable.setWeekTimeTableID(rs.getInt("WeekTimeTableID"));
                timeTable.setStartDate(rs.getDate("StartDate"));
                timeTable.setEndDate(rs.getDate("EndDate"));
                dayAndMonth.add(timeTable);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CampusDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dayAndMonth;
    }

    public WeekTimeTable getDayAndMonth() {
        String sql = "SELECT WeekTimeTableID, StartDate, EndDate\n"
                + "FROM WeekTimeTable\n"
                + "WHERE CONVERT(DATE, GETDATE()) BETWEEN StartDate AND EndDate";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                WeekTimeTable timeTable = new WeekTimeTable();
                timeTable.setWeekTimeTableID(rs.getInt("WeekTimeTableID"));
                timeTable.setStartDate(rs.getDate("StartDate"));
                timeTable.setEndDate(rs.getDate("EndDate"));
                return timeTable;
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeekTimeTableDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public WeekTimeTable getByID(int id) {
        String sql = "select WeekTimeTableID,StartDate,EndDate from WeekTimeTable\n"
                + "where WeekTimeTableID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                WeekTimeTable weekTimeTable = new WeekTimeTable();
                weekTimeTable.setWeekTimeTableID(rs.getInt("WeekTimeTableID"));
                weekTimeTable.setStartDate(rs.getDate("StartDate"));
                weekTimeTable.setEndDate(rs.getDate("EndDate"));

                return weekTimeTable;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
//
        WeekTimeTableDBContext c = new WeekTimeTableDBContext();
//        List<WeekTimeTable> list = c.getListDayAndMonthTimeTables(2024);
//        for (WeekTimeTable weekTimeTable : list) {
//            System.out.println(weekTimeTable.getWeekRange());
//        }


//        DateFormat dateFormat = new SimpleDateFormat("yyyy");
//        try {
//            Date startDate = Date.valueOf("2024-01-01");
//            Date endDate = Date.valueOf("2024-01-07");
//            List<Date> daysInWeek = c.getListDaysInWeek(startDate, endDate);
//            for (Date date : daysInWeek) {
//                System.out.println(dateFormat.format(date));
//            }
//        } catch (IllegalArgumentException e) {
//            System.out.println("Invalid date format.");
//        }
        System.out.println(c.getDayAndMonth().getStartDate().getYear()+1900);
//        Date currentDate = new Date();
//
//        int day = currentDate.getDate();
//        int month = currentDate.getMonth() + 1; 
//        int year = currentDate.getYear() + 1900; 
//
//        System.out.println("Ngày: " + day);
//        System.out.println("Tháng: " + month);
//        System.out.println("Năm: " + year);
    }

    public List<Date> getListDaysInWeek(Date startDate, Date endDate) {
        List<Date> daysInWeek = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate); // Đặt ngày bắt đầu của tuần

        // Lặp qua từng ngày trong tuần và thêm vào danh sách
        while (!calendar.getTime().after(endDate)) {
            daysInWeek.add(new java.sql.Date(calendar.getTimeInMillis()));
            calendar.add(Calendar.DAY_OF_MONTH, 1); // Tăng ngày lên 1 để chuyển sang ngày tiếp theo
        }
        return daysInWeek;
    }

}
