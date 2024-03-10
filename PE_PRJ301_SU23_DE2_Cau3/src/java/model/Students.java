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
public class Students {
    private String studentID;
    private String studentName;
    private Date bithDay;
    private boolean gender;
    private Classes classID;

    public Students() {
    }

    public Students(String studentID, String studentName, Date bithDay, boolean gender, Classes classID) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.bithDay = bithDay;
        this.gender = gender;
        this.classID = classID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public Classes getClassID() {
        return classID;
    }

    public void setClassID(Classes classID) {
        this.classID = classID;
    }

    @Override
    public String toString() {
        return "Students{" + "studentID=" + studentID + ", studentName=" + studentName + ", bithDay=" + bithDay + ", gender=" + gender + ", classID=" + classID + '}';
    }
    
}
