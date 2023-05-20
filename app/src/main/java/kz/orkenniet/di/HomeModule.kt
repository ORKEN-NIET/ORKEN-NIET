package kz.orkenniet.di

import kz.orkenniet.home.data.HomeFirebaseRepository
import kz.orkenniet.home.domain.repository.HomeRepository
import kz.orkenniet.home.domain.usecase.GetSortedBooksUseCase
import kz.orkenniet.home.presentation.SortedBookViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {

    single<HomeRepository> {
        HomeFirebaseRepository(firebaseDatabase = get())
    }

    factory {
        GetSortedBooksUseCase(homeRepository = get())
    }

    viewModel {
        SortedBookViewModel(
            genre = get(),
            getSortedBooksUseCase = get(),
        )
    }
}