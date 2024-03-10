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
public class Classes {
    private int classid;
    private String className;
    private Date startDate;

    public Classes() {
    }

    public Classes(int classid, String className, Date startDate) {
        this.classid = classid;
        this.className = className;
        this.startDate = startDate;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Classes{" + "classid=" + classid + ", className=" + className + ", startDate=" + startDate + '}';
    }

   
}
