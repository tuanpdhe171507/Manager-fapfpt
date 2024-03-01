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
    private String code;
    private String fristName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    public Teacher() {
    }

    public Teacher(int TeacherID, String code, String fristName, String lastName, String phoneNumber, String emailAddress) {
        this.TeacherID = TeacherID;
        this.code = code;
        this.fristName = fristName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int TeacherID) {
        this.TeacherID = TeacherID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String Code) {
        this.code = Code;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String FristName) {
        this.fristName = FristName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.phoneNumber = PhoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String EmailAddress) {
        this.emailAddress = EmailAddress;
    }

    @Override
    public String toString() {
        return "Teacher{" + "TeacherID=" + TeacherID + ", Code=" + code + ", FristName=" + fristName + ", lastName=" + lastName + ", PhoneNumber=" + phoneNumber + ", EmailAddress=" + emailAddress + '}';
    }

}
