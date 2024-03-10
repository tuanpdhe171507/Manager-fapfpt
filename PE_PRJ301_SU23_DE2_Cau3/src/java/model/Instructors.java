/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.*;
/**
 *
 * @author G5 5590
 */
public class Instructors {
    private String instructorID;
    private String instructorName;
    private Date bithDay;
    private boolean gender;
    private Classes classeID;

    public Instructors() {
    }

    public Instructors(String instructorID, String instructorName, Date bithDay, boolean gender, Classes classeID) {
        this.instructorID = instructorID;
        this.instructorName = instructorName;
        this.bithDay = bithDay;
        this.gender = gender;
        this.classeID = classeID;
    }

    public String getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(String instructorID) {
        this.instructorID = instructorID;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public Date getBithDay() {
        return bithDay;
    }

    public void setBithDay(Date bithDay) {
        this.bithDay = bithDay;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Classes getClasseID() {
        return classeID;
    }

    public void setClasseID(Classes classeID) {
        this.classeID = classeID;
    }

    @Override
    public String toString() {
        return "Instructors{" + "instructorID=" + instructorID + ", instructorName=" + instructorName + ", bithDay=" + bithDay + ", gender=" + gender + ", classeID=" + classeID + '}';
    }
    
}
