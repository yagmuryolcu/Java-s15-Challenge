package com.workintech.person;

import java.time.LocalDateTime;
import java.util.Objects;

public class Faculty extends MemberRecord {
    private String department;
    private String title; // Prof, Dr
    private final String employeeId;

    public Faculty(long memberId, LocalDateTime dateOfMembership, int noBooksIssued,
                   String name, String address, String phoneNo,
                   String department, String title, String employeeId) {
        super(memberId, "Faculty", dateOfMembership, noBooksIssued,
                5, name, address, phoneNo);
        this.department = department;
        this.title = title;
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public String getTitle() {
        return title;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void getMember() {
        super.getMember();
        System.out.println("Title: " + title);
        System.out.println("Department: " + department);
        System.out.println("Employee ID: " + employeeId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(employeeId, faculty.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(employeeId);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "Name='" + getName() + '\'' +
                ", Title='" + title + '\'' +
                ", Department='" + department + '\'' +
                ", Employee ID='" + employeeId + '\'' +
                ", Books Issued=" + getNoBooksIssued() +
                '}';
    }
}