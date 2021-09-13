package com.kl3jvi.iquiitask.model.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "image_db")
data class FavoriteImage(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val title: String,
    @ColumnInfo val imageUrl: String?,
    @ColumnInfo val favoriteDish: Boolean
) : Parcelable