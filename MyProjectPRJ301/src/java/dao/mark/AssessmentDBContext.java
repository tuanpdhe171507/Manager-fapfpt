/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mark;

import dao.CampusDBContext;
import dao.DBContext;
import dao.timetable.GroupDBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Assessment;
import model.Group;

/**
 *
 * @author G5 5590
 */
public class AssessmentDBContext extends DBContext {

    public Assessment listAssessment(int id) {

        String sql = "select s.AssessmentID,s.SubjectCode,s.weight,s.Name,s.Part,s.CompletionCriteria,s.Duration,s.KnowledgeAndSkill,s.Note,s.CategoryID\n"
                + "from Assessment as s\n"
                + "where s.AssessmentID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Assessment assessment = new Assessment();
                
                assessment.setAssessmentID(rs.getInt("AssessmentID"));
                assessment.setSubjectCode(rs.getString("SubjectCode"));
                assessment.setWeight(rs.getFloat("weight"));
                assessment.setName(rs.getString("Name"));
                assessment.setPart(rs.getInt("Part"));
                assessment.setCompletionCriteria(rs.getString("CompletionCriteria"));
                assessment.setDuration(rs.getString("Duration"));
                assessment.setKnowlegeAndSkill(rs.getString("KnowledgeAndSkill"));
                assessment.setNote(rs.getString("Note"));
                assessment.setCategoy(new CategoryDBContext().getCategoryByID(rs.getInt("CategoryID")));
                return assessment;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssessmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public static void main(String[] args) {
        AssessmentDBContext dbContext = new AssessmentDBContext(); // Tạo một instance của lớp AssessmentDBContext

        // Gọi phương thức để lấy một Assessment từ cơ sở dữ liệu theo ID
        int assessmentIdToFetch = 1; // Thay thế 1 bằng ID của Assessment bạn muốn lấy
        Assessment assessment = dbContext.listAssessment(assessmentIdToFetch);

        if (assessment != null) {
            // In ra thông tin của Assessment nếu tồn tại
            System.out.println("Assessment ID: " + assessment.getAssessmentID());
            System.out.println("Subject Code: " + assessment.getSubjectCode());
            System.out.println("Weight: " + assessment.getWeight());
            System.out.println("Name: " + assessment.getName());
            System.out.println("Part: " + assessment.getPart());
            System.out.println("Completion Criteria: " + assessment.getCompletionCriteria());
            System.out.println("Duration: " + assessment.getDuration());
           
          
            System.out.println("Category: " + assessment.getCategoy()); 
        } else {
            // In ra thông báo nếu không tìm thấy Assessment
            System.out.println("Không tìm thấy Assessment với ID: " + assessmentIdToFetch);
        }
    }
    

}
