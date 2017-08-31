package com.homework.basfa.taxcalculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View;
import android.widget.TextView;
import java.text.DecimalFormat;
import android.widget.Toast;

public class TaxCalculator extends AppCompatActivity {
    // Declare our view variables
    private RadioGroup mStates;
    private RadioButton mStateSelection;
    private Button mCalculateTaxBtn;
    private EditText mDollarAmount;
    private TextView mTaxAmount;
    private TextView mEnterAmount;
    private TextView mSelectState;
    private double mDollarAmountNumber;
    private int mStateID;
    private String mState;
    private Tax mTax = new Tax();
    private String mTaxString;
    private static DecimalFormat df2 = new DecimalFormat("0.00");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_calculator);

        // Assign the Views from the layout file to the corresponding variables
        mDollarAmount = (EditText) findViewById(R.id.dollarAmount);
        mStates = (RadioGroup) findViewById(R.id.states);
        mCalculateTaxBtn = (Button) findViewById(R.id.calculateTaxBtn);
        mTaxAmount = (TextView) findViewById(R.id.taxAmount);
        mEnterAmount = (TextView) findViewById(R.id.enterAmount);
        mSelectState = (TextView) findViewById(R.id.selectState);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(mDollarAmount.getText().toString()) == true) {
                    Toast.makeText(TaxCalculator.this, "Please enter a valid amount.", Toast.LENGTH_SHORT).show();
                    mEnterAmount.setTextColor(Color.GRAY);
                } else if(mStates.getCheckedRadioButtonId() == -1){
                    Toast.makeText(TaxCalculator.this, "Please select a state.", Toast.LENGTH_SHORT).show();
                    mSelectState.setTextColor(Color.GRAY);
                } else {
                    mDollarAmountNumber = Double.parseDouble(mDollarAmount.getText().toString());
                    mStateID = mStates.getCheckedRadioButtonId();
                    mStateSelection = (RadioButton) mStates.findViewById(mStateID);
                    mState = (String) mStateSelection.getText();
                    mTaxString = "" + df2.format(mTax.calculate(mDollarAmountNumber, mState));
                    mTaxAmount.setText(mTaxString);
                    mSelectState.setTextColor(Color.WHITE);
                    mEnterAmount.setTextColor(Color.WHITE);
                }
            }
        };
        mCalculateTaxBtn.setOnClickListener(listener);
    }
}
