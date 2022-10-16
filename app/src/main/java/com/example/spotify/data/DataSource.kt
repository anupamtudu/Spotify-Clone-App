package com.example.spotify.data

import android.util.Log.d
import com.example.spotify.R
import com.example.spotify.model.*

object DataSource {
    val mixes = listOf(
        Mix(R.string.korean_mix, R.drawable.korean_mix),
        Mix(R.string.korean_best, R.drawable.best_korean),
        Mix(R.string.anuvjain, R.drawable.anuvjain),
        Mix(R.string.liked, R.drawable.liked),
        /*
        Mix(R.string.brb, R.drawable.brb),
        Mix(R.string.romantic, R.drawable.romantic)*/
    )
}

object TopMixDS {
    val topMixes = listOf(
        TopMix(R.string.moody_mix, R.drawable.moody_mix),
        TopMix(R.string.rosie_darling_mix, R.drawable.rosie_darling_mix),
        TopMix(R.string.ed_sheeran_mix, R.drawable.ed_sheeran_mix),
        TopMix(R.string.old_mix, R.drawable._0s_mix),
        TopMix(R.string.hindi_mix, R.drawable.hindi_mix),
        TopMix(R.string.kpop_mix, R.drawable.kpop_mix),
        TopMix(R.string.jpop_mix, R.drawable.j_pop_mix)
    )
}

object SadMixDS{
    val sadMixes = listOf(
        SadMix(R.string.life_sucks, R.drawable.life_sucks),
        SadMix(R.string.sad_covers, R.drawable.sad_covers),
        SadMix(R.string.mel_instru, R.drawable.mel_instru),
        SadMix(R.string.rainy_day_jazz, R.drawable.rainy_day_jazz),
        SadMix(R.string.midnight_hour, R.drawable.midnight_hour),
        SadMix(R.string.sad_classical, R.drawable.sad_classical),
        SadMix(R.string.lone_star_blues, R.drawable.lone_star_blues)
    )
}

object SearchGenre{
    val genres = listOf(
        Genre(R.drawable.podcasts),
        Genre(R.drawable.mad_for_you),
        Genre(R.drawable.new_releases),
        Genre(R.drawable.charts),
        Genre(R.drawable.discover),
        Genre(R.drawable.live_events),
        Genre(R.drawable.bollywood),
        Genre(R.drawable.punjabi),
        Genre(R.drawable.tamil),
        Genre(R.drawable.telugu),
        Genre(R.drawable.indie),
        Genre(R.drawable.gaming),
        Genre(R.drawable.equal),
        Genre(R.drawable.pop),
        Genre(R.drawable.radar),
        Genre(R.drawable.fresh_finds),
        Genre(R.drawable.marathi),
        Genre(R.drawable.wellness)
    )
}

object RowList{
    val buttons = listOf(
        lib(R.string.playlist),
        lib(R.string.albums),
        lib(R.string.artist),
        lib(R.string.download),
        lib(R.string.favourite)
    )
}

object LibraryList{
    val list = listOf(
        LibList(R.string.liked, R.string.liked_2, R.drawable.liked),
        LibList(R.string.warm_fuzzy, R.string.teen_culture_2, R.drawable.warm_fuzzy),
        LibList(R.string.austin_ally, R.string.liked_2, R.drawable.austin_ally),
        LibList(R.string.daily_mix_1, R.string.liked_2, R.drawable.daily_mix),
        LibList(R.string.doraemon, R.string.teen_culture_2, R.drawable.doraemon),
        LibList(R.string.mazaak, R.string.teen_culture_2, R.drawable.mazaak),
        LibList(R.string.anime_openings, R.string.teen_culture_2, R.drawable.anime_openings)
    )
}