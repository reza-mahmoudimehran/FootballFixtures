package ir.reza_mahmoudi.footballfixtures.data.remote

import io.reactivex.Single
import ir.reza_mahmoudi.footballfixtures.di.DaggerApiComponent
import ir.reza_mahmoudi.footballfixtures.model.Fixtures
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class FixturesService {
    @Inject
    lateinit var api:FixturesApi

    init{
        DaggerApiComponent.create().inject(this)
    }
    fun getFixtures(): Single<Fixtures> {
        return api.getFixtures()
    }
}