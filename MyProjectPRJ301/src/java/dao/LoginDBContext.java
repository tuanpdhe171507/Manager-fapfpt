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
import model.Login.Login;

/**
 *
 * @author G5 5590
 */
public class LoginDBContext extends DBContext {

    public Login getByUsernamePassword(String username) {

        try {
            String sql = "select * from [Login] \n"
                    + "where NameCampus = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Login newAccount = new Login();
                newAccount.setSelectCampus(username);

                //  newAccount.setDisplayname(rs.getString("displayname"));
                return newAccount;
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        LoginDBContext c = new LoginDBContext();
        Login login = c.getByUsernamePassword("FU-Hoà Lạc");
        if (login != null) {
            System.out.println(login.getSelectCampus());
        } else {
            System.out.println("Không tìm thấy người dùng có tên là 'FU-Hoà Lạc'");
        }
    }
}
