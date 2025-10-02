package com.workintech.person;

import java.time.LocalDateTime;

public class MemberRecord {
    private long memberId;
    private String type;
    private LocalDateTime dateOfMembership;
    private int noBooksIssued;
    private int maxBookLimit;
    private  String name;
    private String address;
    private String phoneNo;


    public MemberRecord( long memberId, String type, LocalDateTime dateOfMembership, int noBooksIssued, int maxBookLimit,String name,String address,String phoneNo){
        this.memberId=memberId;
        this.type=type;
        this.dateOfMembership=dateOfMembership;
        this.noBooksIssued=noBooksIssued;
        this.maxBookLimit=maxBookLimit;
        this.name=name;
        this.address=address;
        this.phoneNo=phoneNo;
    }

    public long getMemberId() {
        return memberId;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getDateOfMembership() {
        return dateOfMembership;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
}
