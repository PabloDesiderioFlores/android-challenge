package ar.com.mercadolibre.data.network

import ar.com.mercadolibre.data.cloudentity.model.CategoryEntity
import ar.com.mercadolibre.data.network.retrofit.CategoryAPI
import javax.inject.Inject

/**
 * Created by Pablo Flores on 28/09/19.
 */
class CategoryRestApiImpl @Inject constructor(
    private val api: CategoryAPI
) : CategoryRestAPI {
    override suspend fun getCategories(): List<CategoryEntity> {
        return api.getCategoriesAsync().await()
    }
}