package rjgc1;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Teacher teacher = new Teacher(username, password);
        PrintWriter out = response.getWriter();

        if (teacher.login()) {
            out.println("登录成功！<br>");
            String studentId = request.getParameter("studentId");
            ResultSet rs = DatabaseManager.getAttendance(studentId);
            try {
                while (rs.next()) {
                    out.println("学号: " + rs.getString("student_id") + "<br>");
                    out.println("签到时间: " + rs.getTimestamp("check_in_time") + "<br>");
                    out.println("地点: " + rs.getString("location") + "<br>");
                    out.println("照片链接: " + rs.getString("selfie_url") + "<br>");
                    out.println("<hr>");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            out.println("登录失败！");
        }
    }
}
