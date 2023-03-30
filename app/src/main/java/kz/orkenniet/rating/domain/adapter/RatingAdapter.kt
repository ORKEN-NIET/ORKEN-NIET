package kz.orkenniet.rating.domain.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.orkenniet.R
import kz.orkenniet.rating.data.model.RatingItem

class RatingAdapter :
    ListAdapter<RatingItem, RatingAdapter.RatingItemViewHolder>(RatingItemDiffUtill()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RatingAdapter.RatingItemViewHolder {
        return RatingItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rating_list_item_places, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RatingAdapter.RatingItemViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    class RatingItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(ratingItem: RatingItem) {
            itemView.findViewById<TextView>(R.id.txv_name_places).text = ratingItem.name
            itemView.findViewById<TextView>(R.id.txv_pages_places).text = ratingItem.pages
            itemView.findViewById<ImageView>(R.id.img_medal).setImageResource(R.drawable.gold)
        }
    }

    class RatingItemDiffUtill : DiffUtil.ItemCallback<RatingItem>() {
        override fun areItemsTheSame(oldItem: RatingItem, newItem: RatingItem): Boolean {
            return newItem.pages == oldItem.pages
        }

        override fun areContentsTheSame(oldItem: RatingItem, newItem: RatingItem): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }
    }
}
