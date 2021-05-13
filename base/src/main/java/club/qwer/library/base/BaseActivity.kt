package club.qwer.library.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<VM : BaseViewModel, VB : ViewBinding> : AppCompatActivity() {
    protected val viewBinding: VB by lazy {
        inflateBinding()
    }

    protected val viewModel: VM by lazy {
        getViewModelFactory()?.let { factory ->
            ViewModelProvider(this, factory).get(getViewModelClazz())
        } ?: ViewModelProvider(this).get(getViewModelClazz())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        initializeViewModel()
        initializeView()
    }

    @Suppress("UNCHECKED_CAST")
    private fun getViewModelClazz(): Class<VM> {
        val type = (javaClass.genericSuperclass as? ParameterizedType)?.actualTypeArguments?.get(0)
        return type as Class<VM>
    }

    abstract fun inflateBinding(): VB

    abstract fun initializeViewModel()

    abstract fun initializeView()

    open fun getViewModelFactory(): ViewModelProvider.Factory? {
        return null
    }
}