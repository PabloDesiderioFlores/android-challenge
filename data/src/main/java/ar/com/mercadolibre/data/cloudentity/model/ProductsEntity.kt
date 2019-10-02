package ar.com.mercadolibre.data.cloudentity.model

/**
 * Created by Pablo Flores on 26/09/19.
 */
data class ProductsEntity(
    val site_id: String,
    val query: String,
    val paging: PagingEntity,
    val results: List<ResultsEntity>
)
