package ar.com.mercadolibre.data.datasource.cloud

import ar.com.mercadolibre.data.cloudentity.model.CategoryEntity
import ar.com.mercadolibre.data.network.CategoryRestAPI
import javax.inject.Inject

/**
 * Created by Pablo Flores on 28/09/19.
 */
class CategoryCloudDataStore @Inject constructor(
    private val restAPI: CategoryRestAPI
) : CategoryDataStore {
    override suspend fun getCategories(): List<CategoryEntity> {
        return restAPI.getCategories()
    }
}