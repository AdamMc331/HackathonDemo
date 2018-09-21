package com.adammcneilly.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity used to display a list of brands to the user.
 */
public class BrandActivity extends AppCompatActivity {

    /**
     * This is called when the activity is shown for the first time. We use this to get the brands,
     * create our {@link BrandAdapter}, and setup the {@link RecyclerView}.
     *
     * @param savedInstanceState Any information about the saved state, if necessary.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);

        // Get brands
        List<Brand> brandList = getSampleBrands();

        // Create adapter
        BrandAdapter adapter = new BrandAdapter(brandList);

        // Layout Manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        // Setup RecyclerView
        RecyclerView recyclerView = findViewById(R.id.brand_list);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    /**
     * @return A collection of Brands to display in the application.
     */
    private List<Brand> getSampleBrands() {
        List<Brand> brandList = new ArrayList<>();
        brandList.add(new Brand("Apple", R.drawable.apple));
        brandList.add(new Brand("Facebook", R.drawable.facebook));
        brandList.add(new Brand("Google", R.drawable.google));
        brandList.add(new Brand("Microsoft", R.drawable.microsoft));
        return brandList;
    }
}
