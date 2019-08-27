package com.nagabinding.shared.util

inline fun consume(toExecute: () -> Unit) = true.also { toExecute() }
