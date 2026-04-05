package com.ktlevell.ecommercesharedui.di

import com.ktlevell.ecommercesharedui.shared.BuildKonfig
import org.koin.dsl.module

val supabaseModule = module {
    single {
        SupabaseClientFactory(
            supabaseUrl = BuildKonfig.SB_URL,
            supabaseKey = BuildKonfig.SB_KEY
        ).create()
    }
}