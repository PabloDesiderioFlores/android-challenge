package ar.com.mercadolibre.data.cloudentity.model

data class AttributesEntity(

    val id: String,
    val name: String,
    val value_id: Int,
    val value_name: String,
    val attribute_group_id: String,
    val attribute_group_name: String,
    val source: Double
)