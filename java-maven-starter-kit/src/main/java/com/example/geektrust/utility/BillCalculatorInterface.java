package com.example.geektrust.utility;

import com.example.geektrust.constant.Programmes;

import java.util.List;

public interface BillCalculatorInterface {
    double calculateTotalBill(List<Programmes> programmesList, boolean pro);
}
