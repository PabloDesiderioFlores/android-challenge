package ar.com.mercadolibre.challenge.ui.model.mapper

import ar.com.mercadolibre.challenge.ui.model.ProductUi
import ar.com.mercadolibre.domain.model.Results
import javax.inject.Inject

/**
 * Created by Pablo Flores on 30/09/19.
 */
class ProductsUiMapper @Inject constructor(
    private val sellerUiMapper: SellerUiMapper
) {
    fun asUiModel(results: List<Results?>): List<ProductUi> {
        return results.map {
            ProductUi(
                title = it?.title,
                seller = sellerUiMapper.asUiModel(it?.seller),
                price = it?.price,
                available_quantity = it?.available_quantity,
                sold_quantity = it?.sold_quantity,
                buying_mode = it?.buying_mode,
                thumbnail = it?.thumbnail,
                accepts_mercadopago = it?.accepts_mercadopago
            )
        }
    }
}