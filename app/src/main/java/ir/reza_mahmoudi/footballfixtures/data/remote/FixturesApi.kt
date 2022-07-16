package ir.reza_mahmoudi.footballfixtures.data.remote

import io.reactivex.Single
import ir.reza_mahmoudi.footballfixtures.model.Fixtures
import retrofit2.http.GET

interface FixturesApi {
    @GET("v3/7e435a1a-86bb-43b8-ba48-678f5e7fd946")
    fun getFixtures(): Single<Fixtures>
}