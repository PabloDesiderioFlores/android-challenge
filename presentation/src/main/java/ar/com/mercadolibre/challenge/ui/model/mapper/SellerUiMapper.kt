package ar.com.mercadolibre.challenge.ui.model.mapper

import ar.com.mercadolibre.challenge.ui.model.SellerUi
import ar.com.mercadolibre.domain.model.Seller

/**
 * Created by Pablo Flores on 01/10/19.
 */
class SellerUiMapper {
    fun asUiModel(seller: Seller?): SellerUi {
        return SellerUi(
            power_seller_status = seller?.power_seller_status,
            car_dealer = seller?.car_dealer,
            real_estate_agency = seller?.real_estate_agency,
            tags = seller?.tags
        )
    }
}