package woowacourse.kanban.board.taskCard

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun TaskTitle(
    @PreviewParameter(TitlePreviewParameterProvider::class)
    title: String,
    maxLines: Int = 1,
) {
    Text(
        text = title,
        fontWeight = Bold,
        fontSize = 18.sp,
        fontFamily = FontFamily.SansSerif,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
    )
}

private class TitlePreviewParameterProvider : PreviewParameterProvider<String> {
    override val values: Sequence<String> = sequenceOf(
        "LazyColumn 컴포넌트 구현",
        "너무너무 긴 제목은 한 줄까지만 노출되고 말줄임표로 처리됩니다.",
    )
}
