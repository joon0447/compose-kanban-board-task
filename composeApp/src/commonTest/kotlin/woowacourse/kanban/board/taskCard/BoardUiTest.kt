package woowacourse.kanban.board.taskCard

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class BoardUiTest {
    @Test
    fun `전달한 제목, 본문, 태그들, 담당자명이 올바르게 표시된다`() = runComposeUiTest {
        // given
        val taskInfo = TaskInfo(
            title = "제목이 잘 보여질 거에요.",
            contents = "본문이 잘 보여질 거에요.",
            tags = listOf(Tag("잘 보여질"), Tag("태그")),
            contactName = "담당자 명이 잘 보여질 거에요.",
        )
        // when
        setContent {
            TaskCard(taskInfo = taskInfo, modifier = Modifier)
        }
        // then
        onNodeWithText("제목이 잘 보여질 거에요.").assertIsDisplayed()
        onNodeWithText("본문이 잘 보여질 거에요.").assertIsDisplayed()
        onNodeWithText("담당자 명이 잘 보여질 거에요.").assertIsDisplayed()

        onNodeWithText("잘 보여질").assertIsDisplayed()
        onNodeWithText("태그").assertIsDisplayed()
    }

    @Test
    fun `본문에 null이 전달되면 본문 영역이 노출되지 않는다`() = runComposeUiTest {
        // given
        val taskInfo = TaskInfo(
            title = "제목이 잘 보여질 거에요.",
            contents = null,
            tags = listOf(Tag("잘 보여질"), Tag("태그")),
            contactName = "담당자 명이 잘 보여질 거에요.",
        )

        // when
        setContent {
            TaskCard(taskInfo = taskInfo, modifier = Modifier)
        }

        // then
        onNodeWithText("제목이 잘 보여질 거에요.").assertIsDisplayed()
        onNodeWithText("본문이 잘 보여질 거에요.").assertDoesNotExist()
        onNodeWithText("담당자 명이 잘 보여질 거에요.").assertIsDisplayed()

        onNodeWithText("잘 보여질").assertIsDisplayed()
        onNodeWithText("태그").assertIsDisplayed()
    }

    @Test
    fun `태그리스트에 null이 전달되면 태그 영역이 노출되지 않는다`() = runComposeUiTest {
        // given
        val taskInfo = TaskInfo(
            title = "제목이 잘 보여질 거에요.",
            tags = null,
            contactName = "담당자 명이 잘 보여질 거에요.",
        )

        // when
        setContent {
            TaskCard(taskInfo = taskInfo, modifier = Modifier)
        }

        // then
        onNodeWithText("제목이 잘 보여질 거에요.").assertIsDisplayed()
        onNodeWithText("담당자 명이 잘 보여질 거에요.").assertIsDisplayed()

        onNodeWithText("잘 보여질").assertDoesNotExist()
        onNodeWithText("태그").assertDoesNotExist()
    }

    @Test
    fun `담당자명에 null이 전달되면 담당자 영역이 노출되지 않는다`() = runComposeUiTest {
        // given
        val taskInfo = TaskInfo(
            title = "제목이 잘 보여질 거에요.",
            contactName = null,
        )
        // when
        setContent {
            TaskCard(taskInfo = taskInfo, modifier = Modifier)
        }
        // then
        onNodeWithText("제목이 잘 보여질 거에요.").assertIsDisplayed()
        onNodeWithText("담당자 명이 잘 보여질 거에요.").assertDoesNotExist()
    }
}