package woowacourse.kanban.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.taskCard.Tag
import woowacourse.kanban.board.taskCard.TaskCard
import woowacourse.kanban.board.taskCard.TaskInfo

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier.background(Color.White).safeContentPadding().fillMaxSize(),
        ) {
            TaskCard(
                TaskInfo(
                    title = "LazyColumn 컴포넌트 구현",
                    contents = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                    tags = listOf(Tag("컴포넌트"), Tag("성능")),
                    contactName = "다이노",
                ),
                modifier = Modifier.width(373.dp),
            )
        }
    }
}
