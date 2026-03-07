package woowacourse.kanban.board.task

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
@Preview(showBackground = true)
private fun TaskTagsPreview() {
    MaterialTheme {
        TaskTags(
            tagNames = listOf("너무너무", "성능", "긴 태그", "최대로", "5자까지", "5개제한임"),
        )
    }
}

@Composable
fun TaskTags(tagNames: List<String>) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        tagNames.forEach {
            TaskTag(it)
        }
    }
}

@Composable
private fun TaskTag(tagName: String) {
    Button(
        modifier = Modifier
            .height(32.dp),
        onClick = {
        },
        shape = RoundedCornerShape(21.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
        contentPadding = PaddingValues(vertical = 5.dp, horizontal = 10.dp),
    ) {
        Text(
            text = tagName.take(5),
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            fontSize = 12.sp,
        )
    }
}


