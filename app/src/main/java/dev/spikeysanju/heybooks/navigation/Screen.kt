package dev.spikeysanju.heybooks.navigation

import androidx.annotation.StringRes
import dev.spikeysanju.heybooks.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object BookList : Screen("book_list", R.string.text_bookList)
    object Details : Screen("book_details", R.string.text_bookDetails)
}


