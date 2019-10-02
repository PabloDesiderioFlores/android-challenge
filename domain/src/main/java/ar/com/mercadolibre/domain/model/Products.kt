package ar.com.mercadolibre.domain.model

/**
 * Created by Pablo Flores on 26/09/19.
 */
data class Products(
    val site_id: String?,
    val query: String?,
    val paging: Paging?,
    val results: List<Results?>
)
