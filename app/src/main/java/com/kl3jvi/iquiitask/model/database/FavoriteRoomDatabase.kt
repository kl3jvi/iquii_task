package com.kl3jvi.iquiitask.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kl3jvi.iquiitask.model.entities.FavoriteImage

@Database(entities = [FavoriteImage::class], version = 1)
abstract class FavoriteRoomDatabase : RoomDatabase() {

    abstract fun favImageDao(): FavoriteDao


    companion object {
        @Volatile
        private var INSTANCE: FavoriteRoomDatabase? = null

        fun getDatabase(context: Context): FavoriteRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavoriteRoomDatabase::class.java,
                    "image_db"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}