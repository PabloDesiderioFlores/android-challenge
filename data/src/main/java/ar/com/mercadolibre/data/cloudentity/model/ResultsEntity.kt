package ar.com.mercadolibre.data.cloudentity.model

data class ResultsEntity(

    val id: String?,
    val site_id: String?,
    val title: String?,
    val seller: SellerEntity?,
    val price: Float?,
    val currency_id: String?,
    val available_quantity: Int?,
    val sold_quantity: Int?,
    val buying_mode: String?,
    val listing_type_id: String?,
    val stop_time: String?,
    val condition: String?,
    val permalink: String?,
    val thumbnail: String?,
    val accepts_mercadopago: Boolean?,
    val installmentsEntity: InstallmentsEntity?,
    val addressEntity: AddressEntity?,
    val shippingEntity: ShippingEntity?,
    val seller_addressEntity: SellerAddressEntity?,
    val attributes: List<AttributesEntity>?,
    val differential_pricingEntity: DifferentialPricingEntity?,
    val original_price: Float?,
    val category_id: String?,
    val official_store_id: String,
    val catalog_product_id: String?,
    val tags: List<String>?,
    val catalog_listing: Boolean?
)