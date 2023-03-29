package kz.orkenniet.rating.domain.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.orkenniet.R
import kz.orkenniet.rating.data.model.RatingItem

class RatingAdapter(var ratingList: List<RatingItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class PlacesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(ratingItem: RatingItem) {
            itemView.findViewById<TextView>(R.id.txv_name_places).text = ratingItem.name
            itemView.findViewById<TextView>(R.id.txv_pages_places).text = ratingItem.pages
            itemView.findViewById<ImageView>(R.id.img_medal).setImageResource(R.drawable.gold)
        }
    }

    class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(ratingItem: RatingItem) {
            itemView.findViewById<TextView>(R.id.txv_name).text = ratingItem.name
            itemView.findViewById<TextView>(R.id.txv_pages).text = ratingItem.pages
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.rating_list_item_places, parent, false)
            PlacesViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.ratine_list_item_simple, parent, false)
            SimpleViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return ratingList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> {
                0
            }
            else -> {
                1
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == 0) {
            (holder as PlacesViewHolder).bind(ratingList[position])
        } else {
            (holder as SimpleViewHolder).bind(ratingList[position])
        }
    }
}
