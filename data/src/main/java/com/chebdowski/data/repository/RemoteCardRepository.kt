package com.chebdowski.data.repository

import com.chebdowski.data.cards.api.CardApi
import com.chebdowski.data.cards.entity.mapper.CardEntityMapper
import com.chebdowski.domain.cards.model.Card
import com.chebdowski.domain.cards.repository.CardsRepository
import io.reactivex.Single

class RemoteCardRepository(
    val cardApi: CardApi,
    val cardMapper: CardEntityMapper
) : CardsRepository {

    override fun getCards(): Single<List<Card>> {
        return cardApi.getCards()
    }
}
