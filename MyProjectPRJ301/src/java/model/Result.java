/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author G5 5590
 */
public class Result {
    private int ResultID;
    private float AggregateMark;
    private String Status;
    private GroupStudent groupStudent;

    public Result() {
    }

    public Result(int ResultID, float AggregateMark, String Status, GroupStudent groupStudent) {
        this.ResultID = ResultID;
        this.AggregateMark = AggregateMark;
        this.Status = Status;
        this.groupStudent = groupStudent;
    }

    public int getResultID() {
        return ResultID;
    }

    public void setResultID(int ResultID) {
        this.ResultID = ResultID;
    }

    public float getAggregateMark() {
        return AggregateMark;
    }

    public void setAggregateMark(float AggregateMark) {
        this.AggregateMark = AggregateMark;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public GroupStudent getGroupStudent() {
        return groupStudent;
    }

    public void setGroupStudent(GroupStudent groupStudent) {
        this.groupStudent = groupStudent;
    }
    
}
