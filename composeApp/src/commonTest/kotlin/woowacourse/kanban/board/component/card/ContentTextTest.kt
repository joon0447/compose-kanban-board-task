package woowacourse.kanban.board.component.card

import androidx.compose.ui.semantics.SemanticsActions.GetTextLayoutResult
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performSemanticsAction
import androidx.compose.ui.test.runComposeUiTest
import androidx.compose.ui.text.TextLayoutResult
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalTestApi::class)
class ContentTextTest {
    @Test
    fun `본문이 정상적으로 표시된다`() = runComposeUiTest {
        val content = "안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다."

        setContent {
            ContentText(content)
        }

        onNodeWithText(content).assertIsDisplayed()
    }

    @Test
    fun `본문이 길다면 오버플로우 UI가 정상적으로 표시된다`() = runComposeUiTest {
        val content = "안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. " +
                "안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다." +
                "안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다." +
                "안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다." +
                "안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다." +
                "안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다."

        setContent {
            ContentText(content)
        }

        val textLayoutResult = mutableListOf<TextLayoutResult>()

        onNodeWithText(content).performSemanticsAction(GetTextLayoutResult) {
            it(textLayoutResult)
        }

        assertEquals(textLayoutResult.first().isLineEllipsized(1), true)
    }

    @Test
    fun `본문이 아무리 길어도 두 줄로 표시된다`() = runComposeUiTest {
        val content = "안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. " +
                "안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다." +
                "안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다." +
                "안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다." +
                "안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다." +
                "안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다. 안녕하세요 본문입니다."

        setContent {
            ContentText(content)
        }

        val textLayoutResult = mutableListOf<TextLayoutResult>()

        onNodeWithText(content).performSemanticsAction(GetTextLayoutResult) {
            it(textLayoutResult)
        }

        assertEquals(textLayoutResult.first().lineCount, 2)
    }
}
