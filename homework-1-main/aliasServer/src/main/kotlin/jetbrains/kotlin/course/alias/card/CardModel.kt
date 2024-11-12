    package jetbrains.kotlin.course.alias.card

    import jetbrains.kotlin.course.alias.util.Identifier
    import jetbrains.kotlin.course.alias.util.IdentifierFactory
    import kotlin.random.Random

    @JvmInline
    value class Word(val word: String)

    data class Card(
        val id: Identifier,
        val words: List<Word>
    )
