package ar.com.mercadolibre.data.cloudentity.mapper

import ar.com.mercadolibre.data.cloudentity.model.SellerEntity
import ar.com.mercadolibre.domain.model.Seller

/**
 * Created by Pablo Flores on 30/09/19.
 */
class SellerCloudDataMapper {
    fun asDomainModel(sellerEntity: SellerEntity?): Seller {
        return Seller(
            id = sellerEntity?.id,
            power_seller_status = sellerEntity?.power_seller_status,
            car_dealer = sellerEntity?.car_dealer,
            real_estate_agency = sellerEntity?.real_estate_agency,
            tags = sellerEntity?.tags
        )
    }
}