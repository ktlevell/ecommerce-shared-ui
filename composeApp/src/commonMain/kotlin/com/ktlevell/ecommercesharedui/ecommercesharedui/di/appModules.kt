package com.ktlevell.ecommercesharedui.ecommercesharedui.di

import com.ktlevell.ecommercesharedui.di.dataModule
import com.ktlevell.ecommercesharedui.di.domainModule
import com.ktlevell.ecommercesharedui.di.navigationModule
import com.ktlevell.ecommercesharedui.di.supabaseModule
import com.ktlevell.ecommercesharedui.ecommercesharedui.features.di.featuresModules
import com.ktlevell.ecommercesharedui.ecommercesharedui.features.home.di.homeModule

val appModules =
    listOf(
        navigationModule,
        dataModule,
        domainModule,
        supabaseModule,
        homeModule
    )