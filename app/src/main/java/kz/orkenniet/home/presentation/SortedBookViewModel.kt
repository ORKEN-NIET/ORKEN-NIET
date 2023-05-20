package kz.orkenniet.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kz.orkenniet.R
import kz.orkenniet.core.resource.Resource
import kz.orkenniet.home.domain.repository.HomeRepository
import kz.orkenniet.home.domain.usecase.GetSortedBooksUseCase
import kz.orkenniet.home.presentation.model.Book
import kz.orkenniet.home.presentation.model.Count
import kz.orkenniet.home.presentation.model.ListItem

class SortedBookViewModel(
    genre: String,
    private val getSortedBooksUseCase: GetSortedBooksUseCase
) : ViewModel() {

    private val _sortedBookList = MutableStateFlow(getSortedBookList())
    val sortedBookList = _sortedBookList.asStateFlow()

    private val _selectedGenre = MutableStateFlow(genre)
    val selectedGenre = _selectedGenre.asStateFlow()

    private val _error = MutableSharedFlow<String>()
    val error = _error.asSharedFlow()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    fun getSortedBooks(genre: String) {
        _selectedGenre.value = genre
        _loading.value = true
        getSortedBooksUseCase.invoke(genre) { result ->
            when (result) {
                is Resource.Loading -> { /*todo*/ }
                is Resource.Error -> {
                    viewModelScope.launch {
                        _error.emit(result.message.orEmpty())
                    }
                }
                is Resource.Success -> {
//                    _sortedBookList.value = result.data.orEmpty()
                }
            }
            _loading.value = false
        }
    }

    // todo remove mock data
    private fun getSortedBookList(): List<ListItem> {
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
