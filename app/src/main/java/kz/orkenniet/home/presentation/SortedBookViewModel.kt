package kz.orkenniet.home.presentation

import androidx.lifecycle.ViewModel
import kz.orkenniet.R
import kz.orkenniet.home.model.Book
import kz.orkenniet.home.model.Count
import kz.orkenniet.home.model.ListItem

class SortedBookViewModel : ViewModel() {
    @Suppress("MagicNumber")
    fun getSortedBookList(): List<ListItem> {
        return arrayListOf(
            Count(431),
            Book(R.drawable.kitap),
            Book(R.drawable.kitap2),
            Book(R.drawable.kitap3),
            Book(R.drawable.kitap4),
            Book(R.drawable.kitap5),
            Book(R.drawable.kitap6),
            Book(R.drawable.kitap7),
            Book(R.drawable.kitap8),
        )
    }
}
