package ar.com.mercadolibre.data.cloudentity.mapper

import ar.com.mercadolibre.data.cloudentity.model.ProductsEntity
import ar.com.mercadolibre.domain.model.Products
import javax.inject.Inject

/**
 * Created by Pablo Flores on 30/09/19.
 */
class ProductCloudDataMapper @Inject constructor(
    private val pagingMapper: PagingCloudMapper,
    private val resultsMapper: ResultsMapper
) {
    fun asDomainModel(product: ProductsEntity): Products {
        return Products(
            site_id = product.site_id,
            query = product.query,
            paging = pagingMapper.asDomainModel(product.paging),
            results = resultsMapper.asDomainModel(product.results)
        )
    }
}