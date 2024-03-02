/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mark;

import dao.DBContext;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;


/**
 *
 * @author G5 5590
 */
public class CategoryDBContext extends DBContext {

    public Category getCategoryByID(int id) {

        String sql = "select c.CategoryID,c.CategoryName,c.Type,c.QuestionType,c.GradingGuide from Category as c\n"
                + "where c.CategoryID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Category category= new Category();
                
                category.setCategoryID(rs.getInt("CategoryID"));
                category.setCategoryName(rs.getString("CategoryName"));
                category.setType(rs.getString("Type"));
                category.setQuestionType(rs.getString("QuestionType"));
                category.setGradingGuide(rs.getString("GradingGuide"));
                
                return category;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

     public static void main(String[] args) {
        CategoryDBContext dbContext = new CategoryDBContext(); 

      
        int categoryIdToFetch = 1;
        Category category = dbContext.getCategoryByID(categoryIdToFetch);

        if (category != null) {
       
            System.out.println("Category ID: " + category.getCategoryID());
            System.out.println("Category Name: " + category.getCategoryName());
            System.out.println("Type: " + category.getType());
            System.out.println("Question Type: " + category.getQuestionType());
            System.out.println("Grading Guide: " + category.getGradingGuide());
        } else {
            
            System.out.println("Không tìm thấy Category với ID: " + categoryIdToFetch);
        }
    }
}
