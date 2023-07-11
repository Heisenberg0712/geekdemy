package com.example.geektrust.utility.coupons;

import com.example.geektrust.constant.Programmes;
import com.example.geektrust.utility.coupons.abstractCoupon.Coupon;
import com.example.geektrust.utility.coupons.abstractCoupon.activeCoupons.B4G1;
import com.example.geektrust.utility.coupons.abstractCoupon.activeCoupons.DEAL_G20;
import com.example.geektrust.utility.coupons.abstractCoupon.activeCoupons.DEAL_G5;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CouponFinder {
    public static Coupon chooseAppropriateCoupon(List<Coupon> couponList, List<Programmes> programmesList, double totalCost) {
        if (hasB4G1Coupon(programmesList)) {
            return new B4G1();
        }

        Set<Coupon> applicableCoupons = filterApplicableCoupons(couponList, programmesList, totalCost);

        if (applicableCoupons.isEmpty()) {
            return null;
        }

        return selectBestCoupon(applicableCoupons);
    }

    private static boolean hasB4G1Coupon(List<Programmes> programmesList) {
        int quantity = programmesList.stream()
                .mapToInt(Programmes::getQuantity)
                .sum();
        return quantity >= 4;
    }

    private static Set<Coupon> filterApplicableCoupons(List<Coupon> couponList, List<Programmes> programmesList, double totalCost) {
        return couponList.stream()
                .filter(coupon -> coupon.checkIfApplicable(programmesList, totalCost))
                .collect(Collectors.toSet());
    }

    private static Coupon selectBestCoupon(Set<Coupon> applicableCoupons) {
        for (Coupon coupon : applicableCoupons) {
            if (coupon instanceof DEAL_G20) {
                return coupon;
            }
        }

        return new DEAL_G5();
    }

}
