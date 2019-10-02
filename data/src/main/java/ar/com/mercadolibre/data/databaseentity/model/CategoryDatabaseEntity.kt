package ar.com.mercadolibre.data.databaseentity.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import ar.com.mercadolibre.data.datasource.database.dbtables.Table
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Pablo Flores on 28/09/19.
 */
@Entity
@Parcelize
data class CategoryDatabaseEntity(
    @PrimaryKey
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String
) : Parcelable