package woowacourse.kanban.board

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import woowacourse.kanban.board.model.BoardComponent
import woowacourse.kanban.board.model.DEFAULT_CONTENT
import woowacourse.kanban.board.model.DEFAULT_NAME
import woowacourse.kanban.board.model.DEFAULT_TITLE
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class BoardTest {

    @Test
    fun `모든 필드가 있는 카드`() = runComposeUiTest {
        // given
        val board = BoardComponent(
            title = DEFAULT_TITLE,
            content = DEFAULT_CONTENT,
            tags = listOf("컴포넌트", "성능"),
            name = DEFAULT_NAME
        )

        setContent {
            KanbanBoardTemplate(
                title = board.title,
                content = board.content,
                tags = board.tags,
                name = board.name
            )
        }
        // when

        // then
        onNodeWithText("LazyColumn 컴포넌트 구현").assertExists()
        onNodeWithText("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.").assertExists()
        onNodeWithText("컴포넌트").assertExists()
        onNodeWithText("성능").assertExists()
        onNodeWithText("다이노").assertExists()
    }

    @Test
    fun `중간 내용 필드만 없는 카드`() = runComposeUiTest {
        // given
        val board = BoardComponent(
            title = DEFAULT_TITLE,
            tags = listOf("컴포넌트", "성능"),
            name = DEFAULT_NAME
        )

        setContent {
            KanbanBoardTemplate(
                title = board.title,
                content = board.content,
                tags = board.tags,
                name = board.name
            )
        }
        // when

        // then
        onNodeWithText("LazyColumn 컴포넌트 구현").assertExists()
        onNodeWithText("컴포넌트").assertExists()
        onNodeWithText("성능").assertExists()
        onNodeWithText("다이노").assertExists()
    }

    @Test
    fun `태그 필드만 없는 카드`() = runComposeUiTest {
        // given
        val board = BoardComponent(
            title = DEFAULT_TITLE,
            content = DEFAULT_CONTENT,
            name = DEFAULT_NAME
        )

        setContent {
            KanbanBoardTemplate(
                title = board.title,
                content = board.content,
                tags = board.tags,
                name = board.name
            )
        }
        // when

        // then
        onNodeWithText("LazyColumn 컴포넌트 구현").assertExists()
        onNodeWithText("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.").assertExists()
        onNodeWithText("다이노").assertExists()
    }

    @Test
    fun `중간 내용과 태그 필드가 없는 카드`() = runComposeUiTest {
        // given
        val board = BoardComponent(
            title = DEFAULT_TITLE,
            name = DEFAULT_NAME
        )

        setContent {
            KanbanBoardTemplate(
                title = board.title,
                content = board.content,
                tags = board.tags,
                name = board.name
            )
        }
        // when

        // then
        onNodeWithText("LazyColumn 컴포넌트 구현").assertExists()
        onNodeWithText("다이노").assertExists()
    }
}

