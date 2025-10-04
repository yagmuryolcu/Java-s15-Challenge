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

    public void  getMember(){
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
    }

    public void increaseBookIssued(){

        if  (this.noBooksIssued < this.maxBookLimit) {
            this.noBooksIssued++;
            int remaining = maxBookLimit - noBooksIssued;
            System.out.println("Book issued successfully. Total issued: " + this.noBooksIssued);
            System.out.println("Remaining book limit: " + remaining);

        } else {
            System.out.println("Cannot issue more books. Limit reached.");
        }
    }

    public void decreaseBookIssued(){
        if (this.noBooksIssued > 0) {
            this.noBooksIssued--;
            int remaining = maxBookLimit - noBooksIssued;
            System.out.println("Book returned. Total issued: " + noBooksIssued);
            System.out.println("Remaining book limit: " + remaining);
        }
    }

    public void payBill(double fineAmount) {
        if (fineAmount > 0) {
            System.out.println("\n========== MEMBER BILL ==========");
            System.out.println("Member Name: " + name);
            System.out.println("Books Borrowed: " + noBooksIssued);
            System.out.println("Maximum Book Limit: " + maxBookLimit);
            System.out.println("Total Amount to Pay: " + fineAmount + " TL");
            System.out.println("Date: " + LocalDateTime.now());
            System.out.println("================================\n");
        } else {
            System.out.println(name + " has no fines.");
        }
    }

}
