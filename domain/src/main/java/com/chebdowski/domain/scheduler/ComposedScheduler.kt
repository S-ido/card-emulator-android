package com.chebdowski.domain.scheduler

import io.reactivex.SingleTransformer

interface ComposedScheduler {

    /**
     * Apply a thread scheduling to a single.
     *
     * @return the newly composed single.
     */
    fun <T> applySingleScheduling(): SingleTransformer<T, T>
}
