package ar.com.mercadolibre.data.cloudentity.mapper

import ar.com.mercadolibre.data.cloudentity.model.SellerAddressEntity
import ar.com.mercadolibre.domain.model.SellerAddress
import javax.inject.Inject

/**
 * Created by Pablo Flores on 30/09/19.
 */
class SellerAddressCloudDataMapper @Inject constructor(
    private val countryCloudDataMapper: CountryCloudDataMapper,
    private val stateCloudDataMapper: StateCloudDataMapper,
    private val cityCloudDataMapper: CityCloudDataMapper
) {
    fun asDomainModel(sellerAddressEntityEntity: SellerAddressEntity?): SellerAddress {
        return SellerAddress(
            id = sellerAddressEntityEntity?.id,
            comment = sellerAddressEntityEntity?.comment,
            address_line = sellerAddressEntityEntity?.address_line,
            zip_code = sellerAddressEntityEntity?.zip_code,
            country = countryCloudDataMapper.asDomainModel(sellerAddressEntityEntity?.countryEntity),
            state = stateCloudDataMapper.asDomainModel(sellerAddressEntityEntity?.stateEntity),
            city = cityCloudDataMapper.asDomainModel(sellerAddressEntityEntity?.cityEntity),
            latitude = sellerAddressEntityEntity?.latitude,
            longitude = sellerAddressEntityEntity?.longitude
        )
    }
}