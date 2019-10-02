package ar.com.mercadolibre.domain.repository

import ar.com.mercadolibre.domain.model.Products

/**
 * Created by Pablo Flores on 30/09/19.
 */
interface GetProductsByKeyword {
    suspend fun getProductsByKeyword(keyWord: String): Products
}