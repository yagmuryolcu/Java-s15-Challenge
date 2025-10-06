package com.workintech.person;

import java.time.LocalDateTime;
import java.util.Objects;

public class Student extends MemberRecord {
    private final String studentId;
    private String major;
    private int year;

    public Student(long memberId, String type, LocalDateTime dateOfMembership, int noBooksIssued, int maxBookLimit, String name, String address, String phoneNo,String studentId,String major,int year) {
        super(memberId, "Student", dateOfMembership, 0, 5, name, address, phoneNo);
        this.studentId=Objects.requireNonNull(studentId);
        this.major=Objects.requireNonNull(major);
        this.year=year;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getMajor() {
        return major;
    }

    public int getYear() {
        return year;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setYear(int year) {
        if (year >= 1 && year <= 4) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Year must be between 1-4.");
        }
    }

    @Override
    public void getMember() {
        super.getMember();
        System.out.println("Student ID: " + studentId);
        System.out.println("Major: " + major);
        System.out.println("Year: " + year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(studentId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + getName() + '\'' +
                ", Student ID='" + studentId + '\'' +
                ", Major='" + major + '\'' +
                ", Year=" + year +
                ", Books Issued=" + getNoBooksIssued() +
                '}';
    }
}
