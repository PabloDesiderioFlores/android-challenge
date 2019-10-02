package ar.com.mercadolibre.data.cloudentity.mapper

import ar.com.mercadolibre.data.cloudentity.model.PagingEntity
import ar.com.mercadolibre.domain.model.Paging

/**
 * Created by Pablo Flores on 30/09/19.
 */
class PagingCloudMapper {
    fun asDomainModel(pagingEntity: PagingEntity): Paging {
        return Paging(
            total = pagingEntity.total,
            offset = pagingEntity.offset,
            limit = pagingEntity.limit,
            primary_results = pagingEntity.primary_results
        )
    }
}