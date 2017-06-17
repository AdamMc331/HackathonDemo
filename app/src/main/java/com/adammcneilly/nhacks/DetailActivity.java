package com.adammcneilly.nhacks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    public static final String BRAND_LOGO_KEY = "brandLogo";
    public static final String BRAND_NAME_KEY = "brandName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = (ImageView) findViewById(R.id.my_image_view);
        Button button = (Button) findViewById(R.id.my_button);

        // Get extras from intent
        int logoResource = getIntent().getIntExtra(BRAND_LOGO_KEY, R.drawable.apple);
        String name = getIntent().getStringExtra(BRAND_NAME_KEY);

        imageView.setImageResource(logoResource);
        button.setText(name);
    }
}
