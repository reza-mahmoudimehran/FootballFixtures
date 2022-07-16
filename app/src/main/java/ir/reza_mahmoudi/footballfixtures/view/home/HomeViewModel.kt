package ir.reza_mahmoudi.footballfixtures.view.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import ir.reza_mahmoudi.footballfixtures.data.remote.FixturesService
import ir.reza_mahmoudi.footballfixtures.di.DaggerApiComponent
import ir.reza_mahmoudi.footballfixtures.model.Fixtures
import javax.inject.Inject

class HomeViewModel : ViewModel() {
    @Inject
    lateinit var fixturesService: FixturesService

    init{
        DaggerApiComponent.create().inject(this)
    }
    private val disposable = CompositeDisposable()

    val fixtures = MutableLiveData<Fixtures>()
    val fixturesLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh(){
        fetchCountries()
    }

    private fun fetchCountries(){
        loading.value = true
        disposable.add(
            fixturesService.getFixtures()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<Fixtures>(), Disposable {
                    override fun onSuccess(value: Fixtures?) {
                        fixtures.value = value
                        fixturesLoadError.value = false
                        loading.value = false
                    }
                    override fun onError(e: Throwable?) {
                        Log.e("getFixtures: ",e.toString())
                        fixturesLoadError.value = true
                        loading.value = false
                    }
                })
        )
    }
}