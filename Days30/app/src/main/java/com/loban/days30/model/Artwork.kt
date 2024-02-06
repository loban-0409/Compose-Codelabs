package com.loban.days30.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Artwork(
    val day: Int,
    @DrawableRes val image: Int,
    @StringRes val description: Int,
    @StringRes val detail: Int,
)
