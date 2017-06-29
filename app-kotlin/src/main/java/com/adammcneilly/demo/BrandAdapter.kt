package com.adammcneilly.demo

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * Adapter that is responsible for displaying a list of brands in a RecyclerView.
 */
class BrandAdapter(private val brands: List<Brand>) : RecyclerView.Adapter<BrandAdapter.BrandViewHolder>() {

    /**
     * Called when the RecyclerView needs to create a ViewHolder for a specific view type.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_brand, parent, false)
        return BrandViewHolder(view)
    }

    /**
     * Called by the RecyclerView to bind data to the view holder at this position.
     */
    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        val item = brands[position]
        holder.bindBrand(item)
    }

    override fun getItemCount(): Int {
        return brands.size
    }

    inner class BrandViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        private val logo: ImageView = view.findViewById(R.id.brand_image) as ImageView
        private val name: TextView = view.findViewById(R.id.brand_name) as TextView

        init {
            view.setOnClickListener(this)
        }

        fun bindBrand(item: Brand) {
            logo.setImageResource(item.logoResource)
            name.setText(item.name)
        }

        override fun onClick(v: View) {
            val brand = brands[adapterPosition]

            val intent = Intent(v.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.BRAND_LOGO_KEY, brand.logoResource)
            intent.putExtra(DetailActivity.BRAND_NAME_KEY, brand.name)

            v.context.startActivity(intent)
        }
    }
}