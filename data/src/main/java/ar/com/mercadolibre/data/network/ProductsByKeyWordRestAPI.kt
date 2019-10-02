package ar.com.mercadolibre.data.network

import ar.com.mercadolibre.data.cloudentity.model.ProductsEntity

/**
 * Created by Pablo Flores on 30/09/19.
 */
interface ProductsByKeyWordRestAPI {
    suspend fun getProductsByKeyWord(keyWord: String): ProductsEntity
}