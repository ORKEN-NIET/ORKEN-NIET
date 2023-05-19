package kz.orkenniet.home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.orkenniet.R
import kz.orkenniet.databinding.SortedBooksListItemBinding
import kz.orkenniet.home.presentation.model.Book
import kz.orkenniet.home.presentation.model.Count
import kz.orkenniet.home.presentation.model.ListItem

class SortedByGenreAdapter :
    ListAdapter<ListItem, SortedByGenreAdapter.BookViewHolder>(BookDiffUtil()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookViewHolder {
        return BookViewHolder(
            SortedBooksListItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    class BookViewHolder(binding: SortedBooksListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(bookItem: ListItem) {
            when (bookItem) {
                is Book -> {
                    itemView.findViewById<ImageView>(R.id.book_img).setImageResource(bookItem.image)
                    itemView.findViewById<TextView>(R.id.txv_find_result).isVisible = false
                }
                is Count -> {
                    itemView.findViewById<TextView>(R.id.txv_find_result).text =
                        bookItem.count.toString() + " Найдено книг"
                    itemView.findViewById<ImageView>(R.id.book_img).isVisible = false
                }
            }
        }
    }

    class BookDiffUtil : DiffUtil.ItemCallback<ListItem>() {
        override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
            return newItem == oldItem
        }

        override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
            return oldItem == newItem
        }
    }
}
