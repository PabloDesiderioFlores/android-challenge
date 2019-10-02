package ar.com.mercadolibre.data.cloudentity.mapper

import ar.com.mercadolibre.data.cloudentity.model.AddressEntity
import ar.com.mercadolibre.domain.model.Address

/**
 * Created by Pablo Flores on 30/09/19.
 */
class AddressCloudDataMapper {
    fun asDomainModel(address: AddressEntity?): Address {
        return Address(
            state_id = address?.state_id,
            state_name = address?.state_name,
            city_id = address?.city_id,
            city_name = address?.city_name
        )
    }
}