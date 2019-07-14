package com.chebdowski.data.cards.entity.mapper

import com.chebdowski.data.cards.entity.CardEntity
import com.chebdowski.domain.cards.model.Card

class CardEntityMapper {

    fun transform(cardEntity: CardEntity): Card {
        return Card(cardEntity.name)
    }
}
