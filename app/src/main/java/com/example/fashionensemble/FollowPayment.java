package com.example.fashionensemble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FollowPayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_payment);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        TextView Title = findViewById(R.id.textView);

        EditText NumCard = findViewById(R.id.editTextNumber);

        EditText ExpCard = findViewById(R.id.editTextDate);

        EditText PassCArd = findViewById(R.id.editTextTextPassword);

        Button btn = findViewById(R.id.Click);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FollowPayment.this , PaymentsActivity.class));

            }
        });


    }
}