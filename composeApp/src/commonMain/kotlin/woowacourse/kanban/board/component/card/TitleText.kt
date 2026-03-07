package woowacourse.kanban.board.component.card

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.component.TITLE_MAX_EX

@Composable
fun TitleText(title: String? = null) {
    Text(
        text = title ?: "LazyColumn 컴포넌트 구현",
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 24.sp,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview(showBackground = true)
@Composable
fun TitleTextPreview() {
    TitleText()
}

@Preview(showBackground = true)
@Composable
fun TitleTextMaxPreview() {
    TitleText(TITLE_MAX_EX)
}
