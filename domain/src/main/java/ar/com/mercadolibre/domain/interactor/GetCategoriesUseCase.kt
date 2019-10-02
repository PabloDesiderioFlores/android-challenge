package ar.com.mercadolibre.domain.interactor

import ar.com.mercadolibre.domain.model.Category
import ar.com.mercadolibre.domain.repository.CategoryRepository
import ar.com.mercadolibre.domain.usecase.BaseUseCase
import javax.inject.Inject

/**
 * Created by Pablo Flores on 28/09/19.
 */
class GetCategoriesUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) : BaseUseCase<List<Category>>() {
    override suspend fun executeOnBackground(): List<Category> {
        return categoryRepository.getCategories()
    }
}