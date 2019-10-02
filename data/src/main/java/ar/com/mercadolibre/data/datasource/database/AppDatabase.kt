package ar.com.mercadolibre.data.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ar.com.mercadolibre.data.databaseentity.model.CategoryDatabaseEntity

/**
 * Created by Pablo Flores on 26/09/19.
 */
@Database(entities = [CategoryDatabaseEntity::class], version = AppDatabase.VERSION)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "meli.db"
        const val VERSION = 1
    }

    abstract fun categoryDAO(): CategoryDao
}