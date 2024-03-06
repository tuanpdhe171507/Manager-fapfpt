/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control.LoginLectureAndStudent;

import dao.DBContext;
import model.Account;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author G5 5590
 */
public class AccountDBContex extends DBContext {

    public Account getByUsernamePassword(String username, String password) {

        try {
            String sql = "Select username,password from Account\n"
                    + "where username = ? AND password = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs= st.executeQuery();
            if(rs.next()){
                Account newAccount= new Account();
                newAccount.setUsername(username);
                newAccount.setPassword(password);
          
                return newAccount;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContex.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        // Replace these values with your actual username and password
        String username = "tuandphe171507";
        String password = "2003";
        
        // Create an instance of AccountDBContex
        AccountDBContex accountDBContext = new AccountDBContex();
        
        // Call the getByUsernamePassword method and store the result
        Account account = accountDBContext.getByUsernamePassword(username, password);
        
        // Check if an account was found
        if (account != null) {
            System.out.println("Account found:");
            System.out.println("Username: " + account.getUsername());
            System.out.println("Password: " + account.getPassword());
        } else {
            System.out.println("Account not found!");
        }
    }

   

 
}
