package com.auttmme.moviecatalogue.core.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse (
    var movieId: Int = 0,
    var movieTitle: String? = null,
    var movieDesc: String? = null,
    var movieYear: Int = 0,
    var moviePoster: String? = null,
    var movieGenre: String? = null,
    var movieDuration: String? =null
        ) : Parcelable