package pro.grino.karateclub.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pro.grino.karateclub.features.groups.GroupsListScreen
import pro.grino.karateclub.features.players.PlayersListScreen
import pro.grino.karateclub.ui.screens.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            setContent {
                // Используем стандартные цвета Material3 без динамической темы
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        playersContent = { PlayersListScreen() },
                        groupsContent = { GroupsListScreen() }
                    )
                }
            }
        } catch (e: Exception) {
            // Запасной вариант в случае проблем с темой
            setContent {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFAFAFA) // Светло-серый цвет
                ) {
                    MainScreen(
                        playersContent = { PlayersListScreen() },
                        groupsContent = { GroupsListScreen() }
                    )
                }
            }
        }
    }
}