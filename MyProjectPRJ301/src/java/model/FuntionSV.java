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
public class FuntionSV {
    private int funtionsvID;
    private Date date;
    private Student studentid;
    private Room room;
    private Subject subject;
    private TimeSlot timeSlot;
    private Attendence attendence;

    public FuntionSV() {
    }

    public FuntionSV(int funtionsvID, Date date, Student studentid, Room room, Subject subject, TimeSlot timeSlot, Attendence attendence) {
        this.funtionsvID = funtionsvID;
        this.date = date;
        this.studentid = studentid;
        this.room = room;
        this.subject = subject;
        this.timeSlot = timeSlot;
        this.attendence = attendence;
    }

    public int getFuntionsvID() {
        return funtionsvID;
    }

    public void setFuntionsvID(int funtionsvID) {
        this.funtionsvID = funtionsvID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Student getStudentid() {
        return studentid;
    }

    public void setStudentid(Student studentid) {
        this.studentid = studentid;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Attendence getAttendence() {
        return attendence;
    }

    public void setAttendence(Attendence attendence) {
        this.attendence = attendence;
    }

    @Override
    public String toString() {
        return "FuntionSV{" + "funtionsvID=" + funtionsvID + ", date=" + date + ", studentid=" + studentid + ", room=" + room + ", subject=" + subject + ", timeSlot=" + timeSlot + ", attendence=" + attendence + '}';
    }

    
}
