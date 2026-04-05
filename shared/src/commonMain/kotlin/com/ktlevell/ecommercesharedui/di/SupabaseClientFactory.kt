package com.ktlevell.ecommercesharedui.di

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.annotations.SupabaseInternal
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

@OptIn(SupabaseInternal::class)
class SupabaseClientFactory(
    private val supabaseUrl: String,
    private val supabaseKey: String,
) {

    fun create(): SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = supabaseUrl,
            supabaseKey = supabaseKey
        ) {

            install(Postgrest)

            httpConfig {

                install(ContentNegotiation) {
                    json(Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                    })
                }

                install(HttpTimeout) {
                    requestTimeoutMillis = 20_000
                    connectTimeoutMillis = 20_000
                    socketTimeoutMillis = 20_000
                }

                defaultRequest {
                    contentType(ContentType.Application.Json)
                }
            }
        }
    }
}