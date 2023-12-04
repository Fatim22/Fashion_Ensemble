package com.example.fashionensemble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

//import com.example.last.PaymentsActivity;

public class SecondActivity extends AppCompatActivity {
    String user;
    int fhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        EditText myuser = (EditText) findViewById(R.id.tf);
        EditText myfhone = (EditText) findViewById(R.id.f1);
        Button myButton = (Button) findViewById(R.id.button1);
        Spinner group = findViewById(R.id.Spinner);
        final SharedPreferences bu = PreferenceManager.getDefaultSharedPreferences(this);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = (myuser.getText().toString());
                fhone = Integer.parseInt(myfhone.getText().toString());
                SharedPreferences.Editor b2 = bu.edit();
                b2.putString("key1" , user);
                b2.putInt("key2", fhone);
                b2.apply(); // استخدم apply() بدلاً من commit() لأداء أفضل

                startActivity(new Intent(SecondActivity.this, DesignersActivity.class));
            }
        });
    }
}
