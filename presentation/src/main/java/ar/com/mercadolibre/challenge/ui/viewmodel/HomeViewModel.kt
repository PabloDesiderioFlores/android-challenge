package ar.com.mercadolibre.challenge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.com.mercadolibre.data.exception.ErrorHandler
import ar.com.mercadolibre.data.exception.response.ErrorModel
import ar.com.mercadolibre.domain.interactor.GetCategoriesUseCase
import ar.com.mercadolibre.domain.interactor.UpdateCategoriesUseCase
import ar.com.mercadolibre.domain.model.Category
import javax.inject.Inject

/**
 * Created by Pablo Flores on 29/09/19.
 */
class HomeViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val updateCategoriesUseCase: UpdateCategoriesUseCase,
    private val errorUtil: ErrorHandler
) : ViewModel() {
    val categories: MutableLiveData<List<Category>> by lazy { MutableLiveData<List<Category>>() }
    val error: MutableLiveData<ErrorModel> by lazy { MutableLiveData<ErrorModel>() }

    init {
        updateCategoriesUseCase.execute {
            onComplete {
                getCategories()
            }
            onError { throwable ->
                val errorModel = errorUtil.handleError(throwable)
                error.value = errorModel
                getCategories()
            }
        }
    }

    private fun getCategories() {
        getCategoriesUseCase.execute {
            onComplete {
                categories.value = it
            }
            onError { throwable ->
                val errorModel = errorUtil.handleError(throwable)
                error.value = errorModel
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        getCategoriesUseCase.unsubscribe()
        updateCategoriesUseCase.unsubscribe()
    }
}