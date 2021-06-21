package com.auttmme.moviecatalogue.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShow (
    val tvId: Int = 0,
    val tvTitle: String? = null,
    val tvDesc: String? = null,
    val tvYear: Int = 0,
    val tvPoster: String? = null,
    val tvSeason: Int = 0,
    val tvEpisode: Int = 0,
    val tvGenre: String? = null,
    val tvFavorited: Boolean
        ): Parcelable