package com.example.spotify.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class TopMix(
    @StringRes val stringResourceID: Int,
    @DrawableRes val drawableResourceID: Int
)