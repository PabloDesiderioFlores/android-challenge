package ar.com.mercadolibre.challenge.di.module

import android.app.Application
import androidx.room.Room
import ar.com.mercadolibre.challenge.ui.model.mapper.ProductsUiMapper
import ar.com.mercadolibre.challenge.ui.model.mapper.SellerUiMapper
import ar.com.mercadolibre.data.Config
import ar.com.mercadolibre.data.cloudentity.mapper.*
import ar.com.mercadolibre.data.databaseentity.mapper.CategoryDatabaseDataMapper
import ar.com.mercadolibre.data.datasource.cloud.CategoryCloudDataStore
import ar.com.mercadolibre.data.datasource.cloud.CategoryDataStore
import ar.com.mercadolibre.data.datasource.cloud.GetProductsByKeyWordCloudDataStore
import ar.com.mercadolibre.data.datasource.cloud.GetProductsByKeyWordDataStore
import ar.com.mercadolibre.data.datasource.database.AppDatabase
import ar.com.mercadolibre.data.datasource.database.CategoryDao
import ar.com.mercadolibre.data.exception.ErrorHandler
import ar.com.mercadolibre.data.network.CategoryRestAPI
import ar.com.mercadolibre.data.network.CategoryRestApiImpl
import ar.com.mercadolibre.data.network.ProductsByKeyWordRestAPI
import ar.com.mercadolibre.data.network.ProductsByKeyWordRestAPIImpl
import ar.com.mercadolibre.data.network.retrofit.CategoryAPI
import ar.com.mercadolibre.data.network.retrofit.ProductsByKwyWordAPI
import ar.com.mercadolibre.data.repository.CategoryRepositoryImpl
import ar.com.mercadolibre.data.repository.GetProductsByKeywordImpl
import ar.com.mercadolibre.domain.repository.CategoryRepository
import ar.com.mercadolibre.domain.repository.GetProductsByKeyword
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Pablo Flores on 28/09/19.
 */
