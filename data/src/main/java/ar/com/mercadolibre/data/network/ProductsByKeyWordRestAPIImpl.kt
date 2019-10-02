package ar.com.mercadolibre.data.network

import ar.com.mercadolibre.data.cloudentity.model.ProductsEntity
import ar.com.mercadolibre.data.network.retrofit.ProductsByKwyWordAPI
import javax.inject.Inject

/**
 * Created by Pablo Flores on 30/09/19.
 */
class ProductsByKeyWordRestAPIImpl @Inject constructor(
    private val api: ProductsByKwyWordAPI
) : ProductsByKeyWordRestAPI {
    override suspend fun getProductsByKeyWord(keyWord: String): ProductsEntity {
        return api.getCategoriesAsync(keyWord).await()
    }
}