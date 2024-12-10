package rjgc1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttendanceManager {
    private static AttendanceManager instance;
    private List<AttendanceRecord> attendanceRecords;

    private AttendanceManager() {
        attendanceRecords = new ArrayList<>();
    }

    public static AttendanceManager getInstance() {
        if (instance == null) {
            instance = new AttendanceManager();
        }
        return instance;
    }

    public void recordAttendance(Student student, String selfie, String location) {
        Date timestamp = new Date(); // 当前时间
        AttendanceRecord record = new AttendanceRecord(student, selfie, location, timestamp);
        attendanceRecords.add(record);
        System.out.println("签到成功: " + record);
    }

    public void showAttendanceRecords() {
        // 打印所有签到记录
        if (attendanceRecords.isEmpty()) {
            System.out.println("没有签到记录！");
        } else {
            for (AttendanceRecord record : attendanceRecords) {
                System.out.println(record);
            }
        }
    }

    public List<AttendanceRecord> generateReport(Date startDate, Date endDate) {
        // 根据时间范围生成报表
        List<AttendanceRecord> filteredRecords = new ArrayList<>();
        for (AttendanceRecord record : attendanceRecords) {
            if (record.getTimestamp().after(startDate) && record.getTimestamp().before(endDate)) {
                filteredRecords.add(record);
            }
        }
        return filteredRecords;
    }

    public void handleException(AttendanceRecord record) {
        // 假设处理异常签到，比如时间重复、签到过早等
        System.out.println("处理异常签到: " + record);
    }
}
