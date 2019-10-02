package ar.com.mercadolibre.domain.model

/**
 * Created by Pablo Flores on 26/09/19.
 */
data class Paging(
    val total: Int,
    val offset: Int,
    val limit: Int,
    val primary_results: Int
)