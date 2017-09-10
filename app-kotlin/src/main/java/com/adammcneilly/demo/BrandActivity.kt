package com.adammcneilly.demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * Activity used to display a list of brands to the user.
 */
class BrandActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brand)

        // Get brands
        val brandList = sampleBrands

        // Create adapter
        val adapter = BrandAdapter(brandList)

        // Layout Manager
        val linearLayoutManager = LinearLayoutManager(this)

        // Setup RecyclerView
        val recyclerView = findViewById(R.id.brand_list) as RecyclerView
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }

    /**
     * List of hardcoded brands to display to the user.
     */
    private val sampleBrands = listOf(Brand("Apple", R.drawable.apple), Brand("Facebook", R.drawable.facebook), Brand("Google", R.drawable.google), Brand("Microsoft", R.drawable.microsoft))
}