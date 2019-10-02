package ar.com.mercadolibre.domain.interactor

import ar.com.mercadolibre.domain.model.Products
import ar.com.mercadolibre.domain.repository.GetProductsByKeyword
import ar.com.mercadolibre.domain.usecase.BaseUseCase
import javax.inject.Inject

/**
 * Created by Pablo Flores on 30/09/19.
 */
class SearchProducts @Inject constructor(
    private val getProductByKeyWord: GetProductsByKeyword
) : BaseUseCase<Products>() {

    private lateinit var keyWord: String

    override suspend fun executeOnBackground(): Products {
        return getProductByKeyWord.getProductsByKeyword(keyWord)
    }

    fun setKeyWord(keyWord: String) {
        this.keyWord = keyWord
    }
}