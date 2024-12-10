package rjgc1;

import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/teachercheckindb";
    private static final String USER = "root";
    private static final String PASSWORD = "20041006"; // 请替换为实际密码

    private static Connection conn;

    // 获取数据库连接
    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // 插入签到记录
    public static void insertAttendance(String studentId, String location, String selfieUrl) {
        String query = "INSERT INTO attendancerecords (student_id, check_in_time, location, selfie_url) VALUES (?, NOW(), ?, ?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
            stmt.setString(1, studentId);
            stmt.setString(2, location);
            stmt.setString(3, selfieUrl);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 获取学生签到记录
    public static ResultSet getAttendance(String studentId) {
        String query = "SELECT * FROM attendancerecords WHERE student_id = ?";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1, studentId);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
