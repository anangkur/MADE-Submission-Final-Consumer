package com.anangkur.movieku.consumer.feature.detail

import com.anangkur.movieku.consumer.data.model.Result

interface DetailActionListener {
    fun onAddFavourite(data: Result)
    fun onRemoveFavourite(data: Result)
}