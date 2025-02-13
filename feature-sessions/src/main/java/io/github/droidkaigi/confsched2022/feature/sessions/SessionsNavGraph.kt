package io.github.droidkaigi.confsched2022.feature.sessions

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import io.github.droidkaigi.confsched2022.model.TimetableItemId

fun NavGraphBuilder.sessionsNavGraph(
    showNavigationIcon: Boolean,
    onNavigationIconClick: () -> Unit,
    onBackIconClick: () -> Unit,
    onTimetableClick: (TimetableItemId) -> Unit,
    onNavigateFloorMapClick: () -> Unit,
) {
    composable(route = SessionsNavGraph.sessionRoute) {
        SessionsScreenRoot(
            showNavigationIcon = showNavigationIcon,
            onNavigationIconClick = onNavigationIconClick,
            onSearchClicked = { /*TODO: Implement later*/ },
            onTimetableClick = onTimetableClick,
        )
    }

    composable(
        route = SessionsNavGraph.sessionDetailRoute("{id}"),
        arguments = listOf(
            navArgument("id") {
                type = NavType.StringType
            }
        )
    ) {
        // TODO make it savable
        val id = it.arguments?.getString("id") ?: ""
        SessionDetailScreenRoot(
            timetableItemId = TimetableItemId(id),
            onBackIconClick = onBackIconClick,
            onNavigateFloorMapClick = onNavigateFloorMapClick,
        )
    }
}

object SessionsNavGraph {
    const val sessionRoute = "sessions"
    fun sessionDetailRoute(sessionId: String) =
        "session/detail/$sessionId"
}
