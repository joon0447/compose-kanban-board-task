package woowacourse.kanban.board.study

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.sp

@Composable
fun TextExample() {
    Text(
        text = "Jetpack Compose Text 실습",
        color = Color.Blue,
        fontSize = 22.sp,
        fontWeight = Bold,
    )
}
