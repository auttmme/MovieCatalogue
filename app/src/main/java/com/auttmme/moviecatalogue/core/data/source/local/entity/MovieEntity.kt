package com.auttmme.moviecatalogue.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieentities")
data class MovieEntity(
        @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
        var movieId: Int,

        @ColumnInfo(name = "movieTitle")
        var movieTitle: String?,

        @ColumnInfo(name = "movieDesc")
        var movieDesc: String?,

        @ColumnInfo(name = "movieYear")
        var movieYear: Int,

        @ColumnInfo(name = "moviePoster")
        var moviePoster: String?,

        @ColumnInfo(name = "movieGenre")
        var movieGenre: String?,

        @ColumnInfo(name = "movieDuration")
        var movieDuration: String?,

        @ColumnInfo(name = "movieFavorited")
        var movieFavorited: Boolean = false
        )


