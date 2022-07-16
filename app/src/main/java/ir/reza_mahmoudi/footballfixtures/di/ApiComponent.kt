package ir.reza_mahmoudi.footballfixtures.di

import dagger.Component
import ir.reza_mahmoudi.footballfixtures.data.remote.FixturesService

@Component(modules=[ApiModule::class])
interface ApiComponent {
    fun inject(service: FixturesService)
}