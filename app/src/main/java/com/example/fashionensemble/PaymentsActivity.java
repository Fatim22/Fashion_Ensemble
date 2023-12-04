package com.example.fashionensemble;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class PaymentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        TextView Result = findViewById (R.id.Resulrt);

        TextView Result2 = findViewById (R.id.Resultt);

        TextView Result3 = findViewById (R.id.ResultChoose);

        Button BtnDate = findViewById (R.id.BtnSelectDAte);

        Button BtnComplete = findViewById (R.id.BtnComplete);

        Button BtnEnter = findViewById (R.id.Enter);

        RadioButton Card = findViewById(R.id.radioButton1);

        RadioButton Cash = findViewById(R.id.radioButton2);

        Calendar C = Calendar.getInstance();

        DateFormat fndate =  DateFormat.getDateInstance();

////        String getTextUser = User.getText() ;

        SharedPreferences SharedUser = PreferenceManager.getDefaultSharedPreferences(this);
        String user = SharedUser.getString("key1", "0");


        BtnEnter.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (Card.isChecked()) {
                    Result3.setText("Card Method For Payments");
                    if (Card.isChecked()){
                        startActivity(new Intent(PaymentsActivity.this , FollowPayment.class));

                    }
                }
                else if (Cash.isChecked()){
                    Result3.setText("Cash Method For Payments");
                }
            }
        });


        DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                C.set(Calendar.YEAR , year);
                C.set(Calendar.MONTH, month );
                C.set(Calendar.DAY_OF_MONTH, day );
                Result.setText("Date Delivry  " +fndate.format(C.getTime()));
            }
        };


        BtnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(PaymentsActivity.this, d ,
                        C.get(Calendar.YEAR), C.get(Calendar.MONTH),
                        C.get(Calendar.DAY_OF_MONTH)).show();

            }
        });


        BtnComplete.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {


                Result2.setText("The order has been confirmed " + user + ", Thank You !");


            }
        });


    }

}