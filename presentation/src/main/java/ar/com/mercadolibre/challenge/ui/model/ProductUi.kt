package ar.com.mercadolibre.challenge.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Pablo Flores on 30/09/19.
 */
@Parcelize
data class ProductUi(
    val title: String?,
    val seller: SellerUi?,
    val price: Float?,
    val available_quantity: Int?,
    val sold_quantity: Int?,
    val buying_mode: String?,
    val thumbnail: String?,
    val accepts_mercadopago: Boolean?
) : Parcelable