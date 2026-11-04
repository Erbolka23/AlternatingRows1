package kg.iuca.alternatingrows1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import kg.iuca.alternatingrows1.ui.theme.AlternatingRows1Theme // если проект назван иначе, имя темы другое (см. ui/theme/Theme.kt)

// Здесь только сама активность. Весь интерфейс лежит в других файлах.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlternatingRows1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Слова, которые будут показаны рядами из квадратиков с буквами
                    Greeting(
                        words = listOf("COMPOSE", "KOTLIN", "ANDROID", "JETPACK", "ROW", "COLUMN"),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
