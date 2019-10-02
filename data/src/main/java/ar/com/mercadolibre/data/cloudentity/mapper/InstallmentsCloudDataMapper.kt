package ar.com.mercadolibre.data.cloudentity.mapper

import ar.com.mercadolibre.data.cloudentity.model.InstallmentsEntity
import ar.com.mercadolibre.domain.model.Installments

/**
 * Created by Pablo Flores on 30/09/19.
 */
class InstallmentsCloudDataMapper {
    fun asDomainModel(installmentsEntity: InstallmentsEntity?): Installments {
        return Installments(
            quantity = installmentsEntity?.quantity,
            amount = installmentsEntity?.amount,
            rate = installmentsEntity?.rate,
            currency_id = installmentsEntity?.currency_id
        )
    }
}