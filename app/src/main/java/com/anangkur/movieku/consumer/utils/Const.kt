package com.anangkur.movieku.consumer.utils

import android.net.Uri

object Const {

    const val EXTRA_DETAIL = "EXTRA_DETAIL"
    const val EXTRA_TYPE = "EXTRA_TYPE"

    const val PREF_LANGUAGE = "PREF_LANGUAGE"
    const val PREF_FIREBASE_MESSAGING_TOKEN = "PREF_FIREBASE_MESSAGING_TOKEN"
    const val PREF_ALARM_STATE_DAILY = "PREF_ALARM_STATE_DAILY"
    const val PREF_ALARM_STATE_RELEASE = "PREF_ALARM_STATE_RELEASE"

    const val DATABASE_RESULT = "DATABASE_RESULT"
    const val COLUMN_ID = "COLUMN_ID"
    const val COLUMN_TYPE = "COLUMN_TYPE"
    const val COLUMN_FAVOURITE = "COLUMN_FAVOURITE"
    const val COLUMN_ADULT = "COLUMN_ADULT"
    const val COLUMN_BACKDROP_PATH = "COLUMN_BACKDROP_PATH"
    const val COLUMN_GENRE_IDS = "COLUMN_GENRE_IDS"
    const val COLUMN_ORIGINAL_LANGUAGE = "COLUMN_ORIGINAL_LANGUAGE"
    const val COLUMN_ORIGINAL_TITLE = "COLUMN_ORIGINAL_TITLE"
    const val COLUMN_ORIGINAL_NAME = "COLUMN_ORIGINAL_NAME"
    const val COLUMN_OVERVIEW = "COLUMN_OVERVIEW"
    const val COLUMN_POPULARITY = "COLUMN_POPULARITY"
    const val COLUMN_POSTER_PATH = "COLUMN_POSTER_PATH"
    const val COLUMN_RELEASE_DATE = "COLUMN_RELEASE_DATE"
    const val COLUMN_TITLE = "COLUMN_TITLE"
    const val COLUMN_NAME = "COLUMN_NAME"
    const val COLUMN_VIDEO = "COLUMN_VIDEO"
    const val COLUMN_VOTE_AVERAGE = "COLUMN_VOTE_AVERAGE"
    const val COLUMN_VOTE_COUNT = "COLUMN_VOTE_COUNT"

    const val TYPE_TV = 1
    const val TYPE_MOVIE = 2

    const val requestCodeFavTv = 0
    const val requestCodeFavMovie = 1
    const val resultCodeDetail = 1
    const val typeAlarmDaily = 100
    const val typeAlarmRelease = 101

    const val favouriteStateTrue = "TRUE"
    const val favouriteStateFalse = "FALSE"

    private const val AUTHORITY = "com.anangkur.madesubmission1.provider"
    val URI_MOVIE: Uri = Uri.parse("content://$AUTHORITY/$DATABASE_RESULT")
}