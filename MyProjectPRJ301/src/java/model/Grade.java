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
    private Assessment asid;
    private Subject Subjectid;
    private int quantity;
    private float weight;
    private String assessmentName;
    private float valueScore;

    public Grade() {
    }

    public Grade(Assessment asid, Subject Subjectid, int quantity, float weight, String assessmentName, float valueScore) {
        this.asid = asid;
        this.Subjectid = Subjectid;
        this.quantity = quantity;
        this.weight = weight;
        this.assessmentName = assessmentName;
        this.valueScore = valueScore;
    }

    public Assessment getAsid() {
        return asid;
    }

    public void setAsid(Assessment asid) {
        this.asid = asid;
    }

    public Subject getSubjectid() {
        return Subjectid;
    }

    public void setSubjectid(Subject Subjectid) {
        this.Subjectid = Subjectid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public float getValueScore() {
        return valueScore;
    }

    public void setValueScore(float valueScore) {
        this.valueScore = valueScore;
    }

    @Override
    public String toString() {
        return "Grade{" + "asid=" + asid + ", Subjectid=" + Subjectid + ", quantity=" + quantity + ", weight=" + weight + ", assessmentName=" + assessmentName + ", valueScore=" + valueScore + '}';
    }

   
    
  

    
}
