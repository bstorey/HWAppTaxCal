package com.homework.basfa.taxcalculator;


import java.text.DecimalFormat;
import java.util.HashMap;

public class Tax {
    private HashMap<String, Double> mStateMap = new HashMap<>();
    private static DecimalFormat df2 = new DecimalFormat(".##");
    public double mTaxAmount;

    public double calculate(double amount, String state) {
        mStateMap.put("CA", 0.075);
        mStateMap.put("IL", 0.0925);
        mStateMap.put("NY", 0.045);
        mStateMap.put("TX", 0.0825);

        mTaxAmount = amount * mStateMap.get(state);
        df2.format(mTaxAmount);

        return mTaxAmount;

    }

}
