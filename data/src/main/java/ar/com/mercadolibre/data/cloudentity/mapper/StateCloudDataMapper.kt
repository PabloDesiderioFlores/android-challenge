package ar.com.mercadolibre.data.cloudentity.mapper

import ar.com.mercadolibre.data.cloudentity.model.StateEntity
import ar.com.mercadolibre.domain.model.State

/**
 * Created by Pablo Flores on 30/09/19.
 */
class StateCloudDataMapper {
    fun asDomainModel(stateEntity: StateEntity?): State {
        return State(
            id = stateEntity?.id,
            name = stateEntity?.name
        )
    }
}