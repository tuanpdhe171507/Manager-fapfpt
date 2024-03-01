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
    private int AttendenceID;
    private Boolean isPresent;
    private Date datetime;
    private String Comment;
    private Session session;
    private Student student;

    public Attendence() {
    }

    public Attendence(int AttendenceID, Boolean isPresent, Date datetime, String Comment, Session session, Student student) {
        this.AttendenceID = AttendenceID;
        this.isPresent = isPresent;
        this.datetime = datetime;
        this.Comment = Comment;
        this.session = session;
        this.student = student;
    }

    public int getAttendenceID() {
        return AttendenceID;
    }

    public void setAttendenceID(int AttendenceID) {
        this.AttendenceID = AttendenceID;
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
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
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
