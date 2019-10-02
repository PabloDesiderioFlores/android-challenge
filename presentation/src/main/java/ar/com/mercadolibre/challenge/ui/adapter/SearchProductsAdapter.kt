package ar.com.mercadolibre.challenge.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ar.com.mercadolibre.challenge.R
import ar.com.mercadolibre.challenge.databinding.ProductsItemBinding
import ar.com.mercadolibre.challenge.ui.activity.ProductCallback
import ar.com.mercadolibre.challenge.ui.model.ProductUi

/**
 * Created by Pablo Flores on 01/10/19.
 */
class SearchProductsAdapter(val callback: ProductCallback) :
    RecyclerView.Adapter<ProductsViewHolder>() {
    var productUiList: List<ProductUi> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val withDataBinding: ProductsItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            ProductsViewHolder.LAYOUT,
            parent,
            false
        )
        return ProductsViewHolder(withDataBinding)
    }

    override fun getItemCount() = productUiList.size

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.product = productUiList[position]
            it.productCallback = callback
        }
    }
}

class ProductsViewHolder(val viewDataBinding: ProductsItemBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.products_item
    }
}