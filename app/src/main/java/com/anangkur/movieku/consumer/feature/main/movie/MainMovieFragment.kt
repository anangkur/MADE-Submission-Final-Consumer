package com.anangkur.movieku.consumer.feature.main.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.anangkur.movieku.consumer.R
import com.anangkur.movieku.consumer.data.model.Result
import com.anangkur.movieku.consumer.feature.detail.DetailActivity
import com.anangkur.movieku.consumer.feature.main.MainViewModel
import com.anangkur.movieku.consumer.feature.main.MainActivity
import com.anangkur.movieku.consumer.feature.main.MainItemListener
import com.anangkur.movieku.consumer.feature.main.tv.TvAdapter
import com.anangkur.movieku.consumer.utils.Const
import kotlinx.android.synthetic.main.fragment_favourite_movie.*

class MainMovieFragment : Fragment(), MainItemListener {

    private lateinit var viewModel: MainViewModel
    private lateinit var favMovieAdapter: TvAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favourite_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
        setupAdapter()
    }

    private fun setupViewModel(){
        viewModel = (requireActivity() as MainActivity).viewModel
        viewModel.apply {
            movieLive.observe(this@MainMovieFragment, Observer {
                favMovieAdapter.setRecyclerData(it)
                layout_error_fav.visibility = View.GONE
            })
            showErrorGetMovie.observe(this@MainMovieFragment, Observer {
                layout_error_fav.visibility = View.VISIBLE
            })
            showProgressGetMovie.observe(this@MainMovieFragment, Observer {
                if (it){
                    pb_recycler_fav.visibility = View.VISIBLE
                    layout_error_fav.visibility = View.GONE
                }else{
                    pb_recycler_fav.visibility = View.GONE
                }
            })
        }
    }

    private fun setupAdapter(){
        favMovieAdapter = TvAdapter(this)
        recycler_fav.apply {
            adapter = favMovieAdapter
            itemAnimator = DefaultItemAnimator()
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    override fun onClickItem(data: Result) {
        DetailActivity().startActivity(requireActivity(), data, Const.TYPE_MOVIE, Const.requestCodeFavMovie)
    }
}