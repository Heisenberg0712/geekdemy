package com.example.geektrust.utility.coupons.abstractCoupon;

import com.example.geektrust.constant.Programmes;

import java.util.List;

public abstract class Coupon {
    public abstract double applyCoupon(List<Programmes> programmesList, boolean pro,double total_cost);
    public abstract String getCouponName();

    public abstract boolean checkIfApplicable(List<Programmes> programmesList,double total_cost);

}
