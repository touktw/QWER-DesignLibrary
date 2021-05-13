package club.qwer.library.base.extension

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

fun <T> Flow<T>.throttleFirst(
    duration: Long
): Flow<T> = flow {
    var lastEmissionTime = 0L
    collect { upstream ->
        val currentTime = System.currentTimeMillis()
        val mayEmit = currentTime - lastEmissionTime > duration
        if (mayEmit) {
            lastEmissionTime = currentTime
            emit(upstream)
        }
    }
}