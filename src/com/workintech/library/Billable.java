package com.workintech.library;

import com.workintech.person.Reader;

public interface Billable {

    void createBill(Reader reader, double amount);
    double calculateFine(Reader reader);
}
