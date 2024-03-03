/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.timetable;

import dao.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Subject;

/**
 *
 * @author G5 5590
 */
public class SubjectDBContext extends DBContext {

    public Subject getByIDSubject(int id) {

        String sql = "select * from [Subject]\n"
                + "where SubjectID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Subject subject = new Subject();
                subject.setSubjectID(rs.getInt("SubjectID"));
                subject.setCode(rs.getString("SubjectCode"));
                subject.setSubjectName(rs.getString("SubjectName"));
                subject.setCredit(rs.getInt("Credit"));
                subject.setSlotNumber(rs.getInt("SlotNumber"));

                subject.setSemester(new SemeterDBContext().getByID(rs.getInt("SemesterID")));
                return subject;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Subject> getlistSubject(int id) {
        ArrayList<Subject> list = new ArrayList<>();
        String sql = "select * from [Subject]\n"
                + "where SubjectID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setSubjectID(rs.getInt("SubjectID"));
                subject.setCode(rs.getString("SubjectCode"));
                subject.setSubjectName(rs.getString("SubjectName"));
                subject.setCredit(rs.getInt("Credit"));
                subject.setSlotNumber(rs.getInt("SlotNumber"));

                subject.setSemester(new SemeterDBContext().getByID(rs.getInt("SemesterID")));
                list.add(subject);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

     public static void main(String[] args) {
        // Tạo một đối tượng SubjectDBContext (giả sử bạn đã có một lớp này)
        SubjectDBContext dbContext = new SubjectDBContext();

        // Gọi phương thức getlistSubject(int id) với một giá trị id cụ thể
        int id = 1; // Thay đổi giá trị id tùy thuộc vào trường hợp kiểm tra
        ArrayList<Subject> subjects = dbContext.getlistSubject(id);

        // In ra thông tin về các môn học được trả về
        for (Subject subject : subjects) {
            System.out.println("SubjectID: " + subject.getSubjectID());
            System.out.println("SubjectCode: " + subject.getCode());
            System.out.println("SubjectName: " + subject.getSubjectName());
            System.out.println("Credit: " + subject.getCredit());
            System.out.println("SlotNumber: " + subject.getSlotNumber());
            System.out.println("SemesterID: " + subject.getSemester());
            // In thêm thông tin khác nếu cần
            System.out.println();
        }
    }

}
