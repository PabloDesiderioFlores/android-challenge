package ar.com.mercadolibre.data.datasource.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ar.com.mercadolibre.data.databaseentity.model.CategoryDatabaseEntity

/**
 * Created by Pablo Flores on 26/09/19.
 */
@Dao
interface CategoryDao {

    @Query("select * from CategoryDatabaseEntity")
    fun getCategories(): List<CategoryDatabaseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg categories: CategoryDatabaseEntity)
}