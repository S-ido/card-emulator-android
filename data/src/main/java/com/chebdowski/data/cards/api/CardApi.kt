package com.chebdowski.data.cards.api

import com.chebdowski.domain.cards.model.Card
import io.reactivex.Single

interface CardApi {

    fun getCards(): Single<List<Card>>
}