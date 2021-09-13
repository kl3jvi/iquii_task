package com.kl3jvi.iquiitask.model.database

import androidx.annotation.WorkerThread
import com.kl3jvi.iquiitask.model.entities.FavoriteImage

class FavoriteImageRepository(private val favoriteDao: FavoriteDao) {
    @WorkerThread
    suspend fun insertImage(favoriteImage: FavoriteImage) {
        favoriteDao.insertFavImage(favoriteImage)
    }


}