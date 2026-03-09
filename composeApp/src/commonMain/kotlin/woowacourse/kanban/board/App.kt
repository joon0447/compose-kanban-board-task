package woowacourse.kanban.board

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import woowacourse.kanban.board.component.KanbanCard
import woowacourse.kanban.board.model.Content
import woowacourse.kanban.board.model.Crew
import woowacourse.kanban.board.model.Tag
import woowacourse.kanban.board.model.Title

@Composable
@Preview
fun App() {
    MaterialTheme {
        KanbanCard(
            title = Title("LazyColumn 컴포넌트 구현"),
            content = Content("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다."),
            tags = listOf(Tag("컴포넌트"), Tag("성능")),
            crew = Crew("다이노"),
        )
    }
}
