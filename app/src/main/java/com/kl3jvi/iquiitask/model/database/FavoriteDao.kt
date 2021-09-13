package com.kl3jvi.iquiitask.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kl3jvi.iquiitask.model.entities.FavoriteImage
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Insert
    suspend fun insertFavImage(favImage: FavoriteImage)

    @Query("SELECT * FROM IMAGE_DB WHERE favorite = 1")
    fun getFavoriteImages(): Flow<List<FavoriteImage>>

}