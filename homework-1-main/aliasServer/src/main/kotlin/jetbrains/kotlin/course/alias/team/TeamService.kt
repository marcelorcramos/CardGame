package jetbrains.kotlin.course.alias.team

import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory
import org.springframework.stereotype.Service

@Service
class TeamService(
    private val identifierFactory: IdentifierFactory = IdentifierFactory() // Default value for identifierFactory
) {
    companion object {
        // Storage for all previous teams
        var teamsStorage: MutableMap<Identifier,/* = Int */ Team> = mutableMapOf()
    }

    // Generates teams for one round and stores them in the teamsStorage map
    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> {
        val teams = mutableListOf<Team>()

        for (i in 1..teamsNumber) {
            val id: Identifier = identifierFactory.uniqueIdentifier() // Generate a unique identifier
            val team = Team(id) // Create a new Team with the generated ID
            teams.add(team) // Add team to the list
            teamsStorage[id] = team // Store the team in the teamsStorage map
        }

        return teams // Return the list of generated teams
    }
}
