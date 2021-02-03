package com.example.marksmanagementsystem;

public class Student {

    private int id;
    private String studentID;
    private String subject;
    private String marks;
    private String department;
    private String gender;


    public Student() {
    }

    public Student(int id, String studentID, String subject, String marks, String department, String gender) {
        this.id = id;
        this.studentID = studentID;
        this.subject = subject;
        this.marks = marks;
        this.department = department;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
