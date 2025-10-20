package com.example.task02;

public class DiscountBill extends Bill{
    private final double discount;
    public DiscountBill(double discount) {
        this.discount = discount;
    }

    public String getDiscount(){
        return discount + "%";
    }

    public long getAbsoluteDiscount() {
        return super.getPrice() - getPrice();
    }
    @Override
    public long getPrice() {
        long price = super.getPrice();
        return (long) (price * (1 - discount / 100));
    }
}
