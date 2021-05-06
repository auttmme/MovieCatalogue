package com.auttmme.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowResponse (
    var tvId: Int,
    var tvTitle: String,
    var tvDesc: String,
    var tvYear: Int,
    var tvPoster: String,
    var tvSeason: Int,
    var tvEpisode: Int,
    var tvGenre: String
        ) : Parcelable