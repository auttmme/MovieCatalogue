package com.dicoding.moviecatalogue.data

data class TvShowEntity (
        var tvId: Int,
        var tvTitle: String,
        var tvDesc: String,
        var tvYear: Int,
        var tvPoster: Int,
        var tvSeason: Int,
        var tvEpisode: Int,
        var tvGenre: String
        )