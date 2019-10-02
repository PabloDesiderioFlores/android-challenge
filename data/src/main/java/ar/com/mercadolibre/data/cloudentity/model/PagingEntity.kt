package ar.com.mercadolibre.data.cloudentity.model

data class PagingEntity (

	val total : Int,
	val offset : Int,
	val limit : Int,
	val primary_results : Int
)