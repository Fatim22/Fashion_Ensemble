package com.example.fashionensemble;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DesignersActivity extends Activity {
    String[] names ={"Ellie saab","Zuhair Murad","Reem Akra"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designers);


        ListView myList=findViewById(R.id.listview1);
        ArrayAdapter<String>adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        myList.setAdapter(adapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                switch (i){
                    case 0:
                        startActivity(new Intent(DesignersActivity.
                                this,EDesigners_activity.class));
                        break;

                    case 1:
                        startActivity(new Intent(DesignersActivity.
                                this,ZDesignersActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(DesignersActivity.this,RDesignersActivity.class));
                        break;

                }


            }
        });
    }
}