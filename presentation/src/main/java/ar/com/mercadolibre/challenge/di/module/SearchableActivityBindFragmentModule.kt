package ar.com.mercadolibre.challenge.di.module

import ar.com.mercadolibre.challenge.di.PerFragment
import ar.com.mercadolibre.challenge.ui.fragment.ProductDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Pablo Flores on 01/10/19.
 */
@Module
abstract class SearchableActivityBindFragmentModule {
    @ContributesAndroidInjector(modules = [ProductDetailFragmentModule::class])
    @PerFragment
    abstract fun productDetailFragment(): ProductDetailFragment
}