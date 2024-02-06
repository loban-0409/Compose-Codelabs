package com.loban.days30.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Character(
    val day: Int,
    @StringRes val name: Int,
    @DrawableRes val image: Int,
    @StringRes val dialog: Int,
)
