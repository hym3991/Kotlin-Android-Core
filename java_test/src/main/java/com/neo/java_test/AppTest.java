package com.neo.java_test;

import java.math.BigDecimal;

public class AppTest {

    public static void main(String[] args) {
        int price = 10876;
        System.out.println("price Int :"+price+" -> "+getPriceBigDecimal("%.2f万",price));
    }

    private static String getPriceBigDecimal(String format, int currentPrice) {
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(currentPrice));
        double doubleValue = bigDecimal.divide(new BigDecimal(10000)).doubleValue();
        return String.format(format, doubleValue);
    }
}
