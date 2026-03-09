package woowacourse.kanban.board.taskCard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun TaskContact(
    @PreviewParameter(ContactPreviewParameterProvider::class) contactName: String,
    modifier: Modifier = Modifier,
    maxLines: Int = 1,
) {
    Row(
        modifier = modifier.drawBehind {
            val strokeWidth = 1.dp.toPx()
            val y = strokeWidth / 2

            drawLine(
                color = Color.LightGray,
                start = Offset(0f, y),
                end = Offset(size.width, y),
                strokeWidth = strokeWidth,
            )
        },
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ContactProfile(Modifier.background(Color.Gray, shape = CircleShape))
        ContactName(contactName, maxLines)
    }
}

@Composable
private fun ContactProfile(modifier: Modifier) {
    Icon(
        modifier = modifier.border(
            shape = CircleShape,
            width = 2.dp,
            color = Color.Gray,
        ),
        imageVector = Icons.Default.AccountBox,
        contentDescription = "아이콘",
        tint = Color.White,
    )
}

@Composable
private fun ContactName(
    contactName: String,
    maxLines: Int = 1,
) {
    Text(
        text = contactName,
        fontFamily = FontFamily.SansSerif,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,

        )
}

private class ContactPreviewParameterProvider : PreviewParameterProvider<String> {
    override val values: Sequence<String> = sequenceOf(
        "다이노", "디노", "너무너무 긴이름은 말줄임표로 처리합니다. 너무너무 긴이름은 말줄임표로 처리합니다.",
    )
}