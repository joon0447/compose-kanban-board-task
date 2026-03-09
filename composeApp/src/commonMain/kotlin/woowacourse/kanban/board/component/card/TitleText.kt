package woowacourse.kanban.board.component.card

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.sp

@Composable
fun TitleText(
    title: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = title,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 24.sp,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier,
    )
}

private class TitleTextPreviewParameterProvider : PreviewParameterProvider<String> {
    override val values = sequenceOf(
        "LazyColumn 컴포넌트 구현",
        "너무너무 긴 제목은 한 줄까지만 노출너무너무 긴 제목은 한 줄까지만 노출...너무너무 긴 제목은 한 줄까지만 노출...너무너무 긴 제목은 한 줄까지만 노출...너무너무 긴 제목은 한 줄까지만 노출...너무너무 긴 제목은 한 줄까지만 노출...너무너무 긴 제목은 한 줄까지만 노출...",
    )
}

@Preview(showBackground = true)
@Composable
private fun TitleTextPreview(@PreviewParameter(TitleTextPreviewParameterProvider::class) title: String) {
    TitleText(title)
}
