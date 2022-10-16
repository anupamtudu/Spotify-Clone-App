package com.example.spotify.ui.theme

import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.spotify.R


val SpotifyFont = FontFamily(
    Font(R.font.gotham_bold, FontWeight.Bold),
    Font(R.font.gotham_medium)
)
// Set of Material typography styles to start with
val Typography = Typography(

    h1 = TextStyle(
        fontFamily = SpotifyFont,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),

    h2 = TextStyle(
        fontFamily = SpotifyFont,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = Color.LightGray
    ),

    h3 = TextStyle(
        fontFamily = SpotifyFont,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        color = Color.Gray
    ),

    h4 = TextStyle(
        fontFamily = SpotifyFont,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),

    h5 = TextStyle(
        fontFamily = SpotifyFont,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        color = Color.White
    ),

    h6 = TextStyle(
        fontFamily = SpotifyFont,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = Color.Gray
    ),

    body1 = TextStyle(
        fontFamily = SpotifyFont,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),

    body2 = TextStyle(
        fontFamily = SpotifyFont,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
    ),

)