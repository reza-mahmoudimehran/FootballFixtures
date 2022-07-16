package ir.reza_mahmoudi.footballfixtures.data.remote

import io.reactivex.Single
import ir.reza_mahmoudi.footballfixtures.model.Fixtures
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class FixturesService {
    private val Base_Url="https://run.mocky.io"
    private val api:FixturesApi

    init{
        api= Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(FixturesApi::class.java)
    }
    fun getFixtures(): Single<Fixtures> {
        return api.getFixtures()
    }
}