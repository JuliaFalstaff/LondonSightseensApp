package com.example.londonsightseensapp.di

import com.example.londonsightseensapp.presenter.MainPresenter
import com.example.londonsightseensapp.presenter.PlaceInfoPresenter
import com.example.londonsightseensapp.presenter.PlacesPresenter
import com.example.londonsightseensapp.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AppModule::class,
            ApiModule::class,
            CacheModule::class,
            CiceroneModule::class,
            PlacesModule::class,
            PlacesInfoModule::class
        ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(usersPresenter: PlacesPresenter)
    fun inject(repositoryPresenter: PlaceInfoPresenter)
}