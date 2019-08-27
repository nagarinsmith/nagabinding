package com.nagabinding.shared.util.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import coil.transform.CircleCropTransformation
import com.nagabinding.R

@BindingAdapter("app:avatarUrl")
fun ImageView.setAvatarUrl(avatarUrl: String?) {
    load(avatarUrl) {
        placeholder(R.drawable.ic_person_black_24dp)
        transformations(CircleCropTransformation())
    }
}

@BindingAdapter("app:avatarLargeUrl")
fun ImageView.setAvatarLargeUrl(avatarUrl: String?) {
    load(avatarUrl) {
        placeholder(R.drawable.ic_person_black_24dp)
    }
}
