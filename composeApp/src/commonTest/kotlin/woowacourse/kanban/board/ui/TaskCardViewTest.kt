package woowacourse.kanban.board.ui

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import woowacourse.kanban.board.model.Tag
import woowacourse.kanban.board.model.TaskCard

@OptIn(ExperimentalTestApi::class)
class TaskCardViewTest {

    @Test
    fun `제목이_표시된다`() = runComposeUiTest {
        setContent {
            TaskCardView(
                taskCard = TaskCard(title = "LazyColumn 컴포넌트 구현", assignee = "다이노"),
            )
        }

        onNodeWithText("LazyColumn 컴포넌트 구현").assertIsDisplayed()
    }

    @Test
    fun `담당자가_표시된다`() = runComposeUiTest {
        setContent {
            TaskCardView(
                taskCard = TaskCard(title = "LazyColumn 컴포넌트 구현", assignee = "다이노"),
            )
        }

        onNodeWithText("다이노").assertIsDisplayed()
    }

    @Test
    fun `설명이_있으면_표시된다`() = runComposeUiTest {
        setContent {
            TaskCardView(
                taskCard = TaskCard(
                    title = "LazyColumn 컴포넌트 구현",
                    description = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                    assignee = "다이노",
                ),
            )
        }

        onNodeWithText("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.", substring = true)
            .assertIsDisplayed()
    }

    @Test
    fun `설명이_없으면_설명_텍스트가_존재하지_않는다`() = runComposeUiTest {
        setContent {
            TaskCardView(
                taskCard = TaskCard(title = "LazyColumn 컴포넌트 구현", assignee = "다이노"),
            )
        }

        onNodeWithText("세로 스크롤", substring = true).assertDoesNotExist()
    }

    @Test
    fun `태그가_있으면_모두_표시된다`() = runComposeUiTest {
        setContent {
            TaskCardView(
                taskCard = TaskCard(
                    title = "LazyColumn 컴포넌트 구현",
                    tags = listOf(Tag("컴포넌트"), Tag("성능")),
                    assignee = "다이노",
                ),
            )
        }

        onNodeWithText("컴포넌트").assertIsDisplayed()
        onNodeWithText("성능").assertIsDisplayed()
    }

    @Test
    fun `태그가_없으면_태그가_표시되지_않는다`() = runComposeUiTest {
        setContent {
            TaskCardView(
                taskCard = TaskCard(title = "LazyColumn 컴포넌트 구현", assignee = "다이노"),
            )
        }

        onNodeWithText("컴포넌트").assertDoesNotExist()
        onNodeWithText("성능").assertDoesNotExist()
    }

    @Test
    fun `모든_요소가_있는_카드가_정상_표시된다`() = runComposeUiTest {
        setContent {
            TaskCardView(
                taskCard = TaskCard(
                    title = "LazyColumn 컴포넌트 구현",
                    description = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                    tags = listOf(Tag("컴포넌트"), Tag("성능")),
                    assignee = "다이노",
                ),
            )
        }

        onNodeWithText("LazyColumn 컴포넌트 구현").assertIsDisplayed()
        onNodeWithText("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.", substring = true)
            .assertIsDisplayed()
        onNodeWithText("컴포넌트").assertIsDisplayed()
        onNodeWithText("성능").assertIsDisplayed()
        onNodeWithText("다이노").assertIsDisplayed()
    }
}
