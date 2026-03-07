package woowacourse.kanban.board.task

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
@Preview(showBackground = true)
private fun TaskContentsPreview() {
    MaterialTheme {
        TaskContents("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.")
    }
}
@Composable
fun TaskContents(contents: String) {
    if (contents.isNotBlank()) {
        Text(
            text = contents,
            fontSize = 14.sp,
            fontFamily = FontFamily.SansSerif,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
    }
}
