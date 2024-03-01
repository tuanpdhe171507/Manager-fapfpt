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
public class Attendence {
    private int attendenceID;
    private Boolean isPresent;
    private Date datetime;
    private String comment;
    private Session session;
    private Student student;

    public Attendence() {
    }

    public Attendence(int attendenceID, Boolean isPresent, Date datetime, String comment, Session session, Student student) {
        this.attendenceID = attendenceID;
        this.isPresent = isPresent;
        this.datetime = datetime;
        this.comment = comment;
        this.session = session;
        this.student = student;
    }

    public int getAttendenceID() {
        return attendenceID;
    }

    public void setAttendenceID(int attendenceID) {
        this.attendenceID = attendenceID;
    }

    public Boolean getIsPresent() {
        return isPresent;
    }

    public void setIsPresent(Boolean isPresent) {
        this.isPresent = isPresent;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

  
    
    
}
