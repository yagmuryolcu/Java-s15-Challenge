package com.workintech.person;

import java.time.LocalDateTime;

public class Student extends MemberRecord {

    public Student(long memberId, String type, LocalDateTime dateOfMembership, int noBooksIssued, int maxBookLimit, String name, String address, String phoneNo) {
        super(memberId, "Student", dateOfMembership, 0, 5, name, address, phoneNo);
    }
}
