package com.anangkur.movieku.consumer.feature.main

import com.anangkur.movieku.consumer.data.model.Result

interface MainItemListener {
    fun onClickItem(data: Result)
}