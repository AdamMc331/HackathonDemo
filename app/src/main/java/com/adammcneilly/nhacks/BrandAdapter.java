package com.adammcneilly.nhacks;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Adapter that is responsible for displaying a list of brands in a RecyclerView.
 */
@SuppressWarnings("WeakerAccess")
public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.BrandViewHolder> {

    /**
     * The brands that will be displayed.
     */
    private List<Brand> brands;

    /**
     * Basic constructor.
     *
     * @param brands The collection of brands to display.
     */
    public BrandAdapter(List<Brand> brands) {
        this.brands = brands;
    }

    /**
     * Called when the RecyclerView needs to create a ViewHolder for a specific view type.
     */
    @Override
    public BrandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_brand, parent, false);
        return new BrandViewHolder(view);
    }

    /**
     * Called by the RecyclerView to bind data to the view holder at this position.
     */
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
