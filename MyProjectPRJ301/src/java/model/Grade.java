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
    private int id;
    private String coment;
    private float score;
    private Subject subjectID;
    private Assessment assessmentID;
    private Student studentID;

    public Grade() {
    }

    public Grade(int id, String coment, float score, Subject subjectID, Assessment assessmentID, Student studentID) {
        this.id = id;
        this.coment = coment;
        this.score = score;
        this.subjectID = subjectID;
        this.assessmentID = assessmentID;
        this.studentID = studentID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Subject getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Subject subjectID) {
        this.subjectID = subjectID;
    }

    public Assessment getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(Assessment assessmentID) {
        this.assessmentID = assessmentID;
    }

    public Student getStudentID() {
        return studentID;
    }

    public void setStudentID(Student studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "Grade{" + "id=" + id + ", coment=" + coment + ", score=" + score + ", subjectID=" + subjectID + ", assessmentID=" + assessmentID + ", studentID=" + studentID + '}';
    }
    

    
}
