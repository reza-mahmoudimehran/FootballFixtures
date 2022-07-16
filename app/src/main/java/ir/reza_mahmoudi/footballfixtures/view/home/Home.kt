package ir.reza_mahmoudi.footballfixtures.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.*
import ir.reza_mahmoudi.footballfixtures.databinding.ActivityHomeBinding
import ir.reza_mahmoudi.footballfixtures.model.Fixtures

class Home : AppCompatActivity() {
    lateinit var viewModel: HomeViewModel
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel= ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.refresh()
        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing=false
            viewModel.refresh()
        }
        observeViewModel()
    }
    private fun observeViewModel(){
        viewModel.fixtures.observe(this) { fixtures: Fixtures? ->
            fixtures?.let {
                binding.lytFixtures.visibility = View.VISIBLE
            }
        }
        viewModel.fixturesLoadError.observe(this) { isError: Boolean? ->
            isError?.let {
                binding.txtListError.visibility = if (it) View.VISIBLE else View.GONE
            }
        }
        viewModel.loading.observe(this) { isLoading: Boolean? ->
            isLoading?.let {
                binding.prbLoadingView.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    binding.txtListError.visibility = View.GONE
                    binding.lytFixtures.visibility = View.GONE
                }
            }
        }
    }
}