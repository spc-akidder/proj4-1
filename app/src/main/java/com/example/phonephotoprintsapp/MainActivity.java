package com.example.phonephotoprintsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double input;
    double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText print = (EditText) findViewById(R.id.userPrint);
        final RadioButton rad4x6 = (RadioButton) findViewById(R.id.rad4x6);
        final RadioButton rad5x7 = (RadioButton) findViewById(R.id.rad5x7);
        final RadioButton rad8x10 = (RadioButton) findViewById(R.id.rad8x10);
        final TextView result = (TextView) findViewById(R.id.result);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=Double.parseDouble(print.getText().toString());
                DecimalFormat price = new DecimalFormat("$#.##");
                if (input > 50) {
                    result.setText("No more than 50 prints is allowed.");
                }
                else {
                    if (rad4x6.isChecked()) {
                        total = input * .19;
                    }
                    else if (rad5x7.isChecked()) {
                        total = input * .49;
                    }
                    else {
                        total = input * .79;
                    }
                    result.setText("The order cost is " + price.format(total));
                }
            }
        });
    }
}
