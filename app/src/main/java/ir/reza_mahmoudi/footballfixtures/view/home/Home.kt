package ir.reza_mahmoudi.footballfixtures.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import ir.reza_mahmoudi.footballfixtures.databinding.ActivityHomeBinding
import ir.reza_mahmoudi.footballfixtures.model.Fixtures
import ir.reza_mahmoudi.footballfixtures.util.refactorDate

class Home : AppCompatActivity() {
    lateinit var viewModel: HomeViewModel
    private lateinit var binding: ActivityHomeBinding
    private val fixturesAdapter=FixturesListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel= ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.refresh()
        binding.rcvHomeFixtures.apply {
            layoutManager= LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false)
            adapter=fixturesAdapter
        }
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
                fixturesAdapter.updateFixtures(it.leagues)
                binding.txtHomeDate.text = it.date?.refactorDate()
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