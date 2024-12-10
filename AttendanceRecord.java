package rjgc1;

import java.util.Date;

public class AttendanceRecord {
    private Student student;
    private String selfie;
    private String location;
    private Date timestamp;

    public AttendanceRecord(Student student, String selfie, String location, Date timestamp) {
        this.student = student;
        this.selfie = selfie;
        this.location = location;
        this.timestamp = timestamp;
    }

    public Student getStudent() {
        return student;
    }

    public String getSelfie() {
        return selfie;
    }

    public String getLocation() {
        return location;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Student: " + student.getName() + ", Time: " + timestamp + ", Location: " + location;
    }
}
