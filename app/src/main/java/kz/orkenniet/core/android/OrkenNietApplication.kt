package kz.orkenniet.core.android

import android.app.Application
import kz.orkenniet.di.authModule
import kz.orkenniet.di.firebaseModule
import kz.orkenniet.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class OrkenNietApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@OrkenNietApplication)
            modules(
                firebaseModule,
                authModule,
                homeModule,
            )
        }
    }
}