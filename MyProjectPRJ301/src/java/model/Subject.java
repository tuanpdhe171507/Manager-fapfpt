/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author G5 5590
 */
public class Subject {
    private int SubjectID;
    private String code;
    private String SubjectName;
    private int Credit;
    private int SlotNumber;
    private Semeter Semester;

    public Subject() {
    }

    public Subject(int SubjectID, String code, String SubjectName, int Credit, int SlotNumber, Semeter Semester) {
        this.SubjectID = SubjectID;
        this.code = code;
        this.SubjectName = SubjectName;
        this.Credit = Credit;
        this.SlotNumber = SlotNumber;
        this.Semester = Semester;
    }


    public int getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(int SubjectID) {
        this.SubjectID = SubjectID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

   

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String SubjectName) {
        this.SubjectName = SubjectName;
    }

    public int getCredit() {
        return Credit;
    }

    public void setCredit(int Credit) {
        this.Credit = Credit;
    }

    public int getSlotNumber() {
        return SlotNumber;
    }

    public void setSlotNumber(int SlotNumber) {
        this.SlotNumber = SlotNumber;
    }

    public Semeter getSemester() {
        return Semester;
    }

    public void setSemester(Semeter Semester) {
        this.Semester = Semester;
    }

    @Override
    public String toString() {
        return "Subject{" + "SubjectID=" + SubjectID + ", SubjectCode=" + code + ", SubjectName=" + SubjectName + ", Credit=" + Credit + ", SlotNumber=" + SlotNumber + ", Semester=" + Semester + '}';
    }

    
    
}
