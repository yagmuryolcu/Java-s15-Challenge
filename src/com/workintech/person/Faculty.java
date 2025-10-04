package com.workintech.person;

import java.time.LocalDateTime;

public class Faculty  extends MemberRecord{

    public Faculty(long memberId, String type, LocalDateTime dateOfMembership, int noBooksIssued, int maxBookLimit, String name, String address, String phoneNo) {
        super(memberId, "Faculty", dateOfMembership, 0, 10, name, address, phoneNo);
    }
}
