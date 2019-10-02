package ar.com.mercadolibre.data.cloudentity.model

/**
 * Created by Pablo Flores on 26/09/19.
 */
data class ShippingEntity(
    val free_shipping: Boolean,
    val mode: String,
    val tags: List<String>,
    val logistic_type: String,
    val store_pick_up: Boolean
)