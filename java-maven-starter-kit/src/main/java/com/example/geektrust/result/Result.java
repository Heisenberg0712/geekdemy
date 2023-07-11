package com.example.geektrust.result;

public class Result {
    public static double SUB_TOTAL = 0;
    public static double COUPON_DISCOUNT = 0;
    public static String COUPON_NAME = "NONE";
    public static double TOTAL_PRO_DISCOUNT = 0;
    public static double PRO_MEMBERSHIP_FEE = 0;
    public static double ENROLLMENT_FEE = 0;
    public static double TOTAL = 0;

    public static void print(){
        System.out.printf("SUB_TOTAL %.2f\n", Result.SUB_TOTAL);
        System.out.printf("COUPON_DISCOUNT %s %.2f\n",Result.COUPON_NAME, Result.COUPON_DISCOUNT);
        System.out.printf("TOTAL_PRO_DISCOUNT %.2f\n", Result.TOTAL_PRO_DISCOUNT);
        System.out.printf("PRO_MEMBERSHIP_FEE %.2f\n", Result.PRO_MEMBERSHIP_FEE);
        System.out.printf("ENROLLMENT_FEE %.2f\n", Result.ENROLLMENT_FEE);
        System.out.printf("TOTAL %.2f\n", Result.TOTAL);
    }

}
