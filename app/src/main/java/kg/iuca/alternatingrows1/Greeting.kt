package kg.iuca.alternatingrows1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kg.iuca.alternatingrows1.ui.theme.AlternatingRows1Theme
import kotlin.random.Random

// Показывает слова рядами из квадратиков с буквами: один ряд = одно слово
@Composable
fun Greeting(words: List<String>, modifier: Modifier = Modifier) {

    // Случайные жёлтые буквы выбираем ОДИН раз и запоминаем через remember.
    // Если случайность считать прямо в рядах, при каждой перерисовке экрана жёлтые буквы будут прыгать.
    val yellowIndexes: List<Set<Int>> = remember(words) {
        words.mapIndexed { rowIndex, word ->
            val isEvenRow = (rowIndex + 1) % 2 == 0 // индексы идут с 0, а человек считает ряды с 1
            if (isEvenRow && word.isNotEmpty()) {
                val maxCount = maxOf(1, word.length / 2)   // не больше половины букв слова
                val minCount = minOf(2, maxCount)          // «несколько», то есть минимум две, если хватает букв
                val count = Random.nextInt(minCount, maxCount + 1)
                word.indices.shuffled().take(count).toSet() // номера случайных букв без повторов
            } else {
                emptySet() // в нечётных рядах жёлтых букв нет
            }
        }
    }

    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        words.forEachIndexed { rowIndex, word ->
            WordRow(
                word = word,
                rowIndex = rowIndex,
                yellowLetters = yellowIndexes[rowIndex]
            )
        }
    }
}

// Предпросмотр прямо в Android Studio. Жёлтые буквы в нём могут отличаться от эмулятора, это нормально
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AlternatingRows1Theme {
        Greeting(words = listOf("COMPOSE", "KOTLIN", "ANDROID", "JETPACK"))
    }
}
