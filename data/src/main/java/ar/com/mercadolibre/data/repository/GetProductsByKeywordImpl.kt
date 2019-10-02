package ar.com.mercadolibre.data.repository

import ar.com.mercadolibre.data.cloudentity.mapper.ProductCloudDataMapper
import ar.com.mercadolibre.data.datasource.cloud.GetProductsByKeyWordDataStore
import ar.com.mercadolibre.domain.model.Products
import ar.com.mercadolibre.domain.repository.GetProductsByKeyword
import javax.inject.Inject

/**
 * Created by Pablo Flores on 30/09/19.
 */
class GetProductsByKeywordImpl @Inject constructor(
    private val dataStore: GetProductsByKeyWordDataStore,
    private val mapper: ProductCloudDataMapper
) : GetProductsByKeyword {
    override suspend fun getProductsByKeyword(keyWord: String): Products {
        return mapper.asDomainModel(dataStore.getProductsByKeyWord(keyWord))
    }
}