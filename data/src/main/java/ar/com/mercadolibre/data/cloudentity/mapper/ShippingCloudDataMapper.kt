package ar.com.mercadolibre.data.cloudentity.mapper

import ar.com.mercadolibre.data.cloudentity.model.ShippingEntity
import ar.com.mercadolibre.domain.model.Shipping

/**
 * Created by Pablo Flores on 30/09/19.
 */
class ShippingCloudDataMapper {
    fun asDomainModel(shippingEntity: ShippingEntity?): Shipping {
        return Shipping(
            free_shipping = shippingEntity?.free_shipping,
            mode = shippingEntity?.mode,
            tags = shippingEntity?.tags,
            logistic_type = shippingEntity?.logistic_type,
            store_pick_up = shippingEntity?.store_pick_up
        )
    }
}