package woowacourse.kanban.board.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.design.ColorPalette
import woowacourse.kanban.board.model.Tag
import woowacourse.kanban.board.design.Font

@Composable
fun TagView(tag: Tag) {
    Text(
        text = tag.text,
        fontSize = Font.TAG.size,
        modifier = Modifier.background(ColorPalette.LighterGray, RoundedCornerShape(10.dp)).padding(4.dp),
    )
}
