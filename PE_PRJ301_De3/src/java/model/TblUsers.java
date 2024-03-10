/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author G5 5590
 */
public class TblUsers {
    private String userId;
    private String fullName;
    private String passWord;
    private String roleID;
    private boolean status;

    public TblUsers() {
    }

    public TblUsers(String userId, String fullName, String passWord, String roleID, boolean status) {
        this.userId = userId;
        this.fullName = fullName;
        this.passWord = passWord;
        this.roleID = roleID;
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TblUsers{" + "userId=" + userId + ", fullName=" + fullName + ", passWord=" + passWord + ", roleID=" + roleID + ", status=" + status + '}';
    }
    
    
}
