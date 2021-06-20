package com.auttmme.moviecatalogue.core.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.auttmme.moviecatalogue.core.data.source.local.LocalDataSource
import com.auttmme.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.core.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.core.data.source.remote.RemoteDataSource
import com.auttmme.moviecatalogue.core.utils.AppExecutors
import com.auttmme.moviecatalogue.core.utils.DataDummy
import com.auttmme.moviecatalogue.core.utils.LiveDataTestUtil
import com.auttmme.moviecatalogue.core.utils.PagedListUtil
import com.auttmme.moviecatalogue.core.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class MovieCatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val movieCatalogueRepository = FakeMovieRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponses[0].movieId
    private val tvResponses = DataDummy.generateRemoteDummyTvShows()
    private val tvId = tvResponses[0].tvId

    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getAllMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getMovieById() {
        val dummyMovieEntity = MutableLiveData<MovieEntity>()
        dummyMovieEntity.value = DataDummy.generateDummyDetailMovie(DataDummy.generateDummyMovies()[0], false)
        `when`(local.getMovieById(movieId)).thenReturn(dummyMovieEntity)

        val movieEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getMovieById(movieId))
        verify(local).getMovieById(movieId)
        assertNotNull(movieEntities.data)
        assertNotNull(movieEntities.data?.movieTitle)
        assertEquals(movieResponses[0].movieTitle, movieEntities.data?.movieTitle)
    }

    @Test
    fun getFavoriteMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getFavoriteMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getFavoriteMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllTvShows()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getAllTvShows()

        val tvEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getAllTvShows()
        assertNotNull(tvEntities)
        assertEquals(tvResponses.size.toLong(), tvEntities.data?.size?.toLong())
    }

    @Test
    fun getTvShowById() {
        val dummyTvShowEntity = MutableLiveData<TvShowEntity>()
        dummyTvShowEntity.value = DataDummy.generateDummyDetailTvShow(DataDummy.generateDummyTvShows()[0], false)
        `when`(local.getTvShowById(tvId)).thenReturn(dummyTvShowEntity)

        val tvEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getTvShowById(tvId))
        verify(local).getTvShowById(tvId)
        assertNotNull(tvEntities.data)
        assertNotNull(tvEntities.data?.tvTitle)
        assertEquals(tvResponses[0].tvTitle, tvEntities.data?.tvTitle)
    }

    @Test
    fun getFavoriteTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int,TvShowEntity>
        `when`(local.getFavoriteTvShows()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getFavoriteTvShow()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getFavoriteTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(tvResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }
}