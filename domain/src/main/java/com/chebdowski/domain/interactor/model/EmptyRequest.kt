package com.chebdowski.domain.interactor.model

import java.io.Serializable

class EmptyRequest : Serializable {

    fun create(): EmptyRequest {
        return EmptyRequest()
    }

    override fun hashCode() = 0

    override fun equals(other: Any?): Boolean {
        return if (other is EmptyRequest) true else super.equals(other)
    }
}
