package com.nagabinding.shared.util.bindingadapter

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:isVisible")
fun View.isVisible(isVisible: Boolean?) {
    if (isVisible == null) return
    visibility = if (isVisible) View.VISIBLE else View.GONE
}
