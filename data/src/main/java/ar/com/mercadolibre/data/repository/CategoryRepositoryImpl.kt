package ar.com.mercadolibre.data.repository

import ar.com.mercadolibre.data.databaseentity.mapper.CategoryDatabaseDataMapper
import ar.com.mercadolibre.data.cloudentity.mapper.CategoryCloudDataMapper
import ar.com.mercadolibre.data.datasource.database.CategoryDao
import ar.com.mercadolibre.data.datasource.cloud.CategoryDataStore
import ar.com.mercadolibre.domain.model.Category
import ar.com.mercadolibre.domain.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Pablo Flores on 26/09/19.
 */
class CategoryRepositoryImpl @Inject constructor(
    private val dataStore: CategoryDataStore,
    private val categoryDAO: CategoryDao,
    private val cloudMapper: CategoryCloudDataMapper,
    private val dbMapper: CategoryDatabaseDataMapper
) : CategoryRepository {

    override suspend fun getCategories(): List<Category> {
        return dbMapper.asDomainModel(categoryDAO.getCategories())
    }

    override suspend fun refreshCategories() {
        withContext(Dispatchers.IO) {
            saveCategory(cloudMapper.asDomainModel(dataStore.getCategories()))
        }
    }

    private fun saveCategory(categories: List<Category>) {
        if (categories.isNotEmpty()) {
            val categoriesDatabase = dbMapper.asDatabaseModel(categories)
            categoryDAO.insertAll(*categoriesDatabase)
        }
    }
}