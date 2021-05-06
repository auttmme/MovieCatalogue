package com.auttmme.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse (
    var movieId: Int,
    var movieTitle: String,
    var movieDesc: String,
    var movieYear: Int,
    var moviePoster: String,
    var movieGenre: String,
    var movieDuration: String
        ) : Parcelable