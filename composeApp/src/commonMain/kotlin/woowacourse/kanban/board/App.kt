package woowacourse.kanban.board

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.model.Tag
import woowacourse.kanban.board.model.TaskCard
import woowacourse.kanban.board.ui.TaskCardView

private class TaskCardProvider : PreviewParameterProvider<TaskCard> {
    override val values: Sequence<TaskCard> = sequenceOf(
        TaskCard(
            title = "LazyColumn 컴포넌트 구현",
            description = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            tags = listOf(Tag("컴포넌트"), Tag("성능")),
            assignee = "다이노",
        ),
        TaskCard(
            title = "LazyColumn 컴포넌트 구현",
            tags = listOf(Tag("컴포넌트"), Tag("성능")),
            assignee = "다이노",
        ),
        TaskCard(
            title = "LazyColumn 컴포넌트 구현",
            description = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            assignee = "다이노",
        ),
        TaskCard(
            title = "LazyColumn 컴포넌트 구현",
            assignee = "다이노",
        ),
        TaskCard(
            title = "너무너무 긴 제목은 한 줄이지만 노출되고 말줄임표로 처리합니다",
            description = "너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노출하고 말줄임표로 처리합니다",
            tags = listOf(Tag("너무너무"), Tag("긴 태그"), Tag("최대로"), Tag("5자까지"), Tag("5개제한임")),
            assignee = "너무너무너무 긴 담당자도 한 줄이지만 노출되고 말줄임표로 처리합니다",
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun TaskCardPreview(
    @PreviewParameter(TaskCardProvider::class) taskCard: TaskCard,
) {
    MaterialTheme {
        TaskCardView(taskCard = taskCard)
    }
}

@Preview(showBackground = true)
@Composable
fun App() {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier.padding(20.dp),
    ) {
        TaskCardProvider().values.forEach { taskCard ->
            TaskCardView(taskCard = taskCard)
        }
    }
}
