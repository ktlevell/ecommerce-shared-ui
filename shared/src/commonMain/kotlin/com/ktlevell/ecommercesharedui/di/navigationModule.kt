package com.ktlevell.ecommercesharedui.di

import com.ktlevell.ecommercesharedui.navigation.Navigator
import com.ktlevell.ecommercesharedui.navigation.NavigatorImpl
import org.koin.dsl.module

val navigationModule = module {
    single<Navigator> { NavigatorImpl() }
}