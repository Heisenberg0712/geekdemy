package com.example.geektrust.command;

import com.example.geektrust.constant.Programmes;
import com.example.geektrust.utility.BasicBillCalculator;
import com.example.geektrust.utility.BillCalculatorInterface;
import com.example.geektrust.utility.DiscountedBillCalculator;
import com.example.geektrust.utility.coupons.abstractCoupon.Coupon;
import com.example.geektrust.utility.coupons.abstractCoupon.activeCoupons.B4G1;
import com.example.geektrust.utility.coupons.abstractCoupon.activeCoupons.DEAL_G20;
import com.example.geektrust.utility.coupons.abstractCoupon.activeCoupons.DEAL_G5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandProcessor {
    private List<Programmes> programmesList = new ArrayList<>();
    private boolean pro = false;
    private List<Coupon> couponList = new ArrayList<>();

    public void processCommands(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] cmd = input.split(" ");

            processCommand(cmd);
        }
    }

    private void processCommand(String[] cmd) {
        String command = cmd[0];

        switch (command) {
            case "ADD_PROGRAMME":
                String programmeName = cmd[1];
                int quantity = Integer.parseInt(cmd[2]);
                addProgramme(programmeName, quantity);
                break;
            case "ADD_PRO_MEMBERSHIP":
                pro = true;
                break;
            case "APPLY_COUPON":
                String couponName = cmd[1];
                applyCoupon(couponName);
                break;
        }
    }

    private void addProgramme(String programmeName, int quantity) {
        Programmes programme = Programmes.valueOf(programmeName);
        programme.setQuantity(quantity);
        programmesList.add(programme);
    }

    private void applyCoupon(String couponName) {
        switch (couponName) {
            case "DEAL_G20":
                couponList.add(new DEAL_G20());
                break;
            case "DEAL_G5":
                couponList.add(new DEAL_G5());
                break;
            case "B4G1":
                couponList.add(new B4G1());
                break;
        }
    }

    public double calculateTotalBill() {
        BillCalculatorInterface billCalculator = new BasicBillCalculator();

        if (!couponList.isEmpty()) {
            billCalculator = new DiscountedBillCalculator(billCalculator, couponList);
        }

        return billCalculator.calculateTotalBill(programmesList, pro);
    }
}
