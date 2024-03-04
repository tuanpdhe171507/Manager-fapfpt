/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mark;

import dao.DBContext;
import dao.timetable.SubjectDBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Assessment;
import model.Grade;
import model.Semeter;
import model.Subject;

/**
 *
 * @author G5 5590
 */
public class GradeDBContext extends DBContext {

    public ArrayList<Grade> listGrade(int studentID, int subjectID) {
        ArrayList<Grade> lists = new ArrayList();
        String sql = "select sj.SubjectID,a.name,g.weight,c.value from Score as c\n"
                + "inner join Grade as g\n"
                + "On c.assessmentId=g.assessmentId and c.subjectId=g.subjectCode\n"
                + "inner join Assessment as a\n"
                + "On a.aid=c.assessmentId\n"
                + "inner join Subject as sj\n"
                + "On sj.SubjectID= c.subjectId\n"
                + "where c.studentId=? and sj.SubjectID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, studentID);
            st.setInt(2, subjectID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Grade grade = new Grade();

                Assessment ass = new Assessment();
                grade.setSubjectid(new SubjectDBContext().getByIDSubject(rs.getInt("SubjectID")));
                ass.setName(rs.getString("name"));
                grade.setAssessmentName(rs.getString("name"));
                grade.setWeight(rs.getFloat("weight"));
                grade.setValueScore(rs.getFloat("value"));

                lists.add(grade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GradeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

    public float calculateAverage(ArrayList<Grade> grades) {
        float totalWeightedScore = 0;

        boolean hasFinalExamResit = false; // Biến để kiểm tra xem có Final Exam Resit hay không
        float finalExamResitValue = 0; // Biến để lưu giá trị của Final Exam Resit

        for (Grade grade : grades) {
            String assessmentName = grade.getAssessmentName();
            float weight = grade.getWeight();
            float value = grade.getValueScore();

            // Nếu assessmentName là "Final Exam Resit" và value lớn hơn 0
            if (assessmentName.equalsIgnoreCase("Final Exam Resit") && value > 0) {
                hasFinalExamResit = true;
                finalExamResitValue = value;
            } else if (assessmentName.equalsIgnoreCase("Final Exam") && value > 0 && finalExamResitValue < 0) {
                // Nếu có cả "Final Exam" và "Final Exam Resit" và value của Final Exam Resit < 0
                totalWeightedScore += weight * value;
            } else if (assessmentName.equalsIgnoreCase("Final Exam") && hasFinalExamResit && finalExamResitValue > 0) {
                // Nếu có cả "Final Exam" và "Final Exam Resit" và value của Final Exam Resit > 0
                totalWeightedScore += weight * finalExamResitValue;
            } else {
                // Sử dụng điểm của assessmentName khác hoặc điểm là 0 để tính tổng điểm trọng số
                totalWeightedScore += weight * value;
            }
        }
        // Làm tròn kết quả đến 2 chữ số sau dấu phẩy
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String roundedScore = decimalFormat.format(totalWeightedScore);
        totalWeightedScore = Float.parseFloat(roundedScore);

        return totalWeightedScore;
    }

    public static void main(String[] args) {
        // Tạo một đối tượng GradeDBContext
        GradeDBContext dbContext = new GradeDBContext();

        // Lấy danh sách các điểm của học sinh có ID là 1 cho môn học có ID là 23
        ArrayList<Grade> grades = dbContext.listGrade(1, 24);

        // Tính điểm trung bình từ danh sách điểm
        float averageScore = dbContext.calculateAverage(grades);

        // In ra kết quả
        System.out.println("Average Score: " + averageScore);
    }

}
