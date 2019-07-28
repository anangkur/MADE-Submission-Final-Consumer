package com.anangkur.madesubmission2.feature.detail

import com.anangkur.madesubmission2.data.model.Result

interface DetailActionListener {
    fun onAddFavourite(data: Result)
    fun onRemoveFavourite(data: Result)
}