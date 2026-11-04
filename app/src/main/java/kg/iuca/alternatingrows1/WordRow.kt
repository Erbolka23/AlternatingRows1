package kg.iuca.alternatingrows1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Один ряд: слово, разложенное на квадратики с буквами
@Composable
fun WordRow(
    word: String,
    rowIndex: Int,
    yellowLetters: Set<Int>,
    modifier: Modifier = Modifier
) {
    // Ряды считаем с 1: первый ряд нечётный, второй чётный и так далее
    val isEvenRow = (rowIndex + 1) % 2 == 0

    // Нечётные ряды: стандартный основной цвет темы. Чётные ряды: серый
    val rowColor = if (isEvenRow) Color.LightGray else MaterialTheme.colorScheme.primary
    // Цвет букв подбираем так, чтобы они читались на фоне ряда
    val rowTextColor = if (isEvenRow) Color.Black else MaterialTheme.colorScheme.onPrimary

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(rowColor)
            .padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        word.forEachIndexed { letterIndex, letter ->
            if (letterIndex in yellowLetters) {
                // Случайно выбранная буква в чётном ряду: жёлтый фон
                LetterBox(letter = letter, backgroundColor = Color.Yellow, textColor = Color.Black)
            } else {
                LetterBox(letter = letter, backgroundColor = rowColor, textColor = rowTextColor)
            }
        }
    }
}
