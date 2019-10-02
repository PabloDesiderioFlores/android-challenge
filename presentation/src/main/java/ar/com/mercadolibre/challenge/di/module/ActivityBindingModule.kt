package ar.com.mercadolibre.challenge.di.module

import ar.com.mercadolibre.challenge.di.PerActivity
import ar.com.mercadolibre.challenge.ui.activity.MainActivity
import ar.com.mercadolibre.challenge.ui.activity.SearchableActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Pablo Flores on 28/09/19.
 */
@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [MainActivityBindFragmentModule::class])
    @PerActivity
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [SearchableActivityBindFragmentModule::class])
    @PerActivity
    abstract fun searChableActivity(): SearchableActivity
}