package woowacourse.kanban.board.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.model.Title
import woowacourse.kanban.board.design.Font


@Composable
fun TitleView(title: Title) {
    Text(
        text = title.text,
        fontSize = Font.TITLE.size,
        overflow = TextOverflow.Ellipsis, maxLines = 1,
        modifier = Modifier.padding(8.dp),
    )
}
