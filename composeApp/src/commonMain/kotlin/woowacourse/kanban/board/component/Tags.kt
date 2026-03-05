package woowacourse.kanban.board.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.CustomColor
import woowacourse.kanban.board.Size

@Composable
fun Tags(tags: List<String>?) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        tags?.take(Size.TAGS.value)?.forEach { tag ->
            TagBox(tag.take(Size.TAG_TEXT_LENGTH.value))
        }
    }
}

@Composable
fun TagBox(filteredTag: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(14.dp))
            .background(
                color = CustomColor.TAG_BACKGROUND.color,
            )
            .padding(vertical = 4.dp, horizontal = 6.dp),
    ) {
        Text(
            text = filteredTag,
            fontSize = 12.sp,
            color = CustomColor.TAG_TEXT.color,
        )
    }
}