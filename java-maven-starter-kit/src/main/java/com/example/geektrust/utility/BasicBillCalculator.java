package com.example.geektrust.utility;

import com.example.geektrust.constant.Programmes;
import com.example.geektrust.result.Result;

import java.util.List;

public class BasicBillCalculator implements BillCalculatorInterface{

    @Override
    public double calculateTotalBill(List<Programmes> programmesList, boolean pro) {
        double SUB_TOTAL=0;
        for(int i=0;i< programmesList.size();i++){
            Programmes programme = programmesList.get(i);
            double cost = programme.getCost()*programme.getQuantity();
            double proDiscount = programme.getProDiscount();
            if(pro){
                SUB_TOTAL+=(cost-cost*proDiscount);
                Result.TOTAL_PRO_DISCOUNT+=(cost*proDiscount);
            }else{
                SUB_TOTAL+=cost;
            }
        }
        if(pro){
            Result.PRO_MEMBERSHIP_FEE=200;
            SUB_TOTAL+=200;
        }
        Result.SUB_TOTAL=SUB_TOTAL;

        return SUB_TOTAL;
    }

}
