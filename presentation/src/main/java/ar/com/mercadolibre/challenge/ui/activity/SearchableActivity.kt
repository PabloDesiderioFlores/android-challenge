package ar.com.mercadolibre.challenge.ui.activity

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.provider.SearchRecentSuggestions
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.com.mercadolibre.challenge.R
import ar.com.mercadolibre.challenge.ui.adapter.SearchProductsAdapter
import ar.com.mercadolibre.challenge.ui.fragment.ProductDetailFragment
import ar.com.mercadolibre.challenge.ui.model.ProductUi
import ar.com.mercadolibre.challenge.ui.provider.SearchContentProvider
import ar.com.mercadolibre.challenge.ui.viewmodel.SearchViewModel
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject

class SearchableActivity : DaggerAppCompatActivity() {

    private val BACK_STACK_ROOT_TAG = "back_stack_root"
    private var RECYCLER_VISIBILITY = "recycler_visibility"
    private var recyclerVisibility: Int? = -1
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: SearchViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(SearchViewModel::class.java)
    }

    private lateinit var productRecyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private var viewModelAdapter: SearchProductsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                SearchRecentSuggestions(
                    this,
                    SearchContentProvider.AUTHORITY,
                    SearchContentProvider.MODE
                )
                    .saveRecentQuery(query, null)
                search(query)
            }
        }
        viewModelAdapter = SearchProductsAdapter(ProductCallback {
            productRecyclerView.visibility = View.GONE
            goToProductDetail(ProductDetailFragment.newInstance(it))
        })
        productRecyclerView = findViewById<RecyclerView>(R.id.products_recycler_view).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = viewModelAdapter
        }

        if (savedInstanceState != null) {
            productRecyclerView.visibility = savedInstanceState.getInt(RECYCLER_VISIBILITY)
        }

        progressBar = findViewById(R.id.loading_spinner)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        recyclerVisibility = productRecyclerView.visibility
        outState.putInt(RECYCLER_VISIBILITY, recyclerVisibility!!)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        productRecyclerView.visibility = View.VISIBLE
    }

    private fun goToProductDetail(fragment: Fragment) {
        val fm = supportFragmentManager
        fm.beginTransaction()
            .replace(
                R.id.fragment_container,
                fragment,
                ProductDetailFragment.TAG
            )
            .addToBackStack(BACK_STACK_ROOT_TAG)
            .commit()
    }

    private fun search(query: String) {
        viewModel.setKeyWord(query)
        with(viewModel) {
            productUi.observe(this@SearchableActivity, Observer { products ->
                progressBar.visibility = View.GONE
                viewModelAdapter?.productUiList = products
            }
            )
            error.observe(this@SearchableActivity, Observer {
                progressBar.visibility = View.GONE
                Timber.e(String.format("SearchableActivity %s ", it?.message))
                Toast.makeText(applicationContext, "${it?.message}", Toast.LENGTH_LONG).show()
            })
        }
    }
}

/**
 * Click listener for products.
 * The listener is here and not in the adapter
 * for the databinding.
 */
class ProductCallback(val block: (ProductUi) -> Unit) {
    /**
     * Called when a video is clicked
     *
     * @param video the video that was clicked
     */
    fun onClick(video: ProductUi) = block(video)
}
