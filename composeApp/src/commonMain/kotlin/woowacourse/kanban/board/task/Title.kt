package woowacourse.kanban.board.task

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
@Preview(showBackground = true)
private fun TaskTitlePreview() {
    MaterialTheme {
        TaskTitle(title = "LazyColumn 컴포넌트 구현")
    }
}
@Composable
fun TaskTitle(title: String) {
    Text(
        text = title,
        fontWeight = Bold,
        fontSize = 16.sp,
        fontFamily = FontFamily.SansSerif,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}
