package com.anangkur.movieku.consumer.feature.main

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.anangkur.movieku.consumer.R
import com.anangkur.movieku.consumer.data.Repository
import com.anangkur.movieku.consumer.data.local.LocalDataSource
import com.anangkur.movieku.consumer.data.local.SharedPreferenceHelper
import com.anangkur.movieku.consumer.data.remote.RemoteDataSource
import com.anangkur.movieku.consumer.feature.custom.TabAdapter
import com.anangkur.movieku.consumer.feature.main.movie.MainMovieFragment
import com.anangkur.movieku.consumer.feature.main.tv.MainTvFragment
import com.anangkur.movieku.consumer.utils.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail.toolbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var tabAdapter: TabAdapter
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupToolbar()
        setupTabAdapter()
        setupViewPager()
        setupCustomTab()
        setupSelectedCustomTab(0)
        setupViewModel()
        viewModel.getAllData()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        viewModel.getAllData()
    }

    private fun setupToolbar(){
        setSupportActionBar(toolbar)
        title = resources.getString(R.string.toolbar_favourite)
    }

    private fun setupTabAdapter(){
        tabAdapter = TabAdapter(supportFragmentManager)
        val resourceMovieActive =  ContextCompat.getDrawable(this,R.drawable.ic_movie_active) as Drawable
        val resourceMovieInActive =  ContextCompat.getDrawable(this,R.drawable.ic_movie_inactive) as Drawable
        val resourceTvActive =  ContextCompat.getDrawable(this,R.drawable.ic_tv_active) as Drawable
        val resourceTvInActive =  ContextCompat.getDrawable(this,R.drawable.ic_tv_inactive) as Drawable
        tabAdapter.addFragment(MainMovieFragment(), getString(R.string.tab_movie), resourceMovieActive, resourceMovieInActive)
        tabAdapter.addFragment(MainTvFragment(), getString(R.string.tab_tv), resourceTvActive, resourceTvInActive)
    }

    private fun setupViewPager(){
        vp_fav.adapter = tabAdapter
        tab_fav.setupWithViewPager(vp_fav)
        vp_fav.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
                // do nothing
            }
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                // do nothing
            }
            override fun onPageSelected(position: Int) {
                setupCustomTab()
                setupSelectedCustomTab(position)
            }
        })
    }

    private fun setupCustomTab(){
        for (i in 0 until tab_fav.tabCount) {
            val tab = tab_fav.getTabAt(i)
            tab?.customView = null
            tab?.customView = tabAdapter.getTabView(i, this)
        }
    }

    private fun setupSelectedCustomTab(position: Int){
        val tab = tab_fav.getTabAt(position)
        tab?.customView = null
        tab?.customView = tabAdapter.getSelectedTabView(position, this)
    }

    private fun setupViewModel(){
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(
                application,
                Repository(
                    LocalDataSource(
                        SharedPreferenceHelper(this),
                        this
                    ),
                    RemoteDataSource
                )
            )
        ).get(MainViewModel::class.java)

        viewModel.apply {}
    }
}
