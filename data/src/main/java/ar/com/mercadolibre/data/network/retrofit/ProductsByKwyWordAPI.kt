package ar.com.mercadolibre.data.network.retrofit

import ar.com.mercadolibre.data.cloudentity.model.ProductsEntity
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Pablo Flores on 30/09/19.
 */
interface ProductsByKwyWordAPI {
    @GET("sites/MLA/search/")
    fun getCategoriesAsync(
        @Query("q") q: String
    ): Deferred<ProductsEntity>
}