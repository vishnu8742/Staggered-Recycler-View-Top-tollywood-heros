package com.example.anon.tolly10;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class full_desc extends AppCompatActivity {

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_view);
        getIncomingIntents();
    }

    private void getIncomingIntents(){

        if(getIntent().hasExtra("image_name") && getIntent().hasExtra("image_url") && getIntent().hasExtra("image_desc")){
            String imageurl = getIntent().getStringExtra("image_url");
            String imgname = getIntent().getStringExtra("image_name");
            String imgdesc = getIntent().getStringExtra("image_desc");
            setImage(imageurl, imgname, imgdesc);
        }
    }

    private void setImage(String imageurl, String imgname, String imgdesc){

        ImageView image = findViewById(R.id.full_image);
        Glide.with(this)
                .asBitmap()
                .load(imageurl)
                .into(image);

        TextView imagename = findViewById(R.id.hero_name);
        imagename.setText(imgname);

        TextView imagedesc = findViewById(R.id.full_desc);
        imagedesc.setText(imgdesc);

    }
}
