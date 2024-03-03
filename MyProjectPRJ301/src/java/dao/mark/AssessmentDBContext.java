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
import model.Assessment;

/**
 *
 * @author G5 5590
 */
public class AssessmentDBContext extends DBContext {

    public Assessment listAssessment(int id) {

        String sql = "Select a.aid,a.name from Assessment as a\n"
                + "where a.aid=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Assessment assessment = new Assessment();
                assessment.setAssessmentID(rs.getInt("aid"));
                assessment.setName(rs.getString("name"));               
                return assessment;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssessmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
public static void main(String[] args) {
    AssessmentDBContext dbContext = new AssessmentDBContext();
    int idToSearch = 1;
    
   
    Assessment assessment = dbContext.listAssessment(idToSearch);
    
    if (assessment != null) {
       
        System.out.println("Assessment ID: " + assessment.getAssessmentID());
        System.out.println("Assessment Name: " + assessment.getName());
    } else {
       
        System.out.println("Assessment not found for ID: " + idToSearch);
    }
}
   

}
