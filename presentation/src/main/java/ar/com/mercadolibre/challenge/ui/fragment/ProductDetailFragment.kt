package ar.com.mercadolibre.challenge.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import ar.com.mercadolibre.challenge.R
import ar.com.mercadolibre.challenge.databinding.FragmentProductDetailBinding
import ar.com.mercadolibre.challenge.ui.model.ProductUi
import dagger.android.support.DaggerFragment

class ProductDetailFragment : DaggerFragment() {

    companion object {
        val TAG = ProductDetailFragment::class.java.simpleName
        private val EXTRA_PRODUCT_UI = "ar.com.mercadolibre.challenge.ui.model.ProductUi"

        fun newInstance(product: ProductUi): ProductDetailFragment {
            val args = Bundle()
            args.putParcelable(EXTRA_PRODUCT_UI, product)
            val fragment = ProductDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentProductDetailBinding>(
            inflater,
            R.layout.fragment_product_detail, container, false
        )
        binding.also {
            it.product = arguments?.getParcelable(EXTRA_PRODUCT_UI)
        }
        return binding.root
    }
}
