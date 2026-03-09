package woowacourse.kanban.board.taskCard

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun TaskContents(
    @PreviewParameter(TaskPreviewParameterProvider::class)
    contents: String,
    maxLines: Int = 2,
) {
    Text(
        text = contents,
        fontSize = 15.sp,
        fontFamily = FontFamily.SansSerif,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
    )
}

private class TaskPreviewParameterProvider : PreviewParameterProvider<String> {
    override val values: Sequence<String> = sequenceOf(
        "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
        "너무너무 긴 본문은 두 줄까지만 노출되고 말줄임표로 처리합니다. 너무너무 긴 본문은 두 줄까지만 노출되고 말줄임표로 처리합니다.",
    )
}