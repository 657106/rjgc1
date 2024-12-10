package rjgc1;

import java.sql.*;

public class Student {
    private String studentId;
    private String name;
    private String course;

    // 构造函数
    public Student(String studentId, String name, String course) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
    }

    // 签到方法
    public void signIn(String location, String selfieUrl) {
        DatabaseManager.insertAttendance(studentId, location, selfieUrl);
        System.out.println("签到成功！地点: " + location + ", 自画像链接: " + selfieUrl);
    }

    // 查看签到记录
    public void viewAttendance() {
        ResultSet rs = DatabaseManager.getAttendance(studentId);
        try {
            while (rs.next()) {
                System.out.println("签到时间: " + rs.getTimestamp("check_in_time"));
                System.out.println("地点: " + rs.getString("location"));
                System.out.println("自画像: " + rs.getString("selfie_url"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getStudentId() {
        return studentId;
    }
}
