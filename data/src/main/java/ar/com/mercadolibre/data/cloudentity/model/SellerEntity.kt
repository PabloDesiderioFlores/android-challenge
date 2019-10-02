package ar.com.mercadolibre.data.cloudentity.model

/**
 * Created by Pablo Flores on 26/09/19.
 */
data class SellerEntity(
    val id: Int,
    val power_seller_status: String?,
    val car_dealer: Boolean,
    val real_estate_agency: Boolean,
    val tags: List<String>
)