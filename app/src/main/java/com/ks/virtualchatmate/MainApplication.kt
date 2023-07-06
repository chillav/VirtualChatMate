package com.ks.virtualchatmate

import android.app.Application
import com.ks.virtualchatmate.di.appModule
import io.realm.Realm
import io.realm.RealmConfiguration
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(appModule)
        }

        initRealm()
    }

    private fun initRealm() {
        Realm.init(this)
        val realmConfig = RealmConfiguration.Builder()
            .name("virtualChatMate.realm")
            .schemaVersion(0)
            .build()
        Realm.setDefaultConfiguration(realmConfig)
    }
}