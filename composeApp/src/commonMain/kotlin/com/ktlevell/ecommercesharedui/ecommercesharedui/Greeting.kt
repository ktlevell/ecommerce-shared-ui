package com.ktlevell.ecommercesharedui.ecommercesharedui

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}