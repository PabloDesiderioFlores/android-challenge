package ar.com.mercadolibre.data.cloudentity.mapper

import ar.com.mercadolibre.data.cloudentity.model.CityEntity
import ar.com.mercadolibre.domain.model.City

/**
 * Created by Pablo Flores on 30/09/19.
 */
class CityCloudDataMapper {
    fun asDomainModel(cityEntity: CityEntity?): City {
        return City(
            id = cityEntity?.id,
            name = cityEntity?.name
        )
    }
}