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
import model.Classes;

/**
 *
 * @author G5 5590
 */
public class ClassDBContext extends DBContext {

    public Classes getByIDSubject(int id) {

        String sql = "select c.ClassID,c.ClassName,c.StartDate from Classes as c\n"
                + "where c.ClassID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Classes classes = new Classes();
                classes.setClassid(rs.getInt("ClassID"));
                classes.setClassName(rs.getString("ClassName"));
                classes.setStartDate(rs.getDate("StartDate"));
                
                return classes;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Classes> getListClasses() {
        ArrayList<Classes>list= new ArrayList<>();
        String sql = "select c.ClassID,c.ClassName,c.StartDate from Classes as c";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
          
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Classes classes = new Classes();
                classes.setClassid(rs.getInt("ClassID"));
                classes.setClassName(rs.getString("ClassName"));
                classes.setStartDate(rs.getDate("StartDate"));
                
                list.add(classes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }


}
