package com.ktlevell.ecommercesharedui.ecommercesharedui

import androidx.compose.ui.window.ComposeUIViewController
import com.ktlevell.ecommercesharedui.ecommercesharedui.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}
