package com.kl3jvi.iquiitask.model.database

import androidx.room.Dao
import androidx.room.Insert
import com.kl3jvi.iquiitask.model.entities.FavoriteImage

@Dao
interface FavoriteDao {
    @Insert
    suspend fun insertFavImage(favImage: FavoriteImage)


}