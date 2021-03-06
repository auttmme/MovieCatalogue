package com.dicoding.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovie() {
        onView(withText("MOVIE")).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withText("MOVIE")).perform(click())
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_movie_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_movie_title)).check(matches(withText(dummyMovie[0].movieTitle)))
        onView(withId(R.id.text_movie_year)).check(matches(isDisplayed()))
        onView(withId(R.id.text_movie_year)).check(matches(withText(dummyMovie[0].movieYear.toString())))
        onView(withId(R.id.text_movie_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.text_movie_genre)).check(matches(withText(dummyMovie[0].movieGenre)))
        onView(withId(R.id.text_movie_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.text_movie_duration)).check(matches(withText(dummyMovie[0].movieDuration)))
        onView(withId(R.id.text_movie_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.text_movie_desc)).check(matches(withText(dummyMovie[0].movieDesc)))
    }

    @Test
    fun loadTvShow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_tv_title)).check(matches(withText(dummyTvShow[0].tvTitle)))
        onView(withId(R.id.text_tv_year)).check(matches(isDisplayed()))
        onView(withId(R.id.text_tv_year)).check(matches(withText(dummyTvShow[0].tvYear.toString())))
        onView(withId(R.id.text_tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.text_tv_genre)).check(matches(withText(dummyTvShow[0].tvGenre)))
        onView(withId(R.id.text_tv_season)).check(matches(isDisplayed()))
        onView(withId(R.id.text_tv_season)).check(matches(withText(dummyTvShow[0].tvSeason.toString())))
        onView(withId(R.id.text_tv_episode)).check(matches(isDisplayed()))
        onView(withId(R.id.text_tv_episode)).check(matches(withText(dummyTvShow[0].tvEpisode.toString())))
        onView(withId(R.id.text_tv_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.text_tv_desc)).check(matches(withText(dummyTvShow[0].tvDesc)))
    }
}