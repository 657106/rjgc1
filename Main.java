package rjgc1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 模拟教师登录
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入教师用户名:");
        String username = scanner.nextLine();
        System.out.println("请输入教师密码:");
        String password = scanner.nextLine();

        Teacher teacher = new Teacher(username, password);
        if (teacher.login()) {
            System.out.println("教师登录成功！");
            
            // 让教师查看签到记录
            System.out.println("请输入学生学号查看签到记录:");
            String studentId = scanner.nextLine();
            teacher.viewStudentAttendance(studentId);
        } else {
            System.out.println("教师登录失败！");
        }

        // 模拟学生签到
        System.out.println("请输入学生学号进行签到:");
        String studentId = scanner.nextLine();
        System.out.println("请输入签到地点:");
        String location = scanner.nextLine();
        System.out.println("请输入自拍照片的链接:");
        String selfieUrl = scanner.nextLine();

        Student student = new Student(studentId, "张三", "Java课程");
        student.signIn(location, selfieUrl);

        // 查看学生签到记录
        student.viewAttendance();

        // 关闭数据库连接
        scanner.close();
    }
}
