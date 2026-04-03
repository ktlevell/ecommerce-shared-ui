package com.ktlevell.ecommercesharedui.ecommercesharedui

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform