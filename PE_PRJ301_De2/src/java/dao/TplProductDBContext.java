/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import model.TblProducts;
import java.sql.*;

/**
 *
 * @author G5 5590
 */
public class TplProductDBContext extends DBContext {

    public ArrayList<TblProducts> search() {
        ArrayList<TblProducts> list = new ArrayList<>();
        try {
            String sql = "select a.productID,a.productName,a.description,a.price,a.status from tblProducts as a";

            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TblProducts pro = new TblProducts();
                pro.setId(rs.getString("productID"));
                pro.setName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setPrice(rs.getFloat("price"));
                pro.setStatus(rs.getBoolean("status"));
                list.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TplProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
