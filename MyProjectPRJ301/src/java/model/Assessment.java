/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author G5 5590
 */
public class Assessment {
    private int AssessmentID;
    private String Name;
    

    public Assessment() {
    }

    public Assessment(int AssessmentID, String Name) {
        this.AssessmentID = AssessmentID;
        this.Name = Name;
    }

    public int getAssessmentID() {
        return AssessmentID;
    }

    public void setAssessmentID(int AssessmentID) {
        this.AssessmentID = AssessmentID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String toString() {
        return "Assessment{" + "AssessmentID=" + AssessmentID + ", Name=" + Name + '}';
    }
  
    
}
