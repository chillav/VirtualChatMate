package com.ks.virtualchatmate.di

import com.ks.virtualchatmate.chat.ChatViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ChatViewModel() }
}
