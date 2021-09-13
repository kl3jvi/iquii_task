package com.kl3jvi.iquiitask.application

import android.app.Application
import com.kl3jvi.iquiitask.model.database.FavoriteImageRepository
import com.kl3jvi.iquiitask.model.database.FavoriteRoomDatabase

class IQUIIApplication : Application() {
    private val database by lazy { FavoriteRoomDatabase.getDatabase(this@IQUIIApplication) }
    val repository by lazy { FavoriteImageRepository(database.favImageDao()) }
}