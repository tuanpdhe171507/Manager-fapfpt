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

    public static void main(String[] args) {

        // Tạo một đối tượng của lớp TblCapstonesDBContext
        TblCapstonesDBContext dbContext = new TblCapstonesDBContext();

        // Thử nghiệm phương thức searchByName
        String searchName = "Vien";
        ArrayList<TblCapstones> results = dbContext.searchByName(searchName);

        if (!results.isEmpty()) {
            System.out.println("Search results for name '" + searchName + "':");
            for (TblCapstones capstone : results) {

                System.out.println("Name: " + capstone.getCapname());

            }
        } else {
            System.out.println("No capstones found for name '" + searchName + "'.");
        }

    }
}
