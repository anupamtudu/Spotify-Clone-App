package com.example.spotify.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class LibList(
    @StringRes val stringResourceID: Int,
    @StringRes val stringResourceID2: Int,
    @DrawableRes val drawableResourceID: Int
)