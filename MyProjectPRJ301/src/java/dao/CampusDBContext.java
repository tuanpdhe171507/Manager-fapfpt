/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Login.Campus;


/**
 *
 * @author G5 5590
 */
public class CampusDBContext  extends DBContext{
     public ArrayList<Campus> listCampus() {
       ArrayList<Campus> campus= new ArrayList();
       String sql="select * from [Campus]";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                Campus campus1= new Campus();
                campus1.setId(rs.getInt("CampusID"));
                campus1.setName(rs.getString("CampusName"));
                campus.add(campus1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CampusDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
       return campus;
    }
     public static void main(String[] args) {
        CampusDBContext c = new CampusDBContext();
        List<Campus> list = c.listCampus();
        System.out.println(list.get(1).getName());
    }

}
