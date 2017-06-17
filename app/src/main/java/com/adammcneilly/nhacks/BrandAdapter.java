package com.adammcneilly.nhacks;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by adam.mcneilly on 6/17/17.
 */

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.BrandViewHolder> {

    private List<Brand> brands;

    public BrandAdapter(List<Brand> brands) {
        this.brands = brands;
    }

    @Override
    public BrandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_brand, parent, false);
        return new BrandViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BrandViewHolder holder, int position) {
        Brand item = brands.get(position);
        holder.bindBrand(item);
    }

    @Override
    public int getItemCount() {
        return brands.size();
    }

    public class BrandViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView logo;
        private TextView name;

        public BrandViewHolder(View view) {
            super(view);

            logo = (ImageView) view.findViewById(R.id.brand_image);
            name = (TextView) view.findViewById(R.id.brand_name);

            view.setOnClickListener(this);
        }

        public void bindBrand(Brand item) {
            logo.setImageResource(item.getLogoResource());
            name.setText(item.getName());
        }

        @Override
        public void onClick(View v) {
            Brand brand = brands.get(getAdapterPosition());

            Intent intent = new Intent(v.getContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.BRAND_LOGO_KEY, brand.getLogoResource());
            intent.putExtra(DetailActivity.BRAND_NAME_KEY, brand.getName());

            v.getContext().startActivity(intent);
        }
    }
}
