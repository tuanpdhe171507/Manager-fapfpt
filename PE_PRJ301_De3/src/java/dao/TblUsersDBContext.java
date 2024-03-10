/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TblUsers;

/**
 *
 * @author G5 5590
 */
public class TblUsersDBContext extends DBContext {

    public TblUsers getByUsernamePassword(String username, String password) {

        try {
            String sql = "select t.userID,t.fullName,t.password,t.roleID,t.status from tblUsers as t\n"
                    + "where t.fullName=? and t.password=? and t.roleID='AD'";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                TblUsers tblUsers = new TblUsers();
                tblUsers.setUserId(rs.getString("userID"));
                tblUsers.setFullName(rs.getString("fullName"));
                tblUsers.setPassWord(rs.getString("password"));
                tblUsers.setRoleID(rs.getString("roleID"));
                tblUsers.setStatus(rs.getBoolean("status"));

                return tblUsers;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TblUsersDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public TblUsers getByRoleID() {

        try {
            String sql = "select t.userID,t.fullName,t.password,t.roleID,t.status from tblUsers as t\n"
                    + "where t.roleID='AD'";
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                TblUsers tblUsers = new TblUsers();
                tblUsers.setUserId(rs.getString("userID"));
                tblUsers.setFullName(rs.getString("fullName"));
                tblUsers.setPassWord(rs.getString("password"));
                tblUsers.setRoleID(rs.getString("roleID"));
                tblUsers.setStatus(rs.getBoolean("status"));
                return tblUsers;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TblUsersDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public TblUsers getTblUsersByID(String id) {

        try {
            String sql = "select t.userID,t.fullName,t.password,t.roleID,t.status from tblUsers as t\n"
                    + "where t.userID=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                TblUsers tblUsers = new TblUsers();
                tblUsers.setUserId(rs.getString("userID"));
                tblUsers.setFullName(rs.getString("fullName"));
                tblUsers.setPassWord(rs.getString("password"));
                tblUsers.setRoleID(rs.getString("roleID"));
                tblUsers.setStatus(rs.getBoolean("status"));
                return tblUsers;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TblUsersDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public ArrayList<TblUsers> getListTblUsers() {
          ArrayList<TblUsers> list= new ArrayList<>();
        try {
            String sql = "select t.userID,t.fullName,t.password,t.roleID,t.status from tblUsers as t";
            PreparedStatement st = connection.prepareStatement(sql);
        
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TblUsers tblUsers = new TblUsers();
                tblUsers.setUserId(rs.getString("userID"));
                tblUsers.setFullName(rs.getString("fullName"));
                tblUsers.setPassWord(rs.getString("password"));
                tblUsers.setRoleID(rs.getString("roleID"));
                tblUsers.setStatus(rs.getBoolean("status"));
                list.add(tblUsers);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TblUsersDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {

        TblUsersDBContext dbContext = new TblUsersDBContext();

        // Thử nghiệm phương thức getByUsernamePassword
        String testUsername = "Hoa Doan";
        String testPassword = "1";
        TblUsers user = dbContext.getByUsernamePassword(testUsername, testPassword);
        String fuuName = user.getFullName();
        if (user != null) {
            System.out.println("User found:" + fuuName);
            System.out.println("UserID: " + user.getUserId());
            System.out.println("FullName: " + user.getFullName());
            System.out.println("RoleID: " + user.getRoleID());

        } else {
            System.out.println("User not found for username: " + testUsername + " and password: " + testPassword);
        }

    }

}
