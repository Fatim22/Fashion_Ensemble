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

public class ZDesignersActivity extends AppCompatActivity {
    int[] zuhair = {R.drawable.zd1, R.drawable.zd2, R.drawable.zd3,
            R.drawable.zd4, R.drawable.zd5, R.drawable.zd6};
    ImageView pic3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zdesigners);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        GridView mygrid3 = findViewById(R.id.gridview3);
        pic3 = findViewById(R.id.image_des3);
        Button butz = findViewById(R.id.btnZ);

        mygrid3.setAdapter(new ImageAdapter(this));

        mygrid3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(ZDesignersActivity.this, "Choose design" + (position + 1), Toast.LENGTH_SHORT).show();
                pic3.setImageResource(zuhair[position]);
            }
        });

        butz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ZDesignersActivity.this, PaymentsActivity.class));
            }
        });
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;

        public ImageAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return zuhair.length;
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

            imageView.setImageResource(zuhair[i]);
            return imageView;
        }
    }
}