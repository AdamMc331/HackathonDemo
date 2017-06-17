package com.adammcneilly.nhacks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView myImageView;
    private Button myButton;
    private boolean showPenguin = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImageView = (ImageView) findViewById(R.id.my_image_view);
        myButton = (Button) findViewById(R.id.my_button);

//        myButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showPenguin = !showPenguin;
//
//                int resource;
//                if (showPenguin) {
//                    resource = R.drawable.penguin;
//                } else {
//                    resource = R.drawable.walrus;
//                }
//
//                myImageView.setImageResource(resource);
//            }
//        });

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBrandActivity();
            }
        });
    }

    private void startBrandActivity() {
        Intent intent = new Intent(MainActivity.this, BrandActivity.class);
        startActivity(intent);
    }
}
