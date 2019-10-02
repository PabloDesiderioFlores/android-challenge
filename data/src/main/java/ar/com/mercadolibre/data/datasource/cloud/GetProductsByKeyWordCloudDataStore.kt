package ar.com.mercadolibre.data.datasource.cloud

import ar.com.mercadolibre.data.cloudentity.model.ProductsEntity
import ar.com.mercadolibre.data.network.ProductsByKeyWordRestAPI
import javax.inject.Inject

/**
 * Created by Pablo Flores on 30/09/19.
 */
class GetProductsByKeyWordCloudDataStore @Inject constructor(
    private val restAPI: ProductsByKeyWordRestAPI
) : GetProductsByKeyWordDataStore {
    override suspend fun getProductsByKeyWord(keyWord: String): ProductsEntity {
        return restAPI.getProductsByKeyWord(keyWord)
    }
}