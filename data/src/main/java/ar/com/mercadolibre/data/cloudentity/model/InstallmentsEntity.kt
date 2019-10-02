package ar.com.mercadolibre.data.cloudentity.model

/**
 * Created by Pablo Flores on 26/09/19.
 */
data class InstallmentsEntity(
    val quantity: Int,
    val amount: Double,
    val rate: Int,
    val currency_id: String
)