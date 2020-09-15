package com.adammcneilly.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView

/**
 * Displays detailed information for a Brand.
 */
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Get View references
        val imageView: ImageView = findViewById(R.id.my_image_view)
        val button: Button = findViewById(R.id.my_button)

        // Get extras from intent
        val logoResource = intent.getIntExtra(BRAND_LOGO_KEY, R.drawable.apple)
        val name = intent.getStringExtra(BRAND_NAME_KEY)

        // Set values
        imageView.setImageResource(logoResource)
        button.text = name
    }

    companion object {
        /**
         * A string key for the brand logo to be passed from one activity to another.
         */
        const val BRAND_LOGO_KEY = "brandLogo"

        /**
         * A string key for the brand name to be passed from one activity to another.
         */
        const val BRAND_NAME_KEY = "brandName"
    }
}