@Module(includes = [AndroidInjectionModule::class])
class ApplicationModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, AppDatabase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            //  .cache(cache)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        client.addNetworkInterceptor(interceptor)
        return client.build()
    }


    @Provides
    @Singleton
    fun providesGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    //region rest api
    @Provides
    @Singleton
    fun providesCategoryAPI(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): CategoryAPI {
        val retrofit = Retrofit.Builder().baseUrl(Config.HOST)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()
        return retrofit.create(CategoryAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesProductsByKeyWordAPI(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): ProductsByKwyWordAPI {
        val retrofit = Retrofit.Builder().baseUrl(Config.HOST)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()
        return retrofit.create(ProductsByKwyWordAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCategoryRestApi(categoryRestApiImpl: CategoryRestApiImpl): CategoryRestAPI {
        return categoryRestApiImpl
    }

    @Provides
    @Singleton
    fun provideProductsByKeyWordRestApi(productsByKeyWordRestAPIImpl: ProductsByKeyWordRestAPIImpl)
            : ProductsByKeyWordRestAPI {
        return productsByKeyWordRestAPIImpl
    }

    //region DAO
    @Provides
    fun providesCategoryDAO(appDataBase: AppDatabase): CategoryDao {
        return appDataBase.categoryDAO()
    }

    //region repository
    @Provides
    @Singleton
    fun provideCategoryRepository(categoryRepositoryImpl: CategoryRepositoryImpl): CategoryRepository {
        return categoryRepositoryImpl
    }

    @Provides
    @Singleton
    fun provideProductsByKeyWordRepository(getProductsByKeywordImpl: GetProductsByKeywordImpl): GetProductsByKeyword {
        return getProductsByKeywordImpl
    }

    //region data store
    @Provides
    @Singleton
    fun providesCategoryDataStore(categoryRestAPI: CategoryRestAPI): CategoryDataStore {
        return CategoryCloudDataStore(categoryRestAPI)
    }

    @Provides
    @Singleton
    fun providesProductsByKeyWordDataStore(productsByKeyWordRestAPI: ProductsByKeyWordRestAPI): GetProductsByKeyWordDataStore {
        return GetProductsByKeyWordCloudDataStore(productsByKeyWordRestAPI)
    }

    //region mapper
    @Provides
    @Singleton
    fun providesCategoryCloudDataMapper(): CategoryCloudDataMapper {
        return CategoryCloudDataMapper()
    }

    @Provides
    @Singleton
    fun providesCategoryDatabaseMapper(): CategoryDatabaseDataMapper {
        return CategoryDatabaseDataMapper()
    }

    @Provides
    @Singleton
    fun providesAddressCloudDataMapper(): AddressCloudDataMapper {
        return AddressCloudDataMapper()
    }

    @Provides
    @Singleton
    fun providesAttributesCloudDataMapper(): AttributesCloudDataMapper {
        return AttributesCloudDataMapper()
    }

    @Provides
    @Singleton
    fun providesCityCloudDataMapper(): CityCloudDataMapper {
        return CityCloudDataMapper()
    }

    @Provides
    @Singleton
    fun providesCountryCloudDataMapper(): CountryCloudDataMapper {
        return CountryCloudDataMapper()
    }

    @Provides
    @Singleton
    fun providesDifferentialPricingCloudDataMapper(): DifferentialPricingCloudDataMapper {
        return DifferentialPricingCloudDataMapper()
    }

    @Provides
    @Singleton
    fun providesInstallmentsCloudDataMapper(): InstallmentsCloudDataMapper {
        return InstallmentsCloudDataMapper()
    }

    @Provides
    @Singleton
    fun providesSellerCloudDataMapper(): SellerCloudDataMapper {
        return SellerCloudDataMapper()
    }

    @Provides
    @Singleton
    fun providesShippingCloudDataMapper(): ShippingCloudDataMapper {
        return ShippingCloudDataMapper()
    }

    @Provides
    @Singleton
    fun providesStateCloudDataMapper(): StateCloudDataMapper {
        return StateCloudDataMapper()
    }

    @Provides
    @Singleton
    fun providesProductCloudDataMapper(
        pagingMapper: PagingCloudMapper,
        resultsMapper: ResultsMapper
    ): ProductCloudDataMapper {
        return ProductCloudDataMapper(
            pagingMapper, resultsMapper
        )
    }

    @Provides
    @Singleton
    fun providesSellerAddressCloudDataMapper(
        countryCloudDataMapper: CountryCloudDataMapper,
        stateCloudDataMapper: StateCloudDataMapper,
        cityCloudDataMapper: CityCloudDataMapper
    ): SellerAddressCloudDataMapper {
        return SellerAddressCloudDataMapper(
            countryCloudDataMapper, stateCloudDataMapper,
            cityCloudDataMapper
        )
    }

    @Provides
    @Singleton
    fun providesSellerUiMapper(): SellerUiMapper {
        return SellerUiMapper()
    }

    @Provides
    @Singleton
    fun providesProductsUiMapper(sellerUiMapper: SellerUiMapper): ProductsUiMapper {
        return ProductsUiMapper(sellerUiMapper)
    }

    @Provides
    @Singleton
    fun providesPagingDataMapper(): PagingCloudMapper {
        return PagingCloudMapper()
    }

    @Provides
    @Singleton
    fun providesResultsMapper(
        sellerCloudDataMapper: SellerCloudDataMapper,
        installmentsCloudDataMapper: InstallmentsCloudDataMapper,
        addressCloudDataMapper: AddressCloudDataMapper,
        shippingCloudDataMapper: ShippingCloudDataMapper,
        sellerAddressCloudDataMapper: SellerAddressCloudDataMapper,
        attributesCloudDataMapper: AttributesCloudDataMapper,
        differentialPricingCloudDataMapper: DifferentialPricingCloudDataMapper
    ): ResultsMapper {
        return ResultsMapper(
            sellerCloudDataMapper,
            installmentsCloudDataMapper,
            addressCloudDataMapper,
            shippingCloudDataMapper,
            sellerAddressCloudDataMapper,
            attributesCloudDataMapper,
            differentialPricingCloudDataMapper
        )
    }

    @Provides
    @Singleton
    fun provideErrorCloudHandler(): ErrorHandler {
        return ErrorHandler()
    }
}
