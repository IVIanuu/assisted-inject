package com.ivianuu.assistedinject.sample

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class KeyViewModelProviderFactory @Inject constructor(
    private val factories: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<@JvmSuppressWildcards KeyViewModelFactory<*>>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val factory = factories[modelClass]?.get() as? KeyViewModelFactory<Parcelable>
            ?: throw IllegalArgumentException("no factory found for $modelClass")
        return factory.create(Bundle()) as T
    }
}

class MainActivity : AppCompatActivity() {

    @Inject lateinit var factory: KeyViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        Log.d("testt", "viewmodel $viewModel")
    }
}
