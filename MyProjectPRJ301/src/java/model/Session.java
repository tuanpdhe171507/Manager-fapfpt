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
public class Session {
    private int SessionID;
    private Date date;
    private Boolean IsTaken;
    private Group group;
    private Teacher teacher;
    private Room room;
    private TimeSlot timeslot;

    public Session() {
    }

    public Session(int SessionID, Date date, Boolean IsTaken, Group group, Teacher teacher, Room room, TimeSlot timeslot) {
        this.SessionID = SessionID;
        this.date = date;
        this.IsTaken = IsTaken;
        this.group = group;
        this.teacher = teacher;
        this.room = room;
        this.timeslot = timeslot;
    }

    public int getSessionID() {
        return SessionID;
    }

    public void setSessionID(int SessionID) {
        this.SessionID = SessionID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getIsTaken() {
        return IsTaken;
    }

    public void setIsTaken(Boolean IsTaken) {
        this.IsTaken = IsTaken;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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

    public TimeSlot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(TimeSlot timeslot) {
        this.timeslot = timeslot;
    }
    
    public String getWeekRange2() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM");
        String day = dateFormat.format(this.date);        
        return day ;
    }

    @Override
    public String toString() {
        return "Session{" + "SessionID=" + SessionID + ", date=" + date + ", IsTaken=" + IsTaken + ", group=" + group + ", teacher=" + teacher + ", room=" + room + ", timeslot=" + timeslot + '}';
    }
    
    
}
