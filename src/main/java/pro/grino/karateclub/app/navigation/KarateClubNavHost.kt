package pro.grino.karateclub.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

// Определение навигационных маршрутов
object NavRoutes {
    // Аутентификация
    const val AUTH = "auth"

    // Участники
    const val PARTICIPANTS_LIST = "participants_list"
    const val PARTICIPANT_DETAILS = "participant_details/{participantId}"
    const val PARTICIPANT_EDIT = "participant_edit?participantId={participantId}"

    // Группы
    const val GROUPS_LIST = "groups_list"
    const val GROUP_DETAILS = "group_details/{groupId}"
}

@Composable
fun KarateClubNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.AUTH
    ) {
        // Аутентификация
        composable(route = NavRoutes.AUTH) {
            // Здесь будет AuthScreen из feature-auth модуля
            // AuthScreen(navController)
            // Временная заглушка
            TemporaryScreen(name = "Auth Screen")
        }

        // Участники
        composable(route = NavRoutes.PARTICIPANTS_LIST) {
            // Здесь будет ParticipantsListScreen из feature-participants модуля
            // ParticipantsListScreen(navController)
            // Временная заглушка
            TemporaryScreen(name = "Participants List")
        }

        composable(route = NavRoutes.PARTICIPANT_DETAILS) { backStackEntry ->
            val participantId = backStackEntry.arguments?.getString("participantId")
            // Здесь будет ParticipantDetailsScreen из feature-participants модуля
            // ParticipantDetailsScreen(navController, participantId)
            // Временная заглушка
            TemporaryScreen(name = "Participant Details for ID: $participantId")
        }

        // Группы
        composable(route = NavRoutes.GROUPS_LIST) {
            // Здесь будет GroupsListScreen из feature-groups модуля
            // GroupsListScreen(navController)
            // Временная заглушка
            TemporaryScreen(name = "Groups List")
        }

        composable(route = NavRoutes.GROUP_DETAILS) { backStackEntry ->
            val groupId = backStackEntry.arguments?.getString("groupId")
            // Здесь будет GroupDetailsScreen из feature-groups модуля
            // GroupDetailsScreen(navController, groupId)
            // Временная заглушка
            TemporaryScreen(name = "Group Details for ID: $groupId")
        }
    }
}

// Временный экран-заглушка для отображения, пока нет реализации экранов из feature-модулей
@Composable
private fun TemporaryScreen(name: String) {
    androidx.compose.material3.Text(
        text = "This is a placeholder for $name",
        style = androidx.compose.material3.MaterialTheme.typography.headlineMedium
    )
}