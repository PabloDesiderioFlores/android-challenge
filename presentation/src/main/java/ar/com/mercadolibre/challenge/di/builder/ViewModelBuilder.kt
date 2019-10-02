package ar.com.mercadolibre.challenge.di.builder

import androidx.lifecycle.ViewModelProvider
import ar.com.mercadolibre.challenge.ui.viewmodel.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * Created by Pablo Flores on 29/09/19.
 */
@Module(includes = [AppViewModelBuilder::class])
abstract class ViewModelBuilder {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}