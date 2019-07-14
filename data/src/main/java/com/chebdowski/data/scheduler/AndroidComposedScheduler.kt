package com.chebdowski.data.scheduler

import com.chebdowski.domain.scheduler.ComposedScheduler
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AndroidComposedScheduler : ComposedScheduler {

    override fun <T> applySingleScheduling(): SingleTransformer<T, T> {
        return SingleTransformer { upstream ->
            upstream
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }
}
