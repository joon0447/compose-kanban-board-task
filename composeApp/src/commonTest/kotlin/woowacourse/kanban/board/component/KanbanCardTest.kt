package woowacourse.kanban.board.component

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import woowacourse.kanban.board.model.Content
import woowacourse.kanban.board.model.Crew
import woowacourse.kanban.board.model.Tag
import woowacourse.kanban.board.model.Title
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class KanbanCardTest {
    @Test
    fun `제목, 설명, 담당자, 태그가 모두 입력된 카드가 정상적으로 표시된다`() = runComposeUiTest {
        val title = Title("LazyColumn 컴포넌트 구현")
        val content = Content("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.")
        val tags = listOf(Tag("컴포넌트"), Tag("성능"))
        val crew = Crew("다이노")

        setContent {
            KanbanCard(
                title = title,
                content = content,
                tags = tags,
                crew = crew,
            )
        }

        onNodeWithText(title.text).assertIsDisplayed()
        onNodeWithText(content.text).assertIsDisplayed()
        onNodeWithText(crew.name).assertIsDisplayed()
        tags.forEach { tag ->
            onNodeWithText(tag.name).assertIsDisplayed()
        }
    }

    @Test
    fun `제목, 설명, 담당자가 입력된 카드가 정상적으로 표시된다`() = runComposeUiTest {
        val title = Title("LazyColumn 컴포넌트 구현")
        val content = Content("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.")
        val crew = Crew("다이노")

        setContent {
            KanbanCard(
                title = title,
                content = content,
                crew = crew,
            )
        }

        onNodeWithText(title.text).assertIsDisplayed()
        onNodeWithText(content.text).assertIsDisplayed()
        onNodeWithText(crew.name).assertIsDisplayed()
    }

    @Test
    fun `제목, 담당자가 입력된 카드가 정상적으로 표시된다`() = runComposeUiTest {
        val title = Title("LazyColumn 컴포넌트 구현")
        val crew = Crew("다이노")

        setContent {
            KanbanCard(
                title = title,
                crew = crew,
            )
        }

        onNodeWithText(title.text).assertIsDisplayed()
        onNodeWithText(crew.name).assertIsDisplayed()
    }
}
