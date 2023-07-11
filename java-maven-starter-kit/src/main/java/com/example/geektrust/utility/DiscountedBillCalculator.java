package com.example.geektrust.utility;

import com.example.geektrust.constant.ExtraFee;
import com.example.geektrust.result.Result;
import com.example.geektrust.utility.coupons.abstractCoupon.Coupon;
import com.example.geektrust.constant.Programmes;
import com.example.geektrust.utility.coupons.CouponFinder;

import java.util.List;

public class DiscountedBillCalculator implements BillCalculatorInterface{
    private final BillCalculatorInterface basicBillCalculator;
    private final List<Coupon> couponsList;

    public DiscountedBillCalculator(BillCalculatorInterface basicBillCalculator, List<Coupon> couponsList) {
        this.basicBillCalculator = basicBillCalculator;
        this.couponsList=couponsList;
    }

    @Override
    public double calculateTotalBill(List<Programmes> programmesList, boolean pro) {

        double SUB_TOTAL = basicBillCalculator.calculateTotalBill(programmesList, pro);
        double discountApplied = SUB_TOTAL;
        discountApplied = getDiscountApplied(programmesList, pro, SUB_TOTAL, discountApplied);
        if(discountApplied < 6666){
            discountApplied+=ExtraFee.getEnrollmentFee();
            Result.ENROLLMENT_FEE = ExtraFee.getEnrollmentFee();
        }
        return discountApplied;
    }

    private double getDiscountApplied(List<Programmes> programmesList, boolean pro, double SUB_TOTAL, double discountApplied) {
        Coupon applicableCoupon = null;
        if(couponsList.size()>0){
            applicableCoupon = CouponFinder.chooseAppropriateCoupon(couponsList, programmesList, SUB_TOTAL);
            if(applicableCoupon!=null){
                Result.COUPON_NAME = applicableCoupon.getCouponName();
            }
        }
        if(applicableCoupon != null){
            double discount = applicableCoupon.applyCoupon(programmesList, pro, SUB_TOTAL);
            Result.COUPON_DISCOUNT += discount;
            discountApplied -=discount;
        }
        return discountApplied;
    }

}
