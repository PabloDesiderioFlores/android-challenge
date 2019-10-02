package ar.com.mercadolibre.challenge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.com.mercadolibre.challenge.ui.model.ProductUi
import ar.com.mercadolibre.challenge.ui.model.mapper.ProductsUiMapper
import ar.com.mercadolibre.data.exception.ErrorHandler
import ar.com.mercadolibre.data.exception.response.ErrorModel
import ar.com.mercadolibre.domain.interactor.SearchProducts
import javax.inject.Inject

/**
 * Created by Pablo Flores on 30/09/19.
 */
class SearchViewModel @Inject constructor(
    private val searchProducts: SearchProducts,
    private val mapper: ProductsUiMapper,
    private val errorUtil: ErrorHandler
) : ViewModel() {
    val productUi: MutableLiveData<List<ProductUi>> by lazy { MutableLiveData<List<ProductUi>>() }
    val error: MutableLiveData<ErrorModel> by lazy { MutableLiveData<ErrorModel>() }

    fun setKeyWord(query: String) {
        searchProducts.setKeyWord(query)
        searchProducts.execute {
            onComplete {
                productUi.value = mapper.asUiModel(it.results)
            }
            onError { throwable ->
                val errorModel = errorUtil.handleError(throwable)
                error.value = errorModel
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        searchProducts.unsubscribe()
    }
}