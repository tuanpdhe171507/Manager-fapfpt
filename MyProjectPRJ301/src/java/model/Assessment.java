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
    private String SubjectCode;
    private float Weight;
    private String Name;
    private int Part;
    private String CompletionCriteria;
    private String Duration;
    private String knowlegeAndSkill;
    private String Note;
    private Category categoy;

    public Assessment() {
    }

    public Assessment(int AssessmentID, String SubjectCode, int Weight, String Name, int Part, String CompletionCriteria, String Duration, String knowlegeAndSkill, String Note, Category categoy) {
        this.AssessmentID = AssessmentID;
        this.SubjectCode = SubjectCode;
        this.Weight = Weight;
        this.Name = Name;
        this.Part = Part;
        this.CompletionCriteria = CompletionCriteria;
        this.Duration = Duration;
        this.knowlegeAndSkill = knowlegeAndSkill;
        this.Note = Note;
        this.categoy = categoy;
    }

    public int getAssessmentID() {
        return AssessmentID;
    }

    public void setAssessmentID(int AssessmentID) {
        this.AssessmentID = AssessmentID;
    }

    public String getSubjectCode() {
        return SubjectCode;
    }

    public void setSubjectCode(String SubjectCode) {
        this.SubjectCode = SubjectCode;
    }

    public float getWeight() {
        return Weight;
    }

    public void setWeight(float Weight) {
        this.Weight = Weight;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPart() {
        return Part;
    }

    public void setPart(int Part) {
        this.Part = Part;
    }

    public String getCompletionCriteria() {
        return CompletionCriteria;
    }

    public void setCompletionCriteria(String CompletionCriteria) {
        this.CompletionCriteria = CompletionCriteria;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String Duration) {
        this.Duration = Duration;
    }

    public String getKnowlegeAndSkill() {
        return knowlegeAndSkill;
    }

    public void setKnowlegeAndSkill(String knowlegeAndSkill) {
        this.knowlegeAndSkill = knowlegeAndSkill;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public Category getCategoy() {
        return categoy;
    }

    public void setCategoy(Category categoy) {
        this.categoy = categoy;
    }

    @Override
    public String toString() {
        return "Assessment{" + "AssessmentID=" + AssessmentID + ", SubjectCode=" + SubjectCode + ", Weight=" + Weight + ", Name=" + Name + ", Part=" + Part + ", CompletionCriteria=" + CompletionCriteria + ", Duration=" + Duration + ", knowlegeAndSkill=" + knowlegeAndSkill + ", Note=" + Note + ", categoy=" + categoy + '}';
    }
    
    
}
