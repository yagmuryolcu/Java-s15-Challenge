package com.workintech.book;

import com.workintech.person.Author;
import com.workintech.person.Reader;

import java.time.LocalDateTime;

public class StudyBooks extends Book{

    private String subject;
    private String gradeLevel;

    public StudyBooks(long book_ID, Author author, String name, double price, boolean status, String edition, LocalDateTime date_of_purchase, String subject, String gradeLevel) {
        super(book_ID, author, name, price, status, edition, date_of_purchase);
        this.subject=subject;
        this.gradeLevel=gradeLevel;
    }

    public  String getSubject(){
        return subject;
    }
    public  String getGradeLevel(){
        return gradeLevel;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    @Override
    public void display(){
        super.display();
        System.out.println("Subject : " + subject);
        System.out.println("Grade Level : " + gradeLevel);
        System.out.println("-------------------------------------");
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", Subject='" + subject + '\'' +
                ", GradeLevel='" + gradeLevel + '\'' +
                '}';
    }
}
