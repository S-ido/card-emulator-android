package com.chebdowski.data.cards.api

import com.chebdowski.domain.cards.model.Card
import io.reactivex.Single

class MockedCardApi: CardApi {

    override fun getCards(): Single<List<Card>> {
        val cards = mutableListOf(
            Card("First"),
            Card("Second")
        )
        return Single.just(cards)
    }
}
