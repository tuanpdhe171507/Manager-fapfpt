/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author G5 5590
 */
public class WeekTimeTable {

    private int weekTimeTableID;
    private Date StartDate;
    private Date EndDate;

    public WeekTimeTable() {
    }

    public WeekTimeTable(int WeekTimeTableID, Date StartDate, Date EndDate) {
        this.weekTimeTableID = WeekTimeTableID;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
    }

    public int getWeekTimeTableID() {
        return weekTimeTableID;
    }

    public void setWeekTimeTableID(int WeekTimeTableID) {
        this.weekTimeTableID = WeekTimeTableID;
    }
    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public String getWeekRange() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM");
        String startDayAndMonth = dateFormat.format(this.StartDate);
        String endDayAndMonth = dateFormat.format(this.EndDate);
        return startDayAndMonth + " To " + endDayAndMonth;
    }

    public String getWeekRange1() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM");
        String startDayAndMonth = dateFormat.format(this.StartDate);
        return startDayAndMonth;
    }

    public String getWeekRange2(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM");
        String endDayAndMonth = dateFormat.format(this.EndDate);
        return endDayAndMonth;
    }

    @Override
    public String toString() {
        return "WeekTimeTable{" + "weekTimeTableID=" + weekTimeTableID + ", StartDate=" + StartDate + ", EndDate=" + EndDate + '}';
    }
    

}
