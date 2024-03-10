/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
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
    private java.sql.Date dateSQL;
    private Subject subject;
    private TimeSlot timeslot;
    private Room room;
    private Teacher teacher;

    public Attendence() {
    }

    public Attendence(int attendenceID, Boolean isPresent, Date datetime, String comment, Session session, Student student, java.sql.Date dateSQL, Subject subject, TimeSlot timeslot, Room room, Teacher teacher) {
        this.attendenceID = attendenceID;
        this.isPresent = isPresent;
        this.datetime = datetime;
        this.comment = comment;
        this.session = session;
        this.student = student;
        this.dateSQL = dateSQL;
        this.subject = subject;
        this.timeslot = timeslot;
        this.room = room;
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

   
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

    public java.sql.Date getDateSQL() {
        return dateSQL;
    }

    public void setDateSQL(java.sql.Date dateSQL) {
        this.dateSQL = dateSQL;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public TimeSlot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(TimeSlot timeslot) {
        this.timeslot = timeslot;
    }

    @Override
    public String toString() {
        return "Attendence{" + "attendenceID=" + attendenceID + ", isPresent=" + isPresent + ", datetime=" + datetime + ", comment=" + comment + ", session=" + session + ", student=" + student + ", dateSQL=" + dateSQL + ", subject=" + subject + ", timeslot=" + timeslot + ", room=" + room + ", teacher=" + teacher + '}';
    }

    
    
    
    
}
