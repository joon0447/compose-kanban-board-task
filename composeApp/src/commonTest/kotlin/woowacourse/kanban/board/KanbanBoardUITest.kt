package woowacourse.kanban.board

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.runComposeUiTest
import woowacourse.kanban.board.constant.*
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class KanbanBoardUITest {
    @Test
    fun `모든 정보가 입력된 경우 - 제목, 본문, 태그, 작성자 컴포넌트 모두 생성`() = runComposeUiTest {
        val card = CardData.createCard(
            title = "제목",
            content = "본문",
            tags = listOf("태그1", "태그2"),
            writer = "작성자"
        )

        setContent {
            KanbanBoardCard(Modifier, card)
        }

        onNodeWithTag(CARD_BODY_TEST, useUnmergedTree = true).assertExists()
        onNodeWithTag(CARD_TITLE_TEST, useUnmergedTree = true).assertExists()
        onNodeWithTag(CARD_CONTENT_TEST, useUnmergedTree = true).assertExists()
        onNodeWithTag(CARD_TAGS_TEST, useUnmergedTree = true).assertExists()
        onNodeWithTag(CARD_WRITER_TEST, useUnmergedTree = true).assertExists()
    }

    @Test
    fun `본문이 생략된 경우 - 제목, 태그, 작성자 컴포넌트 생성`() = runComposeUiTest {
        val card = CardData.createCard(
            title = "제목",
            tags = listOf("태그1", "태그2"),
            writer = "작성자"
        )

        setContent {
            KanbanBoardCard(Modifier, card)
        }

        onNodeWithTag(CARD_BODY_TEST, useUnmergedTree = true).assertExists()
        onNodeWithTag(CARD_TITLE_TEST, useUnmergedTree = true).assertExists()
        onNodeWithTag(CARD_CONTENT_TEST, useUnmergedTree = true).assertDoesNotExist()
        onNodeWithTag(CARD_TAGS_TEST, useUnmergedTree = true).assertExists()
        onNodeWithTag(CARD_WRITER_TEST, useUnmergedTree = true).assertExists()
    }

    @Test
    fun `태그가 생략된 경우 - 제목, 본문, 작성자 컴포넌트만 생성`() = runComposeUiTest {
        val card = CardData.createCard(
            title = "제목",
            content = "본문",
            writer = "작성자"
        )

        setContent {
            KanbanBoardCard(Modifier, card)
        }

        onNodeWithTag(CARD_BODY_TEST, useUnmergedTree = true).assertExists()
        onNodeWithTag(CARD_TITLE_TEST, useUnmergedTree = true).assertExists()
        onNodeWithTag(CARD_CONTENT_TEST, useUnmergedTree = true).assertExists()
        onNodeWithTag(CARD_TAGS_TEST, useUnmergedTree = true).assertDoesNotExist()
        onNodeWithTag(CARD_WRITER_TEST, useUnmergedTree = true).assertExists()
    }

    @Test
    fun `본문, 태그가 생략된 경우 - 제목, 작성자 컴포넌트만 생성`() = runComposeUiTest {
        val card = CardData.createCard(
            title = "제목",
            writer = "작성자"
        )

        setContent {
            KanbanBoardCard(Modifier, card)
        }

        onNodeWithTag(CARD_BODY_TEST, useUnmergedTree = true).assertExists()
        onNodeWithTag(CARD_TITLE_TEST, useUnmergedTree = true).assertExists()
        onNodeWithTag(CARD_CONTENT_TEST, useUnmergedTree = true).assertDoesNotExist()
        onNodeWithTag(CARD_TAGS_TEST, useUnmergedTree = true).assertDoesNotExist()
        onNodeWithTag(CARD_WRITER_TEST, useUnmergedTree = true).assertExists()
    }
}