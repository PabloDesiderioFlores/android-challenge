package ar.com.mercadolibre.challenge.di.module

import ar.com.mercadolibre.challenge.di.PerFragment
import ar.com.mercadolibre.challenge.ui.fragment.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Pablo Flores on 29/09/19.
 */
@Module
abstract class MainActivityBindFragmentModule {
    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    @PerFragment
    abstract fun homeFragment(): HomeFragment
}