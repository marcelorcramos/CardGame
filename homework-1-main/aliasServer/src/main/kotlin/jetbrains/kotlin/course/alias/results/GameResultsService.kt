package jetbrains.kotlin.course.alias.results

import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService
import org.springframework.stereotype.Service

typealias GameResult = List<Team> // Type alias for GameResult

@Service
class GameResultsService {
    companion object {
        // Mutable list to store game results
        val gameHistory: MutableList<GameResult> = mutableListOf()
    }

    // Save game results after validation
    fun saveGameResults(result: GameResult) {
        // Check if the result is not empty
        if (result.isEmpty()) {
            throw IllegalArgumentException("Game result cannot be empty.")
        }

        // Check if all team IDs are in TeamService.teamsStorage
        for (team in result) {
            if (!TeamService.teamsStorage.containsKey(team.id)) {
                throw IllegalArgumentException("Team ID ${team.id} is not in the storage.")
            }
        }

        gameHistory.add(result) // Add the validated result to gameHistory
    }

    // Get all game results in reversed order
    fun getAllGameResults(): List<GameResult> {
        return gameHistory.reversed() // Return the reversed list of game results
    }
}
