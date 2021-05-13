package club.qwer.library.base.extension

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

fun ComponentActivity.startActivityForResult(resultCallback: ActivityResultCallback<ActivityResult>): ActivityResultLauncher<Intent> =
    registerForActivityResult(ActivityResultContracts.StartActivityForResult(), resultCallback)

fun ComponentActivity.requestPermission(resultCallback: ActivityResultCallback<Boolean>): ActivityResultLauncher<String> =
    registerForActivityResult(ActivityResultContracts.RequestPermission(), resultCallback)

fun ComponentActivity.requestPermissions(resultCallback: ActivityResultCallback<Map<String, Boolean>>): ActivityResultLauncher<Array<String>> =
    registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions(), resultCallback)