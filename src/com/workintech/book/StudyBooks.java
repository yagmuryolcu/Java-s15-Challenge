package com.workintech.book;

import com.workintech.person.Author;

import java.time.LocalDateTime;

public class StudyBooks extends Book{

    private String subject;
    private String gradeLevel;

    public StudyBooks(long book_ID, Author author, String name, double price, boolean status, String edition, LocalDateTime date_of_purchase, String owner, String subject, String gradeLevel) {
        super(book_ID, author, name, price, status, edition, date_of_purchase, owner);
        this.subject=subject;
        this.gradeLevel=gradeLevel;
    }

    public  String getSubject(){
        return subject;
    }
    public  String getGradeLevel(){
        return gradeLevel;
    }

    @Override
    public void display(){
        System.out.println("Type : Study Book ");
        System.out.println("Subject : " + subject);
        System.out.println("Grade Level : " + gradeLevel);
    }

    @Override
    public String toString() {
        return "StudyBooks{" +
                "Subject='" + subject + '\'' +
                ", Grade Level='" + gradeLevel + '\'' +
                '}';
    }
}
