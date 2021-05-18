package com.auttmme.moviecatalogue.utils

import android.content.Context
import com.auttmme.moviecatalogue.data.source.remote.response.MovieResponse
import com.auttmme.moviecatalogue.data.source.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val movieList = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getInt("id")
                val title = movie.getString("title")
                val description = movie.getString("description")
                val year = movie.getInt("year")
                val poster = movie.getString("poster")
                val genre = movie.getString("genre")
                val duration = movie.getString("duration")

                val movieResponse = MovieResponse(id, title, description, year, poster, genre, duration)
                movieList.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return movieList
    }

    fun loadMovieById(movieId: Int): List<MovieResponse> {
        val file = String.format("MovieResponses.json", movieId)
        val movieList = ArrayList<MovieResponse>()
        try {
            val result = parsingFileToString(file)
            if (result != null) {
                val responseObject = JSONObject(result)
                val listArray = responseObject.getJSONArray("movies")
                for (i in 0 until listArray.length()) {
                    val movie = listArray.getJSONObject(i)

                    val id = movie.getInt("id")
                    val title = movie.getString("title")
                    val description = movie.getString("description")
                    val year = movie.getInt("year")
                    val poster = movie.getString("poster")
                    val genre = movie.getString("genre")
                    val duration = movie.getString("duration")

                    val movieResponse = MovieResponse(id, title, description, year, poster, genre, duration)
                    movieList.add(movieResponse)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return movieList
    }

    fun loadTvShows(): List<TvShowResponse> {
        val tvList = ArrayList<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvShowResponses.json").toString())
            val listArray = responseObject.getJSONArray("tvShows")
            for (i in 0 until listArray.length()) {
                val tvShow = listArray.getJSONObject(i)

                val id = tvShow.getInt("id")
                val title = tvShow.getString("title")
                val description = tvShow.getString("description")
                val year = tvShow.getInt("year")
                val poster = tvShow.getString("poster")
                val season = tvShow.getInt("season")
                val episode = tvShow.getInt("episode")
                val genre = tvShow.getString("genre")

                val tvShowResponse = TvShowResponse(id, title, description, year, poster, season, episode, genre)
                tvList.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return tvList
    }

    fun loadTvShowById(tvId: Int): List<TvShowResponse> {
        val file = String.format("TvShowResponses.json", tvId)
        val tvList = ArrayList<TvShowResponse>()
        try {
            val result = parsingFileToString(file)
            if (result != null) {
                val responseObject = JSONObject(result)
                val listArray = responseObject.getJSONArray("tvShows")
                for (i in 0 until listArray.length()) {
                    val tvShow = listArray.getJSONObject(i)

                    val id = tvShow.getInt("id")
                    val title = tvShow.getString("title")
                    val description = tvShow.getString("description")
                    val year = tvShow.getInt("year")
                    val poster = tvShow.getString("poster")
                    val season = tvShow.getInt("season")
                    val episode = tvShow.getInt("episode")
                    val genre = tvShow.getString("genre")

                    val tvShowResponse = TvShowResponse(id, title, description, year, poster, season, episode, genre)
                    tvList.add(tvShowResponse)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return tvList
    }
}