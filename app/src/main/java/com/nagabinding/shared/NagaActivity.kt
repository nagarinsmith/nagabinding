package com.nagabinding.shared

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.nagabinding.BR

abstract class NagaActivity<BINDING : ViewDataBinding, VIEW_MODEL : ViewModel>(@LayoutRes private val layoutResource: Int) : AppCompatActivity() {

    protected lateinit var binding: BINDING
    protected abstract val viewModel: VIEW_MODEL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<BINDING>(this, layoutResource).also {
            it.lifecycleOwner = this
            it.setVariable(BR.viewModel, viewModel)
            binding = it
        }
    }
}
