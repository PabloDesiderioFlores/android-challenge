package ar.com.mercadolibre.domain.model

data class Products(

    val site_id: String?,
    val query: String?,
    val paging: Paging?,
    val results: List<Results?>
)
