package com.chebdowski.data

import com.chebdowski.domain.Card
import io.reactivex.Single

interface CardsRepository {

    fun getCards(): Single<List<Card>>
}
