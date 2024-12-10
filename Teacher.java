package rjgc1;

import java.sql.*;

public class Teacher {
    private String username;
    private String password;

    // 构造函数
    public Teacher(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // 登录验证
    public boolean login() {
        String query = "SELECT * FROM teachers WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = DatabaseManager.getConnection().prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();  // 如果找到匹配的记录，返回true
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 查看学生签到记录
    public void viewStudentAttendance(String studentId) {
        ResultSet rs = DatabaseManager.getAttendance(studentId);
        try {
            while (rs.next()) {
                System.out.println("学生学号: " + rs.getString("student_id"));
                System.out.println("签到时间: " + rs.getTimestamp("check_in_time"));
                System.out.println("签到地点: " + rs.getString("location"));
                System.out.println("自画像: " + rs.getString("selfie_url"));
                System.out.println("------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
