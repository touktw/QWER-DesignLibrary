package club.qwer.library.base.extension

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

fun ComponentActivity.startActivityForResult(resultCallback: ActivityResultCallback<ActivityResult>) =
    registerForActivityResult(ActivityResultContracts.StartActivityForResult(), resultCallback)

fun ComponentActivity.requestPermission(resultCallback: ActivityResultCallback<Boolean>) =
    registerForActivityResult(ActivityResultContracts.RequestPermission(), resultCallback)

fun ComponentActivity.createRequest(requestCode: Int, resultCallback: (Int, Intent?) -> Unit) =
    activityResultRegistry.register("", this, ActivityResultContracts.StartActivityForResult()) {

    }

fun AppCompatActivity.tttI() {
}

fun <I> ActivityResultLauncher<I>.launch(data: I, requestCode: Int) {
    launch(data)
}