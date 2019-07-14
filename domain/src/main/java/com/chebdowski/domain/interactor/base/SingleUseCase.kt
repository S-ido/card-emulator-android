package com.chebdowski.domain.interactor.base

import com.chebdowski.domain.scheduler.ComposedScheduler
import io.reactivex.Single

abstract class SingleUseCase<Request, Response>(private val composedScheduler: ComposedScheduler) {

    var single: Single<Response>? = null

    val isExecuting = single != null

    protected abstract fun createUseCase(param: Request?): Single<Response>

    fun execute(param: Request?): Single<Response> {
        if (single == null) {
            single = createUseCase(param)
            single = single!!.compose(composedScheduler.applySingleScheduling())

            single = single!!.cache()
                .doFinally { single = null }
        }

        return single!!
    }

    fun execute() = execute(null)
}
