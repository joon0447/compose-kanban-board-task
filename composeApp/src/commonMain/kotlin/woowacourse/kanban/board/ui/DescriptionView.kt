package woowacourse.kanban.board.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.model.Description
import woowacourse.kanban.board.design.Font

@Composable
fun DescriptionView(description: Description) {
    Text(
        text = description.text,
        fontSize = Font.DESCRIPTION.size,
        overflow = TextOverflow.Ellipsis,
        maxLines = 2,
        modifier = Modifier.padding(8.dp),
        color = Color.DarkGray,
    )
}
