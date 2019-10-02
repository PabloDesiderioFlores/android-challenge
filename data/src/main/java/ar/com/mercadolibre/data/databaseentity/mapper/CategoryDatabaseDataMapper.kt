package ar.com.mercadolibre.data.databaseentity.mapper

import ar.com.mercadolibre.data.databaseentity.model.CategoryDatabaseEntity
import ar.com.mercadolibre.domain.model.Category

/**
 * Created by Pablo Flores on 28/09/19.
 */
class CategoryDatabaseDataMapper {
    fun asDomainModel(categories: List<CategoryDatabaseEntity>): List<Category> {
        return categories.map {
            Category(id = it.id, name = it.name)
        }
    }

    fun asDatabaseModel(categories: List<Category>): Array<CategoryDatabaseEntity> {
        return categories.map {
            CategoryDatabaseEntity(id = it.id, name = it.name)
        }.toTypedArray()
    }
}