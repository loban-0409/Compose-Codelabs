package com.loban.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResource: Int,
    val grain: Int,
    @DrawableRes val imageResource: Int,
)
