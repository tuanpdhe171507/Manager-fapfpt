/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author G5 5590
 */
public class Teacher {

    private int TeacherID;
    private String Code;
    private String FristName;
    private String lastName;
    private String PhoneNumber;
    private String EmailAddress;

    public Teacher() {
    }

    public Teacher(int TeacherID, String Code, String FristName, String lastName, String PhoneNumber, String EmailAddress) {
        this.TeacherID = TeacherID;
        this.Code = Code;
        this.FristName = FristName;
        this.lastName = lastName;
        this.PhoneNumber = PhoneNumber;
        this.EmailAddress = EmailAddress;
    }

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int TeacherID) {
        this.TeacherID = TeacherID;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getFristName() {
        return FristName;
    }

    public void setFristName(String FristName) {
        this.FristName = FristName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }

    @Override
    public String toString() {
        return "Teacher{" + "TeacherID=" + TeacherID + ", Code=" + Code + ", FristName=" + FristName + ", lastName=" + lastName + ", PhoneNumber=" + PhoneNumber + ", EmailAddress=" + EmailAddress + '}';
    }

}
