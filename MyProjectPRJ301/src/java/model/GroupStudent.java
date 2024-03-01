/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author G5 5590
 */
public class GroupStudent {

    private int groupStudentID;
    private Group group;
    private Student student;

    public GroupStudent() {
    }

    public GroupStudent(int groupStudentID, Group group, Student student) {
        this.groupStudentID = groupStudentID;
        this.group = group;
        this.student = student;
    }

    public int getGroupStudentID() {
        return groupStudentID;
    }

    public void setGroupStudentID(int groupStudentID) {
        this.groupStudentID = groupStudentID;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "GroupStudent{" + "groupStudentID=" + groupStudentID + ", group=" + group + ", student=" + student + '}';
    }

    
    
}
