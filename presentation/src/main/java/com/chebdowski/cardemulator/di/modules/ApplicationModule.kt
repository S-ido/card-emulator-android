package com.chebdowski.cardemulator.di.modules

import com.chebdowski.data.cards.api.MockedCardApi
import com.chebdowski.data.cards.entity.mapper.CardEntityMapper
import com.chebdowski.data.repository.RemoteCardRepository
import com.chebdowski.data.scheduler.AndroidComposedScheduler
import com.chebdowski.domain.cards.repository.CardsRepository
import com.chebdowski.domain.scheduler.ComposedScheduler
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideCardRepository(): CardsRepository {
        return RemoteCardRepository(MockedCardApi(), CardEntityMapper())
    }

    @Provides
    fun provideComposedScheduler(): ComposedScheduler {
        return AndroidComposedScheduler()
    }
}
