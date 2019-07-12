package com.chebdowski.cardemulator

import androidx.multidex.MultiDexApplication
import com.chebdowski.cardemulator.di.components.ApplicationComponent
import com.chebdowski.cardemulator.di.components.DaggerApplicationComponent
import com.chebdowski.cardemulator.di.modules.ApplicationModule

class AndroidApplication : MultiDexApplication() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        initializeInjector()
    }

    private fun initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule())
            .build()
        applicationComponent.inject(this)
    }
}
