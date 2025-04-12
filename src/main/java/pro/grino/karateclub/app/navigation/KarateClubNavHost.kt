package pro.grino.karateclub.app.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pro.grino.karateclub.core.navigation.NavRoutes
import pro.grino.karateclub.features.players.PlayersListScreen

@Composable
fun KarateClubNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.PLAYERS_LIST
    ) {
        // Участники
        composable(route = NavRoutes.PLAYERS_LIST) {
            PlayersListScreen(navController)
        }

        composable(route = NavRoutes.PLAYERS_DETAILS) { backStackEntry ->
            val playerId = backStackEntry.arguments?.getString("playerId")
            // Временная заглушка
            TemporaryScreen(name = "PlayerId Details for ID: $playerId")
        }

        // Группы
        composable(route = NavRoutes.GROUPS_LIST) {
            // Временная заглушка
            TemporaryScreen(name = "Groups List")
        }

        composable(route = NavRoutes.GROUP_DETAILS) { backStackEntry ->
            val groupId = backStackEntry.arguments?.getString("groupId")
            // Временная заглушка
            TemporaryScreen(name = "Group Details for ID: $groupId")
        }
    }
}

// Временный экран-заглушка для отображения, пока нет реализации экранов из feature-модулей
@Composable
private fun TemporaryScreen(name: String) {
    Text(
        text = "This is a placeholder for $name",
        style = MaterialTheme.typography.headlineMedium,
        modifier = Modifier.padding(16.dp)
    )
}