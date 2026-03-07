package woowacourse.kanban.board.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp


@Composable
@Preview(showBackground = true)
private fun TaskContactPreview() {
    MaterialTheme {
        TaskContact(contactName = "디이노")
    }
}

@Composable
fun TaskContact(contactName: String) {
    Row(
        modifier = Modifier
            .width(336.dp)
            .height(60.dp)
            .drawBehind {
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
        ContactProfile()
        ContactName(contactName)
    }
}

@Composable
private fun ContactProfile() {
    Icon(
        modifier = Modifier
            .background(Color.White, shape = CircleShape),
        imageVector = Icons.Default.AccountCircle,
        contentDescription = "계정프로필",
        tint = Color.Gray
    )
}

@Composable
private fun ContactName(contactName: String) {
    Text(
        text = contactName,
        fontFamily = FontFamily.SansSerif,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,

        )
}
