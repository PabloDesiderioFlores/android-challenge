package ar.com.mercadolibre.challenge.di.builder

import androidx.lifecycle.ViewModel
import ar.com.mercadolibre.challenge.di.qualifier.ViewModelKey
import ar.com.mercadolibre.challenge.ui.viewmodel.HomeViewModel
import ar.com.mercadolibre.challenge.ui.viewmodel.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Pablo Flores on 29/09/19.
 */
@Module
abstract class AppViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(searchViewModel: SearchViewModel): ViewModel
}