package ir.reza_mahmoudi.footballfixtures.di

import dagger.Component
import ir.reza_mahmoudi.footballfixtures.data.remote.FixturesService
import ir.reza_mahmoudi.footballfixtures.view.home.HomeViewModel

@Component(modules=[ApiModule::class])
interface ApiComponent {
    fun inject(service: FixturesService)
    fun inject(viewModel: HomeViewModel)
}