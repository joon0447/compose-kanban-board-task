package woowacourse.kanban.board.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.design.Font
import woowacourse.kanban.board.model.Assignee

@Composable
fun AssigneeView(assignee: Assignee) {
    Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "사용자 기본 이미지",
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = assignee.name,
            fontSize = Font.ASSIGNEE.size,
            fontWeight = Font.ASSIGNEE.weight,
            overflow = TextOverflow.Ellipsis, maxLines = 1,
        )
    }
}