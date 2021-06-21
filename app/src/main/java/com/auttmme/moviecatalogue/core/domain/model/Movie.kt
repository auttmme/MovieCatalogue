package com.auttmme.moviecatalogue.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie (
    val movieId: Int = 0,
    val movieTitle: String? = null,
    val movieDesc: String? = null,
    val movieYear: Int = 0,
    val moviePoster: String? = null,
    val movieGenre: String? = null,
    val movieDuration: String? =null,
    val movieFavorited: Boolean
        ) : Parcelable