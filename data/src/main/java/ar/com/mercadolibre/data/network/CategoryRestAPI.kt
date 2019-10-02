package ar.com.mercadolibre.data.network

import ar.com.mercadolibre.data.cloudentity.model.CategoryEntity

/**
 * Created by Pablo Flores on 28/09/19.
 */
interface CategoryRestAPI {
    suspend fun getCategories(): List<CategoryEntity>
}