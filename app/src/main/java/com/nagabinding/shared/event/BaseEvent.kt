package com.nagabinding.shared.event

interface BaseEvent

fun <EVENT : BaseEvent> EVENT.wrap() = EventWrapper(this)
