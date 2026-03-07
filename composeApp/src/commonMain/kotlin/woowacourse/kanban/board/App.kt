package woowacourse.kanban.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.data.TaskCardData
import woowacourse.kanban.board.task.TaskCard


@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
fun AppPreview() {
    App()
}

@Composable
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 62.5.dp, vertical = 60.dp)
                .safeContentPadding()
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(18.5.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(18.5.dp),
            ) {
                TaskCardData.tasks.take(4).forEach { task ->
                    TaskCard(
                        title = task.title,
                        contents = task.contents,
                        tagNames = task.tagNames,
                        contactName = task.contactName,
                    )
                }

            }

            Row {
                val maxTask = TaskCardData.tasks.last()
                TaskCard(
                    title = maxTask.title,
                    contents = maxTask.contents,
                    tagNames = maxTask.tagNames,
                    contactName = maxTask.contactName,
                )
            }

        }
    }
}

