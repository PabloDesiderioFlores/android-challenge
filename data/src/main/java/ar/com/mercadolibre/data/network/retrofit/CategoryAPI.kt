package ar.com.mercadolibre.data.network.retrofit

import ar.com.mercadolibre.data.cloudentity.model.CategoryEntity
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 * Created by Pablo Flores on 28/09/19.
 */
interface CategoryAPI {
    @GET("sites/MLA/categories")
    fun getCategoriesAsync(
    ): Deferred<List<CategoryEntity>>
}