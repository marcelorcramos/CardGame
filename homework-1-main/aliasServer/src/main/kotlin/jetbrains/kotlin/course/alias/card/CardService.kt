package jetbrains.kotlin.course.alias.card
import jetbrains.kotlin.course.alias.util.words
import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory
import kotlin.random.Random
import org.springframework.stereotype.Service

@Service
class CardService(
    private val identifierFactory: IdentifierFactory = IdentifierFactory() // Default identifier factory
) {
    // Lista de palavras pré-definida
   // private val words: List<String> = listOf("apple", "banana", "cherry", "date", "fig", "grape")

    // Lista de cartas inicializada chamando o método generateCards
    val cards: List<Card> = generateCards()

    companion object {
        const val WORDS_IN_CARD = 4 // Número de palavras por carta
        var cardsAmount: Int = 0 // Número possível de cartas

        // Inicializa cardsAmount com base na lista de palavras
        init {
            cardsAmount = 40 / WORDS_IN_CARD // Aqui, 6 é o número de palavras
        }
    }

    // Função de extensão para converter List<String> em List<Word>
    private fun List<String>.toWords(): List<Word> {
        return this.map { Word(it) }
    }

    // Gera cartas a partir da lista de palavras
    private fun generateCards(): List<Card> {
        val shuffledWords = words.shuffled() // Embaralha as palavras
        println("Palavras embaralhadas: $shuffledWords")

        // Divide as palavras em grupos e cria as cartas
        return shuffledWords.chunked(WORDS_IN_CARD) // Chunk the words into groups
            .take(cardsAmount) // Take only the number of chunks equal to cardsAmount
            .map { chunk ->
                Card(id = identifierFactory.uniqueIdentifier(), words = chunk.toWords())
            }
    }

    // Obtém uma carta pelo seu índice
    fun getCardByIndex(index: Int): Card {
        if (index < 0 || index >= cards.size) {
            throw IndexOutOfBoundsException("O índice da carta $index está fora dos limites.")
        }
        return cards[index] // Retorna a carta no índice dado
    }
}
