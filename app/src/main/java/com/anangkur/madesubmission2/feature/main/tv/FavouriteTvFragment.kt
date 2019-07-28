package com.anangkur.madesubmission2.feature.main.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.anangkur.madesubmission2.feature.detail.DetailActivity
import com.anangkur.madesubmission2.R
import com.anangkur.madesubmission2.data.model.Result
import com.anangkur.madesubmission2.feature.main.FavouriteViewModel
import com.anangkur.madesubmission2.feature.main.MainActivity
import com.anangkur.madesubmission2.feature.main.MainItemListener
import com.anangkur.madesubmission2.utils.Const
import kotlinx.android.synthetic.main.fragment_favourite_tv.*

class FavouriteTvFragment : Fragment(), MainItemListener {

    private lateinit var viewModel: FavouriteViewModel
    private lateinit var favMovieAdapter: TvAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favourite_tv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
        setupAdapter()
    }

    private fun setupViewModel(){
        viewModel = (requireActivity() as MainActivity).viewModel
        viewModel.apply {
            tvLive.observe(this@FavouriteTvFragment, Observer {
                favMovieAdapter.setRecyclerData(it)
                layout_error_fav.visibility = View.GONE
            })
            showErrorGetTv.observe(this@FavouriteTvFragment, Observer {
                layout_error_fav.visibility = View.VISIBLE
            })
            showProgressGetTv.observe(this@FavouriteTvFragment, Observer {
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
        DetailActivity().startActivity(requireActivity(), data, Const.TYPE_TV, Const.requestCodeFavTv)
    }
}