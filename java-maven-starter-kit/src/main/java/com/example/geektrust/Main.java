package com.example.geektrust;

import com.example.geektrust.command.CommandProcessor;
import com.example.geektrust.constant.ExtraFee;
import com.example.geektrust.constant.Programmes;
import com.example.geektrust.result.Result;
import com.example.geektrust.utility.BasicBillCalculator;
import com.example.geektrust.utility.BillCalculatorInterface;
import com.example.geektrust.utility.DiscountedBillCalculator;
import com.example.geektrust.utility.coupons.abstractCoupon.Coupon;
import com.example.geektrust.utility.coupons.abstractCoupon.activeCoupons.B4G1;
import com.example.geektrust.utility.coupons.abstractCoupon.activeCoupons.DEAL_G20;
import com.example.geektrust.utility.coupons.abstractCoupon.activeCoupons.DEAL_G5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis);

            CommandProcessor commandProcessor = new CommandProcessor();
            commandProcessor.processCommands(sc);

            sc.close();

            double finalAmount = commandProcessor.calculateTotalBill();
            Result.TOTAL = finalAmount;
            Result.print();
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }

    }
}
