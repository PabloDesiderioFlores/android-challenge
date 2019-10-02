package ar.com.mercadolibre.data.cloudentity.mapper

import ar.com.mercadolibre.data.cloudentity.model.CategoryEntity
import ar.com.mercadolibre.domain.model.Category

/**
 * Created by Pablo Flores on 28/09/19.
 */

class CategoryCloudDataMapper {
    fun asDomainModel(categories: List<CategoryEntity>): List<Category> {
        return categories.map {
            Category(id = it.id, name = it.name)
        }
    }
}