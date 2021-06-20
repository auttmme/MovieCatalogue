package com.auttmme.moviecatalogue.core.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowResponse (
    var tvId: Int = 0,
    var tvTitle: String? = null,
    var tvDesc: String? = null,
    var tvYear: Int = 0,
    var tvPoster: String? = null,
    var tvSeason: Int = 0,
    var tvEpisode: Int = 0,
    var tvGenre: String? = null
        ) : Parcelable