package com.chebdowski.domain.cards.repository

import com.chebdowski.domain.cards.model.Card
import io.reactivex.Single

interface CardsRepository {

    fun getCards(): Single<List<Card>>
}
