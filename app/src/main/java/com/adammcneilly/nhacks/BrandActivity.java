package com.adammcneilly.nhacks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BrandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);

        List<Brand> brandList = new ArrayList<>();
        brandList.add(new Brand("Apple", R.drawable.apple));
        brandList.add(new Brand("Facebook", R.drawable.facebook));
        brandList.add(new Brand("Google", R.drawable.google));
        brandList.add(new Brand("Microsoft", R.drawable.microsoft));

        // Create adapter
        BrandAdapter adapter = new BrandAdapter(brandList);

        // Layout Manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.brand_list);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
