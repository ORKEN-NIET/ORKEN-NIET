package kz.orkenniet.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
123import org.koin.dsl.module

val firebaseModule = module {

    single {
        FirebaseAuth.getInstance()
    }

    single {
        FirebaseDatabase.getInstance()
    }
}