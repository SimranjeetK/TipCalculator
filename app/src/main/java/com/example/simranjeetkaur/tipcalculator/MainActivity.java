package com.example.simranjeetkaur.tipcalculator;

import android.icu.util.IslamicCalendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText enteredAmount;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView result;
    private TextView seektext;
    private int seekBarPercentage;
    private float enteredBillFloat;
    private TextView totalresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredAmount = (EditText) findViewById(R.id.paymentId);
        seekBar =(SeekBar) findViewById(R.id.seekBarID);
        calculateButton = (Button) findViewById(R.id.buttonId);
        result = (TextView) findViewById(R.id.resultID);
        seektext = (TextView) findViewById(R.id.seektextId);
        totalresult = (TextView) findViewById(R.id.totalId);

       calculateButton.setOnClickListener(this);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seektext.setText(String.valueOf(seekBar.getProgress()) + " %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBarPercentage = seekBar.getProgress();

            }
        });


    }

    public void calculate()
    {
        float answer =0.00f;
        float total = 0.00f;
        if(!enteredAmount.getText().toString().equals("")) {

            enteredBillFloat = Float.parseFloat(enteredAmount.getText().toString());
            answer= enteredBillFloat* seekBarPercentage /100;
            total = enteredBillFloat+answer;
            result.setText("Your tip will be $ " + String.valueOf(answer));
            totalresult.setText("Total will be $ " + total);
        }
        else{
            Toast.makeText(MainActivity.this, "Please enter amount", Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onClick(View v) {

        calculate();
    }
}
