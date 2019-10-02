package ar.com.mercadolibre.challenge.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ar.com.mercadolibre.challenge.R
import ar.com.mercadolibre.challenge.databinding.CategoryItemBinding
import ar.com.mercadolibre.domain.model.Category

/**
 * Created by Pablo Flores on 30/09/19.
 */
class CategoryAdapter : RecyclerView.Adapter<CategoryViewHolder>() {

    var categories: List<Category> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val withDataBinding: CategoryItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            CategoryViewHolder.LAYOUT,
            parent,
            false
        )
        return CategoryViewHolder(withDataBinding)
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.category = categories[position]
        }
    }
}

class CategoryViewHolder(val viewDataBinding: CategoryItemBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.category_item
    }
}
