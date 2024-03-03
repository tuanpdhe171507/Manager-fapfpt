/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author G5 5590
 */
public class Score {
    private Student studentid;
    private Assessment assid;
    private Subject subjectid;
    private float value;

    public Score() {
    }

    public Score(Student studentid, Assessment assid, Subject subjectid, float value) {
        this.studentid = studentid;
        this.assid = assid;
        this.subjectid = subjectid;
        this.value = value;
    }

    public Student getStudentid() {
        return studentid;
    }

    public void setStudentid(Student studentid) {
        this.studentid = studentid;
    }

    public Assessment getAssid() {
        return assid;
    }

    public void setAssid(Assessment assid) {
        this.assid = assid;
    }

    public Subject getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Subject subjectid) {
        this.subjectid = subjectid;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Score{" + "studentid=" + studentid + ", assid=" + assid + ", subjectid=" + subjectid + ", value=" + value + '}';
    }
    
}
