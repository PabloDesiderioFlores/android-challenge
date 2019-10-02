package ar.com.mercadolibre.data.cloudentity.model

/**
 * Created by Pablo Flores on 26/09/19.
 */
data class PagingEntity(
    val total: Int,
    val offset: Int,
    val limit: Int,
    val primary_results: Int
)