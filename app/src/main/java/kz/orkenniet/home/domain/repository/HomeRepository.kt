package kz.orkenniet.home.domain.repository

import kz.orkenniet.core.resource.Resource
import kz.orkenniet.home.presentation.model.ListItem

interface HomeRepository {

    fun getSortedBook(genre: String, result: (Resource<List<ListItem>>) -> Unit)
}