package kz.orkenniet.home.domain.usecase

import kz.orkenniet.core.resource.Resource
import kz.orkenniet.home.domain.repository.HomeRepository
import kz.orkenniet.home.presentation.model.ListItem

class GetSortedBooksUseCase(
    private val homeRepository: HomeRepository
) {

    fun invoke(genre: String, result: (Resource<List<ListItem>>) -> Unit) {
        return homeRepository.getSortedBook(genre, result)
    }
}
