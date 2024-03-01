/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author G5 5590
 */
public class Grade {
    private int GradeID;
    private float Mark;
    private Assessment assement;
    private Result result;

    public Grade() {
    }

    public Grade(int GradeID, float Mark, Assessment assement, Result result) {
        this.GradeID = GradeID;
        this.Mark = Mark;
        this.assement = assement;
        this.result = result;
    }

    public int getGradeID() {
        return GradeID;
    }

    public void setGradeID(int GradeID) {
        this.GradeID = GradeID;
    }

    public float getMark() {
        return Mark;
    }

    public void setMark(float Mark) {
        this.Mark = Mark;
    }

    public Assessment getAssement() {
        return assement;
    }

    public void setAssement(Assessment assement) {
        this.assement = assement;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
    
}
