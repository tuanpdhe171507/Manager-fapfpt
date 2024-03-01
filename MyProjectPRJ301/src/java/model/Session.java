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
    private int sessionID;
    private Date date;
    private Boolean isTaken;
    private Group group;
    private Teacher teacher;
    private Room room;
    private TimeSlot timeslot;

    public Session() {
    }

    public Session(int sessionID, Date date, Boolean isTaken, Group group, Teacher teacher, Room room, TimeSlot timeslot) {
        this.sessionID = sessionID;
        this.date = date;
        this.isTaken = isTaken;
        this.group = group;
        this.teacher = teacher;
        this.room = room;
        this.timeslot = timeslot;
    }

    public int getSessionID() {
        return sessionID;
    }

    public void setSessionID(int SessionID) {
        this.sessionID = SessionID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getIsTaken() {
        return isTaken;
    }

    public void setIsTaken(Boolean IsTaken) {
        this.isTaken = isTaken;
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
        return "Session{" + "SessionID=" + sessionID + ", date=" + date + ", IsTaken=" + isTaken + ", group=" + group + ", teacher=" + teacher + ", room=" + room + ", timeslot=" + timeslot + '}';
    }
    
    
}
