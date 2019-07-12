package com.chebdowski.cardemulator.di.components

import com.chebdowski.cardemulator.AndroidApplication
import com.chebdowski.cardemulator.di.modules.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(androidApplication: AndroidApplication)
}
