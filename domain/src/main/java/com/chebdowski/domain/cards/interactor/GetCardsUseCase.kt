package com.chebdowski.domain.cards.interactor

import com.chebdowski.domain.cards.model.Card
import com.chebdowski.domain.cards.repository.CardsRepository
import com.chebdowski.domain.interactor.base.SingleUseCase
import com.chebdowski.domain.interactor.model.EmptyRequest
import com.chebdowski.domain.scheduler.ComposedScheduler
import io.reactivex.Single

class GetCardsUseCase(
    composedScheduler: ComposedScheduler,
    private val cardsRepository: CardsRepository
) : SingleUseCase<EmptyRequest, List<Card>>(composedScheduler) {

    override fun createUseCase(param: EmptyRequest?): Single<List<Card>> {
        return cardsRepository.getCards()
    }
}
