package ar.com.mercadolibre.challenge.ui.provider

import android.content.SearchRecentSuggestionsProvider

/**
 * Created by Pablo Flores on 01/10/19.
 */
class SearchContentProvider : SearchRecentSuggestionsProvider() {
    init {
        setupSuggestions(AUTHORITY, MODE)
    }

    companion object {
        const val AUTHORITY = "ar.com.mercadolibre.challenge.ui.provider.SearchContentProvider"
        const val MODE: Int = DATABASE_MODE_QUERIES or DATABASE_MODE_2LINES
    }
}