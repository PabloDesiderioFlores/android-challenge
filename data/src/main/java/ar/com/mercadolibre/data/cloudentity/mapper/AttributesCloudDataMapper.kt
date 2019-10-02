package ar.com.mercadolibre.data.cloudentity.mapper

import ar.com.mercadolibre.data.cloudentity.model.AttributesEntity
import ar.com.mercadolibre.domain.model.Attributes

/**
 * Created by Pablo Flores on 30/09/19.
 */
class AttributesCloudDataMapper {
    fun asDomainModel(attributesEntity: List<AttributesEntity>?): List<Attributes> {
        return attributesEntity!!.map {
            Attributes(
                attribute_group_id = it.attribute_group_id,
                attribute_group_name = it.attribute_group_name,
                source = it.source,
                id = it.id,
                name = it.name,
                value_id = it.value_id,
                value_name = it.value_name
            )
        }
    }
}