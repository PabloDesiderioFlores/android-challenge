package ar.com.mercadolibre.data.cloudentity.mapper

import ar.com.mercadolibre.data.cloudentity.model.ResultsEntity
import ar.com.mercadolibre.domain.model.Results
import javax.inject.Inject

/**
 * Created by Pablo Flores on 30/09/19.
 */
class ResultsMapper @Inject constructor(
    private val sellerCloudDataMapper: SellerCloudDataMapper,
    private val installmentsCloudDataMapper: InstallmentsCloudDataMapper,
    private val addressCloudDataMapper: AddressCloudDataMapper,
    private val shippingCloudDataMapper: ShippingCloudDataMapper,
    private val sellerAddressCloudDataMapper: SellerAddressCloudDataMapper,
    private val attributesCloudDataMapper: AttributesCloudDataMapper,
    private val differentialPricingCloudDataMapper: DifferentialPricingCloudDataMapper
) {
    fun asDomainModel(resultsEntity: List<ResultsEntity>): List<Results> {
        return resultsEntity.map {
            Results(
                id = it.id,
                site_id = it.site_id,
                title = it.title,
                seller = sellerCloudDataMapper.asDomainModel(it.seller),
                price = it.price,
                currency_id = it.currency_id,
                available_quantity = it.available_quantity,
                sold_quantity = it.sold_quantity,
                buying_mode = it.buying_mode,
                listing_type_id = it.listing_type_id,
                stop_time = it.stop_time,
                condition = it.condition,
                permalink = it.permalink,
                thumbnail = it.thumbnail,
                accepts_mercadopago = it.accepts_mercadopago,
                installments = installmentsCloudDataMapper.asDomainModel(it.installmentsEntity),
                address = addressCloudDataMapper.asDomainModel(it.addressEntity),
                shipping = shippingCloudDataMapper.asDomainModel(it.shippingEntity),
                seller_address = sellerAddressCloudDataMapper.asDomainModel(it.seller_addressEntity),
                attributes = attributesCloudDataMapper.asDomainModel(it.attributes),
                differential_pricing = differentialPricingCloudDataMapper.asDomainModel(it.differential_pricingEntity),
                original_price = it.original_price,
                category_id = it.category_id,
                official_store_id = it.official_store_id,
                catalog_product_id = it.catalog_product_id,
                tags = it.tags,
                catalog_listing = it.catalog_listing
            )
        }
    }
}