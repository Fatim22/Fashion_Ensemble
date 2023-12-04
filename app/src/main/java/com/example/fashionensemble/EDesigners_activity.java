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

public class EDesigners_activity extends AppCompatActivity {
    int [] DESIGN1 = {R.drawable.img1, R.drawable.img2,
            R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6};
    ImageView pic1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_designers);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        GridView mygrid = (GridView) findViewById(R.id.gridview1);
        ImageView pic1 = (ImageView) findViewById(R.id.image_des1);
        Button butE = (Button) findViewById(R.id.btnE) ;

        mygrid.setAdapter(new Imageadapter(this));

        mygrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Choose design" + (position + 1), Toast.LENGTH_SHORT).show();
                pic1.setImageResource(DESIGN1[position]);
            }
        });
        butE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EDesigners_activity.
                        this,PaymentsActivity.class));

            }
        });
    }

    public class Imageadapter extends BaseAdapter {
        private Context context;

        public Imageadapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return DESIGN1.length;
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
            pic1 = new ImageView(context);
            pic1.setImageResource(DESIGN1[i]);
            pic1.setScaleType(ImageView.ScaleType.FIT_XY);
            pic1.setLayoutParams(new GridView.LayoutParams(330, 300));
            return pic1;
        }
    }
}