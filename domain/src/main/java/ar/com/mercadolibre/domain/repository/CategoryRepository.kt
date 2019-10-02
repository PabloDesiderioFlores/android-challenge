package ar.com.mercadolibre.domain.repository

import ar.com.mercadolibre.domain.model.Category

/**
 * Created by Pablo Flores on 26/09/19.
 */
interface CategoryRepository {
    suspend fun refreshCategories()
    suspend fun getCategories(): List<Category>
}