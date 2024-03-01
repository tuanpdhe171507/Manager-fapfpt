/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author G5 5590
 */
public class Semeter {
    private  int SemeterID;
    private String SemeterName;
    private  Date StartDate;
    private Date EndDate;

    public Semeter() {
    }

    public Semeter(int SemeterID, String SemeterName, Date StartDate, Date EndDate) {
        this.SemeterID = SemeterID;
        this.SemeterName = SemeterName;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
    }

    public int getSemeterID() {
        return SemeterID;
    }

    public void setSemeterID(int SemeterID) {
        this.SemeterID = SemeterID;
    }

    public String getSemeterName() {
        return SemeterName;
    }

    public void setSemeterName(String SemeterName) {
        this.SemeterName = SemeterName;
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

    @Override
    public String toString() {
        return "Semeter{" + "SemeterID=" + SemeterID + ", SemeterName=" + SemeterName + ", StartDate=" + StartDate + ", EndDate=" + EndDate + '}';
    }

   
}
