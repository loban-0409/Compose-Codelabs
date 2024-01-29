package com.loban.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val title: Int,
    val grain: Int,
    @DrawableRes val image: Int,
)
