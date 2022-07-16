package ir.reza_mahmoudi.footballfixtures.di

import dagger.Module
import dagger.Provides
import ir.reza_mahmoudi.footballfixtures.data.remote.FixturesApi
import ir.reza_mahmoudi.footballfixtures.data.remote.FixturesService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {
    private val Base_Url="https://run.mocky.io"

    @Provides
    fun provideCountriesApi(): FixturesApi {
        return Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(FixturesApi::class.java)
    }
    @Provides
    fun provideCountriesService(): FixturesService {
        return FixturesService()
    }
}