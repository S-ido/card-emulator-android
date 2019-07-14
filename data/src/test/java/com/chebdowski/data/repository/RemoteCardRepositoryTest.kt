package com.chebdowski.data.repository

import com.chebdowski.data.cards.api.CardApi
import com.chebdowski.data.cards.entity.mapper.CardEntityMapper
import com.chebdowski.domain.cards.model.Card
import com.chebdowski.domain.cards.repository.CardsRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RemoteCardRepositoryTest {

    private val cardApi = mock<CardApi> {
        on { getCards() } doReturn Single.just(getCardsList())
    }

    private lateinit var remoteCardRepository: CardsRepository

    @Before
    fun setUp() {
        remoteCardRepository = RemoteCardRepository(cardApi, CardEntityMapper())
    }

    @Test
    fun getCards() {
        val testObserver = TestObserver<List<Card>>()

        remoteCardRepository.getCards().subscribe(testObserver)

        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        val cards = testObserver.values()[0]
        assertEquals(cards.size, 2)
        assertEquals(cards[0].name, getCardsList()[0].name)
        assertEquals(cards[1].name, getCardsList()[1].name)

        verify(cardApi).getCards()
    }

    private fun getCardsList(): List<Card> = mutableListOf(Card("first"), Card("second"))
}