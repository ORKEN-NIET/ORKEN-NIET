package kz.orkenniet.core.android

import android.app.Application
import kz.orkenniet.di.loginModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class OrkenNietApplication : Application() {

    override fun onCreate() {
        super.onCreate()
//        startKoin {
//            androidContext(this@OrkenNietApplication)
//            modules(loginModule)
//        }
    }
}