package ar.com.mercadolibre.data.datasource.cloud

import ar.com.mercadolibre.data.cloudentity.model.ProductsEntity

/**
 * Created by Pablo Flores on 30/09/19.
 */
interface GetProductsByKeyWordDataStore {
    suspend fun getProductsByKeyWord(keyWord: String): ProductsEntity
}