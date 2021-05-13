package club.qwer.library.base.extension

import android.view.View
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@ExperimentalCoroutinesApi
fun View.onClick(duration: Long = 1000L, action: suspend (View) -> Unit) {
    callbackFlow {
        setOnClickListener { offer(Unit) }
        awaitClose { setOnClickListener(null) }
    }
        .throttleFirst(duration)
        .onEach { action.invoke(this) }
        .launchIn(CoroutineScope(Dispatchers.Main))
}