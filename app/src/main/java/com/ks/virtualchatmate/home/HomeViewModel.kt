package com.ks.virtualchatmate.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    private val _dialogState = MutableStateFlow<List<Dialogues>>(emptyList())
    val dialogState = _dialogState.asStateFlow()

    init {
        _dialogState.value = fetchDialogues()
    }

    fun fetchDialogues(): List<Dialogues> {
        return listOf(
            Dialogues(
                imageUrl = "https://anime-fans.ru/wp-content/uploads/2021/04/Krasivye-anime-kartinki-na-avu-dlya-devushek_03.jpg",
                name = "Sanya",
                lastMessage = "Privet kak dela?",
            ),
            Dialogues(
                imageUrl =
                "https://anime-fans.ru/wp-content/uploads/2021/04/Krasivye-anime-kartinki-na-avu-dlya-devushek_13.jpg",
                name = "Vika",
                lastMessage = "Созвон сегодня будет?",
            ),
            Dialogues(
                imageUrl =
                "https://anime-fans.ru/wp-content/uploads/2021/04/Krasivye-anime-kartinki-na-avu-dlya-devushek_13.jpg",
                name = "Vika",
                lastMessage = "Созвон сегодня будет?",
            ),
            Dialogues(
                imageUrl =
                "https://anime-fans.ru/wp-content/uploads/2021/04/Krasivye-anime-kartinki-na-avu-dlya-devushek_13.jpg",
                name = "Vika",
                lastMessage = "Созвон сегодня будет?",
            ),
            Dialogues(
                imageUrl =
                "https://anime-fans.ru/wp-content/uploads/2021/04/Krasivye-anime-kartinki-na-avu-dlya-devushek_13.jpg",
                name = "Vika",
                lastMessage = "Созвон сегодня будет?",
            ),
            Dialogues(
                imageUrl =
                "https://anime-fans.ru/wp-content/uploads/2021/04/Krasivye-anime-kartinki-na-avu-dlya-devushek_13.jpg",
                name = "Vika",
                lastMessage = "Созвон сегодня будет?",
            ),
            Dialogues(
                imageUrl =
                "https://anime-fans.ru/wp-content/uploads/2021/04/Krasivye-anime-kartinki-na-avu-dlya-devushek_13.jpg",
                name = "Vika",
                lastMessage = "Созвон сегодня будет?",
            ),
            Dialogues(
                imageUrl =
                "https://anime-fans.ru/wp-content/uploads/2021/04/Krasivye-anime-kartinki-na-avu-dlya-devushek_13.jpg",
                name = "Vika",
                lastMessage = "Созвон сегодня будет?",
            ),
            Dialogues(
                imageUrl =
                "https://anime-fans.ru/wp-content/uploads/2021/04/Krasivye-anime-kartinki-na-avu-dlya-devushek_13.jpg",
                name = "Vika",
                lastMessage = "Созвон сегодня будет?",
            ),
            Dialogues(
                imageUrl =
                "https://anime-fans.ru/wp-content/uploads/2021/04/Krasivye-anime-kartinki-na-avu-dlya-devushek_13.jpg",
                name = "Vika",
                lastMessage = "Созвон сегодня будет?",
            ),
            Dialogues(
                imageUrl =
                "https://anime-fans.ru/wp-content/uploads/2021/04/Krasivye-anime-kartinki-na-avu-dlya-devushek_13.jpg",
                name = "Vika",
                lastMessage = "Созвон сегодня будет?",
            ),
            Dialogues(
                imageUrl =
                "https://anime-fans.ru/wp-content/uploads/2021/04/Krasivye-anime-kartinki-na-avu-dlya-devushek_13.jpg",
                name = "Vika",
                lastMessage = "Созвон сегодня будет?",
            ),
        )
    }
}