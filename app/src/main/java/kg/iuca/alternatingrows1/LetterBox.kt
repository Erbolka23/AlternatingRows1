package kg.iuca.alternatingrows1

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Один квадратик с одной буквой
@Composable
fun LetterBox(
    letter: Char,
    backgroundColor: Color,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(36.dp)
            .background(backgroundColor)
            // Тонкая рамка, чтобы границы квадратиков были видны, даже когда цвет совпадает с цветом ряда
            .border(1.dp, Color.Black.copy(alpha = 0.25f)),
        contentAlignment = Alignment.Center // буква ровно по центру квадратика
    ) {
        Text(
            text = letter.toString(),
            color = textColor,
            style = MaterialTheme.typography.titleMedium
        )
    }
}
