package com.chebdowski.cardemulator.di.modules

import com.chebdowski.data.cards.api.MockedCardApi
import com.chebdowski.data.cards.entity.mapper.CardEntityMapper
import com.chebdowski.data.repository.RemoteCardRepository
import com.chebdowski.domain.cards.repository.CardsRepository
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
}
