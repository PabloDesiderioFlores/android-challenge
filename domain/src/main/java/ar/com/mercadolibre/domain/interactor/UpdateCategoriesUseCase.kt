package ar.com.mercadolibre.domain.interactor

import ar.com.mercadolibre.domain.repository.CategoryRepository
import ar.com.mercadolibre.domain.usecase.BaseUseCase
import javax.inject.Inject

/**
 * Created by Pablo Flores on 28/09/19.
 */
class UpdateCategoriesUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) : BaseUseCase<Unit>() {
    override suspend fun executeOnBackground() {
        return categoryRepository.refreshCategories()
    }
}