package ar.com.mercadolibre.challenge.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Pablo Flores on 01/10/19.
 */
@Parcelize
data class SellerUi(
    val power_seller_status: String?,
    val car_dealer: Boolean?,
    val real_estate_agency: Boolean?,
    val tags: List<String>?
) : Parcelable