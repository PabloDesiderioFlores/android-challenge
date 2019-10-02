package ar.com.mercadolibre.domain.model

/**
 * Created by Pablo Flores on 26/09/19.
 */
data class Attributes(
    val id: String?,
    val name: String?,
    val value_id: Int?,
    val value_name: String?,
    val attribute_group_id: String?,
    val attribute_group_name: String?,
    val source: Double?
)