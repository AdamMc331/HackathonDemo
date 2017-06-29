package com.adammcneilly.demo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView

/**
 * Main activity that displays the image view and button used.
 */
class MainActivity : AppCompatActivity() {

    private var showPenguin = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the view references
        val myImageView = findViewById(R.id.my_image_view) as ImageView
        val myButton = findViewById(R.id.my_button) as Button

        // Set a click listener on the button to toggle the image
        myButton.setOnClickListener {
            // Toggle the state
            showPenguin = !showPenguin

            // Display corresponding image
            val resource = if (showPenguin) R.drawable.penguin else R.drawable.walrus
            myImageView.setImageResource(resource)
        }

        // Set a long click listener on the button to start our brand activity
        myButton.setOnLongClickListener {
            startBrandActivity()
            true
        }
    }

    /**
     * Starts the BrandActivity.
     */
    private fun startBrandActivity() {
        val intent = Intent(this@MainActivity, BrandActivity::class.java)
        startActivity(intent)
    }
}