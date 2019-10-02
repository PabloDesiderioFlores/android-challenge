package ar.com.mercadolibre.data.cloudentity.mapper

import ar.com.mercadolibre.data.cloudentity.model.DifferentialPricingEntity
import ar.com.mercadolibre.domain.model.DifferentialPricing

/**
 * Created by Pablo Flores on 30/09/19.
 */
class DifferentialPricingCloudDataMapper {
    fun asDomainModel(differentialPricingEntity: DifferentialPricingEntity?): DifferentialPricing {
        return DifferentialPricing(
            id = differentialPricingEntity?.id
        )
    }
}