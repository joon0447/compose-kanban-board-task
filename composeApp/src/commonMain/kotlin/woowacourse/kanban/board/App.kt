package woowacourse.kanban.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import woowacourse.kanban.board.model.TaskCardDto
import woowacourse.kanban.board.ui.AddButton
import woowacourse.kanban.board.ui.InputWindow
import woowacourse.kanban.board.ui.TaskCardList

@Composable
@Preview(showBackground = true)
fun App() {
    val taskCardGroup = remember { mutableStateListOf<TaskCardDto>() }
    var showInputWindow by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        TaskCardList(taskCardGroup)
        AddButton(Modifier.align(Alignment.BottomEnd), showInputWindow) { showInputWindow = true }
        if (showInputWindow) {
            InputWindow(taskCardGroup, true) { showInputWindow = false }
        }
    }
}
