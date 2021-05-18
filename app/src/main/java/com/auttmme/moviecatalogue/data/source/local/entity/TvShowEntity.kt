package com.auttmme.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tventities")
data class TvShowEntity (
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "tvId")
        var tvId: Int,

        @ColumnInfo(name = "tvTitle")
        var tvTitle: String?,

        @ColumnInfo(name = "tvDesc")
        var tvDesc: String?,

        @ColumnInfo(name = "tvYear")
        var tvYear: Int,

        @ColumnInfo(name = "tvPoster")
        var tvPoster: String?,

        @ColumnInfo(name = "tvSeason")
        var tvSeason: Int,

        @ColumnInfo(name = "tvEpisode")
        var tvEpisode: Int,

        @ColumnInfo(name = "tvGenre")
        var tvGenre: String?,

        @ColumnInfo(name = "tvLiked")
        var tvFavorited: Boolean = false
        )