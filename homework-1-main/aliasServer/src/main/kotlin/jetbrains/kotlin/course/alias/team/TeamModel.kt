package jetbrains.kotlin.course.alias.team

import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory

data class Team(val id: Identifier, var points: Int = 0) {
    val name: String
        get() = "Team#${id + 1}"
}

