package com.example.fashionensemble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class RDesignersActivity extends AppCompatActivity {
    int[] reem = {R.drawable.rs1, R.drawable.rs2, R.drawable.rs3,
            R.drawable.rs4, R.drawable.rs5, R.drawable.rs6};
    ImageView pic4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rdesigners);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        GridView mygrid4 = findViewById(R.id.gridview4);
        pic4 = findViewById(R.id.image_des4);
        Button butR = findViewById(R.id.btnR);

        mygrid4.setAdapter(new ImageAdapter(this));

        mygrid4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(RDesignersActivity.this, "Choose design" + (position + 1), Toast.LENGTH_SHORT).show();
                pic4.setImageResource(reem[position]);
            }
        });

        butR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RDesignersActivity.this, PaymentsActivity.class));
            }
        });
    }

    class ImageAdapter extends BaseAdapter {
        private Context context;

        public ImageAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return reem.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView;
            if (view == null) {
                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(330, 300));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            } else {
                imageView = (ImageView) view;
            }
            imageView.setImageResource(reem[i]);
            return imageView;
        }
    }
}