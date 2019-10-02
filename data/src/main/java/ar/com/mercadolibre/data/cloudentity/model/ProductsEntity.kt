package ar.com.mercadolibre.data.cloudentity.model


data class ProductsEntity (

    val site_id : String,
    val query : String,
    val paging : PagingEntity,
    val results : List<ResultsEntity>
)
