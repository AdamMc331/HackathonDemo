package com.adammcneilly.demo;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
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
     *
     * @param parent   The parent view that this ViewHolder would reside in.
     * @param viewType The viewType for this particular ViewHolder. This is used if we want to return
     *                 multiple types of ViewHolders.
     */
    @NonNull
    @Override
    public BrandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_brand, parent, false);
        return new BrandViewHolder(view);
    }

    /**
     * Called by the RecyclerView to bind data to the view holder at this position.
     *
     * @param holder   The ViewHolder to bind the row item to.
     * @param position The position of this row in the RecyclerView.
     */
    @Override
    public void onBindViewHolder(@NonNull BrandViewHolder holder, int position) {
        Brand item = brands.get(position);
        holder.bindBrand(item);
    }

    /**
     * @return The number of items to display in the RecyclerView.
     */
    @Override
    public int getItemCount() {
        return brands.size();
    }

    /**
     * ViewHolder represents a row in the Recyclerview.
     */
    public class BrandViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        /**
         * Holds the logo image for the brand.
         */
        private ImageView logo;

        /**
         * Displays the name of the brand.
         */
        private TextView name;

        /**
         * Default constructor.
         *
         * @param view The root view of the ViewHolder.
         */
        public BrandViewHolder(View view) {
            super(view);

            // Get view references
            logo = view.findViewById(R.id.brand_image);
            name = view.findViewById(R.id.brand_name);

            // Set click listener to view
            view.setOnClickListener(this);
        }

        /**
         * Binds a brand to this row.
         *
         * @param item The item to be displayed.
         */
        public void bindBrand(Brand item) {
            logo.setImageResource(item.getLogoResource());
            name.setText(item.getName());
        }

        /**
         * Handles a click on this row.
         *
         * @param v The View that the user clicked.
         */
        @Override
        public void onClick(View v) {
            // Get the brand
            Brand brand = brands.get(getAdapterPosition());

            // Build an intent
            Intent intent = new Intent(v.getContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.BRAND_LOGO_KEY, brand.getLogoResource());
            intent.putExtra(DetailActivity.BRAND_NAME_KEY, brand.getName());

            // Launch activity
            v.getContext().startActivity(intent);
        }
    }
}
