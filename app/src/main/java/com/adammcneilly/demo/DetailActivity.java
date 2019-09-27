package com.adammcneilly.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Displays detailed information for a Brand.
 */
public class DetailActivity extends AppCompatActivity {

    /**
     * A string key for the brand logo to be passed from one activity to another.
     */
    public static final String BRAND_LOGO_KEY = "brandLogo";

    /**
     * A string key for the brand name to be passed from one activity to another.
     */
    public static final String BRAND_NAME_KEY = "brandName";

    /**
     * Called when this activity is first displayed. Here we will get the views and populate them
     * with information passed in through the intent.
     *
     * @param savedInstanceState Any details about the saved state of this activity, if necessary.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Get View references
        ImageView imageView = findViewById(R.id.my_image_view);
        Button button = findViewById(R.id.my_button);

        // Get extras from intent
        int logoResource = getIntent().getIntExtra(BRAND_LOGO_KEY, R.drawable.apple);
        final String name = getIntent().getStringExtra(BRAND_NAME_KEY);

        // Set values
        imageView.setImageResource(logoResource);
        button.setText(name);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
