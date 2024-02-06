package com.loban.days30.model

import com.loban.days30.R

object CharacterRepository {

    val characters = listOf(
        Character(
            day = 1,
            name = R.string.day1_character_name,
            image = R.drawable.day1_image,
            dialog = R.string.day1_character_dialog,
        ),
        Character(
            day = 2,
            name = R.string.day2_character_name,
            image = R.drawable.day2_image,
            dialog = R.string.day2_character_dialog,
        ),
        Character(
            day = 3,
            name = R.string.day3_character_name,
            image = R.drawable.day3_image,
            dialog = R.string.day3_character_dialog,
        ),
        Character(
            day = 4,
            name = R.string.day4_character_name,
            image = R.drawable.day4_image,
            dialog = R.string.day4_character_dialog,
        ),
        Character(
            day = 5,
            name = R.string.day5_character_name,
            image = R.drawable.day5_image,
            dialog = R.string.day5_character_dialog,
        ),
    )
}
