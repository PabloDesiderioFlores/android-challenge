package ar.com.mercadolibre.domain.model


data class Installments (

	val quantity : Int?,
	val amount : Double?,
	val rate : Int?,
	val currency_id : String?
)