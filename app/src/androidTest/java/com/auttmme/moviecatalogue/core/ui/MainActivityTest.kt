package com.auttmme.moviecatalogue.core.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.auttmme.moviecatalogue.R
import com.auttmme.moviecatalogue.core.utils.DataDummy
import com.auttmme.moviecatalogue.core.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShows()

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
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
        onView(withId(R.id.navigation_tvShow)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withId(R.id.navigation_tvShow)).perform(click())
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

    @Test
    fun loadFavoriteMovies() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.action_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.navigation_favorite)).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_movie_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_movie_year)).check(matches(isDisplayed()))
        onView(withId(R.id.text_movie_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.text_movie_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.action_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }

    @Test
    fun loadFavoriteTvShows() {
        onView(withId(R.id.navigation_tvShow)).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.action_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.navigation_favorite)).perform(click())
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_tv_year)).check(matches(isDisplayed()))
        onView(withId(R.id.text_tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.text_tv_season)).check(matches(isDisplayed()))
        onView(withId(R.id.action_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }
}