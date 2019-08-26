package com.nagabinding.shared

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.nagabinding.BR

abstract class NagaFragment<BINDING : ViewDataBinding, VIEW_MODEL : ViewModel>(@LayoutRes private val layoutResource: Int) : Fragment() {

    // In the case of fragments, simply having the binding as a lateinit can lead to memory leaks because it holds context
    protected var binding: BINDING? = null
        private set
    protected abstract val viewModel: VIEW_MODEL

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        DataBindingUtil.inflate<BINDING>(layoutInflater, layoutResource, null, false).also {
            it.lifecycleOwner = viewLifecycleOwner
            it.setVariable(BR.viewModel, viewModel)
            binding = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    /* Since the binding is nullable, in some cases, like after receiving a response from an api call, the fragment might be destroyed so we need to check it's
    nullability, in cases where we are sure it is not null (onCreateView) we can use this helper function to avoid null checks */
    protected fun requireBinding(): BINDING = binding ?: throw NullPointerException("View was destroyed and the binding is null")
}
