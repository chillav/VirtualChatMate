package com.ks.virtualchatmate.di

import com.ks.virtualchatmate.Constants
import com.ks.virtualchatmate.api.ChatApiService
import com.ks.virtualchatmate.chat.ChatGptRepository
import com.ks.virtualchatmate.chat.ChatViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


val appModule = module {
    viewModel { ChatViewModel(get()) }
    single { ChatGptRepository(get()) }

    single<ChatApiService> { get<Retrofit>().create(ChatApiService::class.java) }

    single<Retrofit> {
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BASIC)
        }

        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()

        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_CHAT_GPT)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
    }
}
