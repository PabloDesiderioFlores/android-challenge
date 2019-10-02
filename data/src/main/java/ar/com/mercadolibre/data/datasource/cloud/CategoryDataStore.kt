package ar.com.mercadolibre.data.datasource.cloud

import ar.com.mercadolibre.data.cloudentity.model.CategoryEntity

/**
 * Created by Pablo Flores on 26/09/19.
 */
interface CategoryDataStore {
    suspend fun getCategories(): List<CategoryEntity>
}