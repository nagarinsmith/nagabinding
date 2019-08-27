package com.nagabinding.shared.util

import androidx.lifecycle.MutableLiveData

fun <T : Any?> MutableLiveData<T>.initialize(initialValue: T) = this.also { value = initialValue }
