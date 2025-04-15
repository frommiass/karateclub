package pro.grino.karateclub.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import pro.grino.karateclub.features.groups.AddGroupScreen
import pro.grino.karateclub.features.groups.GroupsListScreen
import pro.grino.karateclub.features.players.AddPlayerScreen
import pro.grino.karateclub.features.players.PlayersListScreen
import pro.grino.karateclub.ui.screens.MainScreen
import pro.grino.karateclub.ui.theme.KarateClubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KarateClubTheme {
                // Контейнер с цветом фона из темы
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    // Главный экран с навигацией между вкладками и внутри них
                    MainScreen(
                        navController = navController,
                        playersListContent = { PlayersListScreen(navController = it) },
                        playersAddContent = { AddPlayerScreen(navController = it) },
                        groupsListContent = { GroupsListScreen(navController = it) },
                        groupsAddContent = { AddGroupScreen(navController = it) }
                    )
                }
            }
        }
    }
}