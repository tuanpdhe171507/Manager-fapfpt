/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TblCapstones;

/**
 *
 * @author G5 5590
 */
public class DeleteDBContext extends DBContext {

    public void delete(TblCapstones capstones) {

        try {
            String sql = "Delete from tblCapstones\n"
                    + "where [id]=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, capstones.getCapid());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
