package ar.com.mercadolibre.data.cloudentity.model

/**
 * Created by Pablo Flores on 26/09/19.
 */
data class SellerAddressEntity(
    val id: String?,
    val comment: String?,
    val address_line: String?,
    val zip_code: String?,
    val countryEntity: CountryEntity?,
    val stateEntity: StateEntity?,
    val cityEntity: CityEntity?,
    val latitude: String?,
    val longitude: String?
)