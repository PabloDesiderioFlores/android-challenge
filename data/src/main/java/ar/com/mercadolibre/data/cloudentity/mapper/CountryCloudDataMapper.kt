package ar.com.mercadolibre.data.cloudentity.mapper

import ar.com.mercadolibre.data.cloudentity.model.CountryEntity
import ar.com.mercadolibre.domain.model.Country

/**
 * Created by Pablo Flores on 30/09/19.
 */
class CountryCloudDataMapper {
    fun asDomainModel(countryEntity: CountryEntity?): Country {
        return Country(
            id = countryEntity?.id,
            name = countryEntity?.name
        )
    }
}