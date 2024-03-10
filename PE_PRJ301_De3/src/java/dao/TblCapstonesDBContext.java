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
import model.TblCapstones;
import model.TblUsers;

/**
 *
 * @author G5 5590
 */
public class TblCapstonesDBContext extends DBContext {

    public ArrayList<TblCapstones> searchByName(String name) {
        ArrayList<TblCapstones> tblCapstoneses = new ArrayList<>();
        try {
            String sql = "Select t.id,t.name,t.description,t.userID from tblCapstones as t\n"
                    + "join tblUsers as a\n"
                    + "On a.userID=t.userID\n"
                    + "where t.name LIKE '%'+?+'%'";
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TblCapstones capstones = new TblCapstones();
                capstones.setCapid(rs.getString("id"));
                capstones.setCapname(rs.getString("name"));
                capstones.setCapdescription(rs.getString("description"));
                capstones.setCapuserid(new TblUsersDBContext().getTblUsersByID(rs.getString("userID")));
                tblCapstoneses.add(capstones);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TblCapstonesDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tblCapstoneses;
    }

    public ArrayList<TblCapstones> listTblCapstoneses() {
        ArrayList<TblCapstones> tblCapstoneses = new ArrayList<>();
        try {
            String sql = "select t.id,t.name,t.description,t.userID from tblCapstones as t";
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TblCapstones capstones = new TblCapstones();
                capstones.setCapid(rs.getString("id"));
                capstones.setCapname(rs.getString("name"));
                capstones.setCapdescription(rs.getString("description"));
                capstones.setCapuserid(new TblUsersDBContext().getTblUsersByID(rs.getString("userID")));
                tblCapstoneses.add(capstones);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TblCapstonesDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tblCapstoneses;
    }

    public TblCapstones getTblCapstones(String id) {

        try {
            String sql = "select t.id,t.name,t.description,t.userID from tblCapstones as t\n"
                    + "where t.id=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TblCapstones tc = new TblCapstones();
                tc.setCapid(rs.getString("id"));
                tc.setCapname(rs.getString("name"));
                tc.setCapdescription(rs.getString("description"));
                tc.setCapuserid(new TblUsersDBContext().getTblUsersByID(rs.getString("userID")));
                return tc;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TblCapstonesDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void update(TblCapstones entity) {
        try {
            String sql = "UPDATE [dbo].[tblCapstones]\n"
                    + "SET [name] = ?,\n"
                    + "    [description] = ?,\n"
                    + "    [userID] = ?\n"
                    + "WHERE [id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(4, entity.getCapid());
            stm.setString(1, entity.getCapname());
            stm.setString(2, entity.getCapdescription());
            stm.setString(3, entity.getCapuserid().getUserId());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TblCapstonesDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public static void main(String[] args) {
    // Create an instance of TblCapstones entity with updated values
    TblCapstones updatedEntity = new TblCapstones();
    updatedEntity.setCapid("FA001"); // Specify the ID of the record to update
    updatedEntity.setCapname("Updated Name");
    updatedEntity.setCapdescription("Updated Description");

    // Create an instance of TblUsers with the new user ID
    TblUsers newUser = new TblUsers();
    newUser.setUserId("SE170443"); // Specify the new user ID

    // Set the TblUsers object with the new user ID to the TblCapstones entity
    updatedEntity.setCapuserid(newUser);

    // Create an instance of TblCapstonesDBContext
    TblCapstonesDBContext dbContext = new TblCapstonesDBContext();

    // Call the update method to update the record in the database
    dbContext.update(updatedEntity);
}
 
//    public static void main(String[] args) {
//
//        // Tạo một đối tượng của lớp TblCapstonesDBContext
//        TblCapstonesDBContext dbContext = new TblCapstonesDBContext();
//
//        // Thử nghiệm phương thức searchByName
//        String searchName = "Vien";
//        ArrayList<TblCapstones> results = dbContext.searchByName(searchName);
//
//        if (!results.isEmpty()) {
//            System.out.println("Search results for name '" + searchName + "':");
//            for (TblCapstones capstone : results) {
//
//                System.out.println("Name: " + capstone.getCapname());
//
//            }
//        } else {
//            System.out.println("No capstones found for name '" + searchName + "'.");
//        }
//
//    }
}
