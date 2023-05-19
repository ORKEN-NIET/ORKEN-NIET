package kz.orkenniet.home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.orkenniet.databinding.SortedBooksListItemBinding
import kz.orkenniet.home.presentation.model.Book
import kz.orkenniet.home.presentation.model.Count
import kz.orkenniet.home.presentation.model.ListItem

class SortedByGenreAdapter :
    ListAdapter<ListItem, SortedByGenreAdapter.BookViewHolder>(BookDiffUtil()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = BookViewHolder(
        SortedBooksListItemBinding.inflate(LayoutInflater.from(parent.context))
    )

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    class BookViewHolder(
        private val binding: SortedBooksListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(bookItem: ListItem) = with(binding) {
            when (bookItem) {
                is Book -> {
                    bookImg.setImageResource(bookItem.Image)
                    txvFindResult.isVisible = false
                }

                is Count -> {
                    txvFindResult.text = bookItem.count.toString() + " Найдено книг"
                    bookImg.isVisible = false
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
