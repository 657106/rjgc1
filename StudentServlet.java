package rjgc1;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class StudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        String location = request.getParameter("location");
        String selfieUrl = request.getParameter("selfie");

        Student student = new Student(studentId, "默认姓名", "默认课程");
        student.signIn(location, selfieUrl);

        response.getWriter().write("签到成功！");
    }
}
