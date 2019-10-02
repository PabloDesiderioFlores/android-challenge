package ar.com.mercadolibre.domain.model

/**
 * Created by Pablo Flores on 26/09/19.
 */
data class Installments(
    val quantity: Int?,
    val amount: Double?,
    val rate: Int?,
    val currency_id: String?
)