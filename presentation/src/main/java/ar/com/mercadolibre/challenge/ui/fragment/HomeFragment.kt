package ar.com.mercadolibre.challenge.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.com.mercadolibre.challenge.R
import ar.com.mercadolibre.challenge.databinding.FragmentHomeBinding
import ar.com.mercadolibre.challenge.ui.adapter.CategoryAdapter
import ar.com.mercadolibre.challenge.ui.viewmodel.HomeViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_home.view.*
import timber.log.Timber
import javax.inject.Inject

class HomeFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
    }

    private var viewModelAdapter: CategoryAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home, container, false
        )

        viewModelAdapter = CategoryAdapter()

        binding.root.findViewById<RecyclerView>(R.id.category_recycler_view).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = viewModelAdapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewModel) {
            categories.observe(this@HomeFragment, Observer { categories ->
                viewModelAdapter?.categories = categories
                view.loading_spinner.visibility = View.GONE
            }
            )
            error.observe(this@HomeFragment, Observer {
                view.loading_spinner.visibility = View.GONE
                Timber.e(String.format("HomeFragment %s ", it?.message))
                Toast.makeText(context, "${it?.message}", Toast.LENGTH_LONG).show()
            })
        }
    }
}
