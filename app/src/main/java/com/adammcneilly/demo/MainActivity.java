package com.adammcneilly.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Main activity that displays the image view and button used.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Boolean flag for whether we should show the penguin or the walrus.
     */
    private boolean showPenguin = true;

    /**
     * Called when this activity is first created. Here we will get the views, populate the
     * corresponding animal image, and handle the button clicks.
     *
     * @param savedInstanceState Any details about the saved state of this activity, if necessary.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the view references
        final ImageView myImageView = (ImageView) findViewById(R.id.my_image_view);
        final Button myButton = (Button) findViewById(R.id.my_button);

        // Set a click listener on the button to toggle the image
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle the state
                showPenguin = !showPenguin;

                // Display corresponding image
                int resource = showPenguin ? R.drawable.penguin : R.drawable.walrus;
                myImageView.setImageResource(resource);
            }
        });

        // Set a long click listener on the button to start our brand activity
        myButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startBrandActivity();
                return true;
            }
        });
    }

    /**
     * Starts the BrandActivity.
     */
    private void startBrandActivity() {
        Intent intent = new Intent(MainActivity.this, BrandActivity.class);
        startActivity(intent);
    }
}
