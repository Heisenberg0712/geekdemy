package com.example.geektrust.constant;

public enum Programmes {
    CERTIFICATION(3000,0.02,0),
    DEGREE(5000,0.03,0),
    DIPLOMA(2500,0.01,0);

    private final double cost;
    private final double proDiscount;
    private int quantity;
    Programmes(double cost,double proDiscount,int quantity){
        this.proDiscount=proDiscount;
        this.cost=cost;
        this.quantity = quantity;
    }

    public double getProDiscount(){
        return proDiscount;
    }
    public double getCost(){
        return cost;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

}
