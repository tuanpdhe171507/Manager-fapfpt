/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author G5 5590
 */
public class Student {
    private int id;
    private String rollNumber;
    private String code;
    private String fristName;
    private String lastName;
    private String image;
    private boolean gender;
    private String address;
    private Group group;

    public Student() {
    }

    public Student(int id, String rollNumber, String code, String fristName, String lastName, String image, boolean gender, String address, Group group) {
        this.id = id;
        this.rollNumber = rollNumber;
        this.code = code;
        this.fristName = fristName;
        this.lastName = lastName;
        this.image = image;
        this.gender = gender;
        this.address = address;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", rollNumber=" + rollNumber + ", code=" + code + ", fristName=" + fristName + ", lastName=" + lastName + ", image=" + image + ", gender=" + gender + ", address=" + address + ", group=" + group + '}';
    }
}
